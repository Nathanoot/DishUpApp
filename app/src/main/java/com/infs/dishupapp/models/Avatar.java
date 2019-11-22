package com.infs.dishupapp.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Avatar {

    @PrimaryKey
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
}

