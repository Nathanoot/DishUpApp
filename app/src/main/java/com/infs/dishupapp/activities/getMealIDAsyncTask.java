package com.infs.dishupapp.activities;

import android.os.AsyncTask;

import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.models.Recipe;

public class getMealIDAsyncTask extends AsyncTask<Integer, Integer, Recipe> {

    private AsyncTaskRecipes delegate;
    private AppDataBase db;

    public void setDelegate(AsyncTaskRecipes delegate) {
        this.delegate = delegate;
    }

    public void setDb(AppDataBase db) {
        this.db = db;
    }

    @Override
    protected Recipe doInBackground(Integer... integers) {
        return db.recipeDao().getMealID( integers[0] );
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}
