package com.infs.dishupapp.activities;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ScoreDao {
    //Obtaining score
    @Insert
    void insert(int score);

    @Query("UPDATE AVATAR SET score= :addscore + :currentscore" )
    public void totalScore (int addscore, int currentscore);




}
