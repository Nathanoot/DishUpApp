package com.infs.dishupapp.models;

import java.util.ArrayList;

public class Meals {

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
