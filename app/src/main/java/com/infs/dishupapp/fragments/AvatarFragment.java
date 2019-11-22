package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.infs.dishupapp.R;
import com.infs.dishupapp.activities.RecipeDetailActivity;
import com.infs.dishupapp.models.Score;

import java.util.ArrayList;

public class AvatarFragment extends Fragment {
    private TextView name;
    private ProgressBar progressBar;
    private ImageView character;
    private TextView score;
    private Button button;

    public AvatarFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        character= view.findViewById( R.id.imageAvatar);
        button = view.findViewById(R.id.buttonToCategory);
        score=view.findViewById( R.id.score );

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CategoryFragment();
                swapFragment(fragment);

            }
        });
        //setting up scoring system
        final Score s= new Score();
        if(s.getScore()<2){
            character.setImageResource(R.drawable.baby);
        }
        else if(s.getScore()<4) {
            character.setImageResource( R.drawable.level2 );
        }
        else if(s.getScore()<6) {
            character.setImageResource( R.drawable.boy );
        }
        else if(s.getScore()<8){
            character.setImageResource( R.drawable.level4);
        }
        else {
            character.setImageResource( R.drawable.chef);
        }
        //setting up the horizontal progress bar
        progressBar=view.findViewById( R.id.progressBar );
        score=view.findViewById( R.id.score );
        final RecipeDetailActivity rcp= new RecipeDetailActivity();
        progressBar.setMax(10);
        progressBar.setProgress(rcp.setAddToScore());


        //counting the scores
        //someone set the count scores in the recipe part
        //if button is clicked, then score++
return view;
    }



    private void swapFragment(Fragment fragment) {
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();


    }
    }

