package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
        final View view = inflater.inflate(R.layout.fragment_category, container, false);
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
                Bundle bundle = new Bundle();
                bundle.putString("category", "Beef");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);

            }
        });

        breakfastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Breakfast");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        chickenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Chicken");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Dessert");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        porkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Pork");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        seafoodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Seafood");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        veganButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Vegan");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });
        vegetarianButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("category", "Vegetarian");
                Fragment fragment = new RecipeListFragment();
                fragment.setArguments(bundle);
                swapFragment(fragment);
            }
        });

        return view;

      }
    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
    public String getCategory() {
        return category;
    }

    }

