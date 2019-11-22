package com.infs.dishupapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Score {
    @PrimaryKey
    private int score=0;
    private int addscore;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
