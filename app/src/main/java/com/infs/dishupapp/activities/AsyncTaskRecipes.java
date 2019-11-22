package com.infs.dishupapp.activities;

import com.infs.dishupapp.models.Recipe;

public interface AsyncTaskRecipes {
    void handleGetRecipeId(Recipe idMeal);
    void handlInsertRecipe(String result);
}
