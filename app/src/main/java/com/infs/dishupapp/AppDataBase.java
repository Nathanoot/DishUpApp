package com.infs.dishupapp;

//import com.infs.dishupapp.activities.AvatarDao;
//import com.infs.dishupapp.activities.RecipeDao;
//import com.infs.dishupapp.models.Recipe;
//

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.infs.dishupapp.activities.RecipeDao;
import com.infs.dishupapp.activities.ScoreDao;
import com.infs.dishupapp.interfaces.NoteDao;
import com.infs.dishupapp.models.Avatar;
import com.infs.dishupapp.models.Note;
import com.infs.dishupapp.models.Recipe;

@Database(entities = {Note.class, Recipe.class, Avatar.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    // Turn the class into a singleton, so we can only use the current instnace and can't create
    // multiple instances of the db.
    private static AppDataBase instance;
    public abstract RecipeDao recipeDao();
    public abstract NoteDao noteDao();
    public abstract ScoreDao scoreDao();

//    public abstract AvatarDao avatarDao();
//    public abstract RecipeDao recipeDao();

    // One thread at a time can access the singleton, so two instances of this db won't be created.

    // Returns a new instance of the db, and if version gets updated will delete the table and re-add
    public static synchronized AppDataBase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    AppDataBase.class, "themealdb")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();;
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
            noteDao.insert(new Note("Title 1", "Description 1", 1));
            noteDao.insert(new Note("Title 2", "Description 2", 2));
            noteDao.insert(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}

//import android.content.Context;
//import android.os.AsyncTask;
//
//import androidx.annotation.NonNull;
//import androidx.room.Database;
//import androidx.room.Room;
//import androidx.room.RoomDatabase;
//import androidx.sqlite.db.SupportSQLiteDatabase;
//
//import com.infs.dishupapp.interfaces.NoteDao;
//
//@Database(entities = {Note.class}, version = 1)
//public abstract class NoteDatabase extends RoomDatabase {
//
//    // Turn the class into a singleton, so we can only use the current instnace and can't create
//// multiple instances of the db.
//    private static NoteDatabase instance;
//
//    public abstract NoteDao noteDao();
//
//    // One thread at a time can access the singleton, so two instances of this db won't be created.
//
//    // Returns a new instance of the db, and if version gets updated will delete the table and re-add
//    public static synchronized NoteDatabase getInstance(Context context) {
//        if (instance == null) {
//            instance = Room.databaseBuilder(context.getApplicationContext(),
//                    NoteDatabase.class, "note_database")
//                    .fallbackToDestructiveMigration()
//                    .addCallback(roomCallback)
//                    .build();
//        }
//        return instance;
//    }
//
//    // Populate db, right when the db note_table is created
//    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDbAsyncTask(instance).execute();
//        }
//    };
//
//    // Async task populating the note_table db
//    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private NoteDao noteDao;
//
//        private PopulateDbAsyncTask(NoteDatabase db) {
//            noteDao = db.noteDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            noteDao.insert(new Note("Title 1", "Description 1", 1));
//            noteDao.insert(new Note("Title 2", "Description 2", 2));
//            noteDao.insert(new Note("Title 3", "Description 3", 3));
//            return null;
//        }
//    }
//}