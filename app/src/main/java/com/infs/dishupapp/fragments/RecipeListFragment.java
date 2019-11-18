package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
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
        return view;
    }


    public void newCategoryItemActivity() {

        final CategoryListAdapter categoryListAdapter = new CategoryListAdapter();
        Fragment fragment = new RecipeListFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        final CategoryFragment categoryFragment = new CategoryFragment();

        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url2 = "http://www.themealdb.com/api/json/v1/1/filter.php?c=" + categoryFragment.getCategory();


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        CategoryItem[] categoryItem = gson.fromJson(response, CategoryItem[].class);
                        List<CategoryItem> itemCategory = Arrays.asList(categoryItem);
                        categoryListAdapter.setData(itemCategory);
                        recyclerView.setAdapter(categoryListAdapter);
                        //   FakeDatabase.saveArticlesToFakeDatabase(articleCat);
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
    }
}
