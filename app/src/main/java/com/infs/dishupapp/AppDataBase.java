package com.infs.dishupapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.infs.dishupapp.activities.AvatarDao;
import com.infs.dishupapp.activities.RecipeDao;
import com.infs.dishupapp.models.Recipe;

@Database(entities = {Recipe.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {

    public abstract AvatarDao avatarDao();
    public abstract RecipeDao recipeDao();

    private static AppDataBase instance;
    public static AppDataBase getInstance(Context context){
        if(instance==null){
           //need to double check what the DB is called in the API as it is not recDB
            instance= Room.databaseBuilder(context, AppDataBase.class, "themealdb").build();
        }
        return instance;

    }
}
