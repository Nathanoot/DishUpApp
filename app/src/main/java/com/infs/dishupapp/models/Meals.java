package com.infs.dishupapp.models;

import java.util.ArrayList;

public class Meals {
//  Model that contains an arraylist of the Recipe object
//  Name of the ArrayList is called meals is same as the JSON
    public ArrayList<Recipe> meals;

    public ArrayList<Recipe> getMeals() {
        return meals;
    }

    public void setMeals(ArrayList<Recipe> meals) {
        this.meals = meals;
    }

    public Meals(ArrayList<Recipe> meals) {
        this.meals = meals;
    }
}
