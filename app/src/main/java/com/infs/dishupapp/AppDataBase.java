package com.infs.dishupapp;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.infs.dishupapp.interfaces.NoteDao;
import com.infs.dishupapp.models.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    // Turn the class into a singleton, so program can only use the current instance and can't
    // create multiple instances of the db.
    private static AppDataBase instance;

    //    public abstract RecipeDao recipeDao();
    public abstract NoteDao noteDao();


    // One thread at a time can access the singleton, so two instances of this db won't be created.
    // Returns a new instance of the db, and if version gets updated will delete the table and re-add
    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "themealdb")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;

    }

    // Populate db, right when the db note_table is created
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    // Async task populating the note_table db
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private NoteDao noteDao;

        private PopulateDbAsyncTask(AppDataBase db) {
            noteDao = db.noteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDao.insert(new Note("Potential Recipe Name", "Thoughts on trying it again.", 4));
            noteDao.insert(new Note("Shopping list", "Ingredients", 2));
            return null;
        }
    }
}