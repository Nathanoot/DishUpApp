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
    @Query("SELECT * FROM recipe")
    List<Recipe> getAll();

    //finding recipes by ID?
    @Query("SELECT * FROM recipe WHERE idMeal = :idMeal")
    Recipe findRecipeByidMeal(int idMeal);
   //get image per id
    @Query("SELECT strMealThumb FROM recipe WHERE idMeal=:idMeal")
    Recipe findFoodPic (int idMeal);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Recipe> recipes);

}

