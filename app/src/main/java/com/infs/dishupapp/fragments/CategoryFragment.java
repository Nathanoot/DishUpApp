package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.infs.dishupapp.R;

public class CategoryFragment extends Fragment {

    public ImageButton beefButton;
    public ImageButton breakfastButton;
    public ImageButton chickenButton;
    public ImageButton dessertButton;
    public ImageButton porkButton;
    public ImageButton seafoodButton;
    public ImageButton veganButton;
    public ImageButton vegetarianButton;
    public String category;


    public CategoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category, container, false);
        beefButton = view.findViewById(R.id.imageBeef);
        breakfastButton = view.findViewById(R.id.imageBreakfast);
        chickenButton = view.findViewById(R.id.imageChicken);
        dessertButton = view.findViewById(R.id.imageDessert);
        porkButton = view.findViewById(R.id.imagePork);
        seafoodButton = view.findViewById(R.id.imageSeafood);
        veganButton = view.findViewById(R.id.imageVegan);
        vegetarianButton = view.findViewById(R.id.imageVegetarian);
        final RecipeListFragment recipe = new RecipeListFragment();
        Toast.makeText(getActivity(), "Choose your Category", Toast.LENGTH_LONG).show();
//      All buttons send a category value through a bundle to the RecipeList Fragment
//      Upon clicking any of the buttons, swap to the RecipeListFragment
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

