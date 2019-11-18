package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.infs.dishupapp.models.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {

//list all recipes from the API
    @Query("SELECT * FROM meals")
    List<Recipe> getAll();

    //finding recipes by ID?
    @Query("SELECT * FROM meals WHERE idMeal = :idMeal")
    Recipe findRecipeByidMeal(String idMeal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Recipe> recipes);
}

