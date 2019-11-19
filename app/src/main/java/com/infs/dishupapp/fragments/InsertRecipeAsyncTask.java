package com.infs.dishupapp.fragments;

import android.os.AsyncTask;

import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.models.Recipe;

class InsertRecipeAsyncTask extends AsyncTask<Recipe,Integer, String> {
private AsyncTaskInsertDelegate delegate;
private AppDataBase database;

    @Override
    protected String doInBackground(Recipe... recipes) {

    }
}
