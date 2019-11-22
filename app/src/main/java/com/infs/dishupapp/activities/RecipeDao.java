package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.infs.dishupapp.models.Recipe;

@Dao
public interface RecipeDao {

// get all meal names per id
    @Query("SELECT * FROM Recipe WHERE idMeal=:idMeal")
   Recipe getMealID (int idMeal);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Recipe recipes);

}

