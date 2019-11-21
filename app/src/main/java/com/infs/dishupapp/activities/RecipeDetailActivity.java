package com.infs.dishupapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.infs.dishupapp.R;
import com.infs.dishupapp.models.Meals;

public class RecipeDetailActivity extends AppCompatActivity {

    private TextView mealName;
    private TextView mealCategory;
    private TextView mealInstructions;
    private TextView ingredientOne;
    private TextView ingredientTwo;
    private TextView ingredientThree;
    private TextView ingredientFour;
    private TextView measureOne;
    private TextView measureTwo;
    private TextView measureThree;
    private Button addToScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        mealName = findViewById(R.id.mealName);
        mealCategory = findViewById(R.id.mealName);
        mealInstructions = findViewById(R.id.mealInstructions);
        ingredientOne = findViewById(R.id.ingredientOne);
        ingredientTwo = findViewById(R.id.ingredientTwo);
        ingredientThree = findViewById(R.id.ingredientThree);
        ingredientFour = findViewById(R.id.ingredientFour);
        measureOne = findViewById(R.id.measureOne);
        measureTwo = findViewById(R.id.measureTwo);
        measureThree = findViewById(R.id.measureThree);
        addToScore= findViewById( R.id.addToScore );

     //   addToScore.setOnClickListener(new View.OnClickListener() {
     //       @Override
       //     public void onClick(View v) {
           //     Avatar.addToScoreMethod();
       //         Toast.makeText(getApplicationContext(), "Score has been added, return back",Toast.LENGTH_LONG).show();
      //      }
    //    });

        Intent intent = getIntent();
        int idMeal = intent.getIntExtra("idMeal", 52772);
        String url2 = "https://www.themealdb.com/api/json/v1/1/lookup.php?i=" + idMeal;

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson ();
                        Meals meals = gson.fromJson(response, Meals.class);


                     //   List<Recipe> recipes = recipeMeal.meals;

//
//                              for (int i = 0; i < recipes.size(); i++) {
//                                  System.out.println(recipes.get(i));
//                              }

//
                        mealName.setText(meals.getStrMeal());
//                        mealCategory.setText(recipe.getStrCategory());
//                        mealInstructions.setText(recipe.getStrInstructions());
//                        ingredientOne.setText(recipe.getStrIngredient1());
//                        ingredientTwo.setText(recipe.getStrIngredient2());
//                        ingredientThree.setText(recipe.getStrIngredient3());
//                        ingredientFour.setText(recipe.getStrIngredient4());
//                        measureOne.setText(recipe.getStrMeasure1());
//                        ingredientOne.setText(recipe.getStrMeasure2());
//                        ingredientOne.setText(recipe.getStrMeasure3());


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                System.out.println("Error");
            }

//           public void getClicks(){
//               @Override
//            addToScore.OnClickListene(new View.OnClickListener(){
//                @Override
//                        public void onClick(View view){
//                    clickcount=clickcount+1;
//                    if(clickcount==1){
//                        Toast.makeText(getApplicationContext(),"Button clicked first time!", Toast.LENGTH_LONG).show();
//                    }
//                    else
//                    {
//                        Toast.makeText(getApplicationContext(),"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();
//                    }
//
//                }
//                });
//           }

        });

        queue.add(stringRequest);


    }


}
