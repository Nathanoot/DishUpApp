package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.infs.dishupapp.R;

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
        final RecipeListFragment recipe = new RecipeListFragment();


        beefButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Beef";
                recipe.newCategoryItemActivity();
            }
        });

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Breakfast";
                recipe.newCategoryItemActivity();
            }
        });

        chickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Chicken";
                recipe.newCategoryItemActivity();
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Dessert";
                recipe.newCategoryItemActivity();
            }
        });

        porkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Pork";
                recipe.newCategoryItemActivity();
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Seafood";
                recipe.newCategoryItemActivity();
            }
        });

        veganButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Vegan";
                recipe.newCategoryItemActivity();
            }
        });
        vegetarianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                category = "Vegetarian";
                recipe.newCategoryItemActivity();
            }
        });

        return view;

      }

    public String getCategory() {
        return category;
    }

    }

