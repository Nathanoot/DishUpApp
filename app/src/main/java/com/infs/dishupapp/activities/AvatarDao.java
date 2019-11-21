package com.infs.dishupapp.activities;

import androidx.room.Insert;
import androidx.room.Query;

import com.infs.dishupapp.models.Avatar;

import java.util.List;

public interface AvatarDao {
    @Query("SELECT * FROM avatar")
        List<Avatar> getAvatarbyUsername (String username);
    //add scores to existing scores
    @Query("UPDATE AVATAR SET score = (:addPoints + :currentScore)")
    public void addPoints(int addPoints,int currentScore);




}
