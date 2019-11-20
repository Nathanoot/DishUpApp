package com.infs.dishupapp.fragments;

import android.os.AsyncTask;

import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.models.Recipe;

import java.util.Arrays;

class InsertRecipeAsyncTask extends AsyncTask<Recipe,Integer, String> {
private AsyncTaskInsertDelegate delegate;
private AppDataBase database;

    @Override
    protected String doInBackground(Recipe... recipes) {
        database.recipeDao().insertAll( Arrays.asList(recipes) );

        return "This value will be passed to onPostExecute as the result parameter.";

    }
    @Override
    protected void onPostExecute(String result){
        delegate.handleTaskResult( result );
    }
}
