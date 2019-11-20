package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.R;
import com.infs.dishupapp.adapters.CategoryListAdapter;
import com.infs.dishupapp.models.CategoryItem;

import java.util.Arrays;
import java.util.List;

public class RecipeListFragment extends Fragment {

    public RecyclerView recyclerView;


    public RecipeListFragment() {


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recipe_list, container, false);
    recyclerView = view.findViewById(R.id.rvSearch);
    LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        final CategoryListAdapter categoryListAdapter = new CategoryListAdapter();

    //    Intent intent = getActivity().getIntent();
      //  String category = intent.getStringExtra("beef");


        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url2 = "https://www.themealdb.com/api/json/v1/1/filter.php?c=Beef";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        CategoryItem categoryItem = gson.fromJson(response, CategoryItem.class);
                        List<CategoryItem> itemCategory = Arrays.asList(categoryItem);
                        categoryListAdapter.setData(itemCategory);
                        recyclerView.setAdapter(categoryListAdapter);
                        AppDataBase db=AppDataBase.getInstance( getContext() );
                        InsertRecipeAsyncTask insertRecipeAsyncTask= new InsertRecipeAsyncTask();


                        System.out.println("This is the OnResponse");
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                System.out.println("Error");
            }
        });
        queue.add(stringRequest);




        return view;
}


    public void newCategoryItemActivity() {


    }


}
