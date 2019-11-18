package com.infs.dishupapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.infs.dishupapp.R;

public class CategoryFragment extends Fragment {
   public ImageButton beef;
   public ImageButton breakfast;
   public ImageButton chicken;
   public ImageButton dessert;
   public ImageButton pork;
   public ImageButton seafood;
   public ImageButton vegan;
   public ImageButton vegetarian;

    public CategoryFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate( R.layout.fragment_category, container, false );
        //set up xml links
        beef= view.findViewById( R.id.imageButton );
        breakfast=view.findViewById( R.id.imageButton2 );
        chicken=view.findViewById( R.id.imageButton3 );
        dessert= view.findViewById( R.id.imageButton4 );
        pork= view.findViewById( R.id.imageButton5 );
        seafood= view.findViewById( R.id.imageButton6 );
        vegan= view.findViewById( R.id.imageButton7 );
        vegetarian= view.findViewById( R.id.imageButton8 );
        //set up onClick listener that takes into the recipe fragment
        //you want to click on imagebutton takes u to recipie list fragment
        //when it takes you to recipe fragment must match category
        beef.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        breakfast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        chicken.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        dessert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        pork.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        seafood.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        vegan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );
        vegetarian.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                Context context= view.getContext();
                Intent intent= new Intent(context, RecipeListFragment.class);
                context.startActivity(intent);
            }
        } );



        return view;


    }

}
