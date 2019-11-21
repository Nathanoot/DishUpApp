package com.infs.dishupapp.models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class CategoryItem {

    @PrimaryKey
    @NonNull
    public int idCategory;
    public String strMeal;
    public String strMealThumb;


    public String getStrMeal() {
        return strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public int getIdCategory() {
        return idCategory;
    }
}