package com.infs.dishupapp.activities;

import android.os.AsyncTask;

import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.models.Recipe;

public class InsertRecipeAsyncTask extends AsyncTask<Recipe,Integer, String> {
    private AsyncTaskRecipes delegate;
    private AppDataBase db;

    public void setDelegate(AsyncTaskRecipes delegate) {
        this.delegate = delegate;
    }

    public void setDb(AppDataBase db) {
        this.db = db;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Recipe... recipes) {
        db.recipeDao().insertAll(recipes[0]);
        return "Meal Added";

    }


}
