package com.infs.dishupapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.infs.dishupapp.R;
import com.infs.dishupapp.models.Avatar;

public class AvatarFragment extends Fragment {
    private TextView name;
    private TextView score;
    private ImageView character;

    public AvatarFragment(){
    }
    @NonNull
    @Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_avatar, container, false);
        name= view.findViewById(R.id.userName);
        character= view.findViewById( R.id.imageAvatar);
        //setting up scoring system
        final Avatar avatar= new Avatar();
        if(avatar.getScore()<2){
            character.setImageResource(@drawable/baby.png );
        }


    }
    }

