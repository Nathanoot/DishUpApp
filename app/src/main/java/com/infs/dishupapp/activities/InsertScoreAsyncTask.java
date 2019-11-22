package com.infs.dishupapp.activities;

import android.os.AsyncTask;

import com.infs.dishupapp.AppDataBase;

public class InsertScoreAsyncTask extends AsyncTask<Object, Integer, String> {
    AppDataBase db;
    AsyncTaskAvatarDelegate delegate;

    public void setDb(AppDataBase db) {
        this.db = db;
    }

    public void setDelegate(AsyncTaskAvatarDelegate delegate) {
        this.delegate = delegate;
    }
    @Override
    protected void onPreExecute(){
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Object... params) {
        int currentscore= (int)params[0];
        int addscore= (int)params[1];

        db.scoreDao().totalScore( addscore, currentscore );


        return "points added";

    }
}
