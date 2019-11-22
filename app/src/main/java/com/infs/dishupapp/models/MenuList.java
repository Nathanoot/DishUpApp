package com.infs.dishupapp.models;

import java.util.ArrayList;


public class MenuList {
    //  Model that contains an arraylist of the Recipe object
//  Name of the ArrayList is called meals is same as the JSON
    public ArrayList<CategoryItem> meals;

    public ArrayList<CategoryItem> getResults() {
        return meals;
    }
}
