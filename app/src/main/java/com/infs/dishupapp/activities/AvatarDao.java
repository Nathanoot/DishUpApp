package com.infs.dishupapp.activities;

import androidx.room.Insert;
import androidx.room.Query;

import com.infs.dishupapp.models.Avatar;

import java.util.List;

public interface AvatarDao {
    //getting username from DB
    @Query("SELECT * FROM avatar")
        List<Avatar> getAvatarbyUsername (String username);
    //Getting score





}
