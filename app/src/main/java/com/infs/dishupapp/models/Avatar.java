package com.infs.dishupapp.models;

import android.widget.ImageView;

public class Avatar {
    private String name;
    private int score = 0;
    private ImageView character;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToScoreMethod() {
        score++;
        System.out.println("Score has increased by 1");
    }
}

