//package com.infs.dishupapp.fragments;
//
//import android.os.AsyncTask;
//
//import com.infs.dishupapp.AppDataBase;
//import com.infs.dishupapp.models.Recipe;
//
//import java.util.List;
//
//public class GetRecipeAsyncTask extends AsyncTask<Void, Integer, List<Recipe>> {
//
//    private AsyncTaskGetDelegate delegate;
//    private AppDataBase database;
//
//    public AsyncTaskGetDelegate getDelegate() {
//        return delegate;
//    }
//
//    public AppDataBase getDatabase() {
//        return database;
//    }
//
//    @Override
//    protected List<Recipe> doInBackground(Void... voids) {
//        return database.recipeDao().getAll();
//    }
//    @Override
//    protected void onPostExecute(List<Recipe> result){
//        delegate.handleTaskGetResult( result );
//    }
//}
