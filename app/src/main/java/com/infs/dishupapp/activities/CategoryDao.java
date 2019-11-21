package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.infs.dishupapp.models.CategoryItem;

import java.util.List;

import static android.icu.text.MessagePattern.ArgType.SELECT;

@Dao
public interface CategoryDao {
@Query("SELECT * FROM CATEGORYITEM")
    List<CategoryItem> getCategories();
//get category id
@Query("SELECT * FROM CATEGORYITEM WHERE idCategory=:idCategory")
CategoryItem getCategoryID(int idCategory);
//get category name
    @Query( "SELECT * FROM CategoryItem WHERE strMeal=:strMeal" )
    CategoryItem getCatergoryName(String strMeal);

    //insert list of categories
    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insertCategory (List<CategoryItem> categoryItems);
}
