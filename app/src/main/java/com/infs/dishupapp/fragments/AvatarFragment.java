package com.infs.dishupapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
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

public class AvatarFragment extends Fragment {
    private ProgressBar progressBar;
    private ImageView character;
    private TextView score;
    private Button button;
    private int recipeScore;

    public AvatarFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        character = view.findViewById(R.id.imageAvatar);
        button = view.findViewById(R.id.buttonToCategory);
        score = view.findViewById(R.id.score);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CategoryFragment();
                swapFragment(fragment);
            }
        });

        // Load score
        SharedPreferences myScore = getActivity().getSharedPreferences("cookingScare", Context.MODE_PRIVATE);
        recipeScore = myScore.getInt("recipeScore", 0);

        StringBuffer scoreString = new StringBuffer("Score:");
        scoreString.append(recipeScore);

        score.setText(scoreString);


        progressBar = view.findViewById(R.id.progressBar);

        progressBar.setProgress(recipeScore);

        setAvatar();
        return view;
        }

    private void swapFragment (Fragment fragment){
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void setAvatar() {
        if (recipeScore < 5) {
            character.setImageResource(R.drawable.baby);
            progressBar.setMax(5);
        } else if (recipeScore < 10) {
            character.setImageResource(R.drawable.level2);
            progressBar.setMax(10);
        } else if (recipeScore < 15) {
            character.setImageResource(R.drawable.boy);
            progressBar.setMax(15);
        } else if (recipeScore < 20) {
            character.setImageResource(R.drawable.level4);
            progressBar.setMax(20);
        } else {
            character.setImageResource(R.drawable.chef);
            progressBar.setMax(75);
        }
    }
}

