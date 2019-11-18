package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.infs.dishupapp.R;
import com.infs.dishupapp.activities.MainActivity;

public class CategoryFragment extends Fragment {

    public Button beefButton;
    public Button breakfastButton;
    public Button chickenButton;
    public Button dessertButton;
    public Button porkButton;
    public Button seafoodButton;
    public Button veganButton;
    public Button vegetarianButton;
    public String category;

    public CategoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        beefButton = view.findViewById(R.id.imageButton);
        breakfastButton = view.findViewById(R.id.imageButton2);
        chickenButton = view.findViewById(R.id.imageButton3);
        dessertButton = view.findViewById(R.id.imageButton4);
        porkButton = view.findViewById(R.id.imageButton5);
        seafoodButton = view.findViewById(R.id.imageButton6);
        veganButton = view.findViewById(R.id.imageButton7);
        vegetarianButton = view.findViewById(R.id.imageButton8);


        beefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Beef";
                newCategoryItemActivity();
            }
        });

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Breakfast";
                newCategoryItemActivity();
            }
        });

        chickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Chicken";
                newCategoryItemActivity();
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Dessert";
                newCategoryItemActivity();
            }
        });

        porkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Pork";
                newCategoryItemActivity();
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Seafood";
                newCategoryItemActivity();
            }
        });

        veganButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Vegan";
                newCategoryItemActivity();
            }
        });
        vegetarianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Vegetarian";
                newCategoryItemActivity();
            }
        });

        return view;

      }




      public void newCategoryItemActivity() {
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url2 = "http://www.themealdb.com/api/json/v1/1/filter.php?c=" + category;
        System.out.println(category);
        

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
      }

    }
}
