package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.infs.dishupapp.models.Meals;

@Dao
public interface MealDao {

    //Getting meal by meal name
    @Query("SELECT * FROM Recipe WHERE strMeal=:strMeal")
    Meals.Recipe getMealName(String strMeal);

    @Query ("SELECT * FROM Recipe where idMeal=: idMeal")
    Meals.Recipe getMealID(int idMeal);

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertMeal (Meals.Recipe meal);




}