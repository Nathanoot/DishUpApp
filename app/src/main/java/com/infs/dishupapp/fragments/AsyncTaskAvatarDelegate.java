package com.infs.dishupapp.fragments;

import com.infs.dishupapp.models.Avatar;

import java.util.List;

public interface AsyncTaskAvatarDelegate {

    void handleInsertUserResult(String result);
    void handleGetUserResult(Avatar avatar);
    void handleGetAllUsersResult(List<Avatar> avatars);
    void handleGetUsernamesResult(List<String> avatars);
    void handleGetUserByUserName(Avatar avatar);
    void handleInsertPoints(String result);

}
