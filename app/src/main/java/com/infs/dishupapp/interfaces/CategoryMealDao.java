package com.infs.dishupapp.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.infs.dishupapp.models.CategoryItem;


import java.util.List;

@Dao
public interface CategoryMealDao {

    // When getCategoryMeal method is called return the all the rows from table CategoryMeal
    @Query("SELECT * FROM CategoryMeal")
    List<CategoryItem.CategoryMeal> getCategoryMeal();

    // The onConflictStrategy determines how to handle when duplicate primary keys are inserted.
    // Without this, your app will only run once, and crash every time after because it keeps trying
    // to insert already existing primary keys.

    // Insert the list of all the categories available
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<CategoryItem.CategoryMeal> categoryMeal);

    // Delete the categories list (probably won't use)
    @Delete
    void delete(CategoryItem.CategoryMeal categoryMeal);
}
