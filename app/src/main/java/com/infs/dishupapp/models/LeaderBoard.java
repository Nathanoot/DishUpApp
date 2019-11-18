package com.infs.dishupapp.models;

import android.widget.ImageView;

public class LeaderBoard {
    private String username;
    private String score;
    private ImageView icon;
    private String rank;

    public String getUsername() {
        return username;
    }

    public String getScore() {
        return score;
    }

    public ImageView getIcon() {
        return icon;
    }

    public String getRank() {
        return rank;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setIcon(ImageView icon) {
        this.icon = icon;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
