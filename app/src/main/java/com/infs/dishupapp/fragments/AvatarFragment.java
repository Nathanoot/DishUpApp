package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.infs.dishupapp.R;
import com.infs.dishupapp.activities.RecipeDetailActivity;
import com.infs.dishupapp.models.Avatar;

public class AvatarFragment extends Fragment {
    private TextView name;
    private ProgressBar progressBar;
    private ImageView character;
    private TextView score;

    public AvatarFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        name= view.findViewById(R.id.userName);
        character= view.findViewById( R.id.imageAvatar);
        //setting up scoring system
        final Avatar avatar= new Avatar();
        if(avatar.getScore()<2){
            character.setImageResource(R.drawable.baby);
        }
        if(avatar.getScore()<4) {
            character.setImageResource( R.drawable.level2 );
        }
        if(avatar.getScore()<6) {
            character.setImageResource( R.drawable.boy );
        }
        if(avatar.getScore()<8){
            character.setImageResource( R.drawable.level4);
        }
        if(avatar.getScore()>9) {
            character.setImageResource( R.drawable.chef);
        }
        //setting up the horizontal progress bar
        progressBar=view.findViewById( R.id.progressBar );
        score=view.findViewById( R.id.score );
        progressBar.setMax(10);
        progressBar.setProgress(0);
        final RecipeDetailActivity rcp= new RecipeDetailActivity();
        progressBar.setProgress( rcp.getClicks());

        //counting the scores
        //someone set the count scores in the recipe part
        //if button is clicked, then score++




return view;
    }
    }

