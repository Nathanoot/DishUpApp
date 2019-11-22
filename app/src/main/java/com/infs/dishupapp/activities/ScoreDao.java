package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface ScoreDao {
    //Obtaining score
    @Insert
    void insert(int score);





}
