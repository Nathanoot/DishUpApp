package com.infs.dishupapp.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.infs.dishupapp.AppDataBase;
import com.infs.dishupapp.interfaces.ScoreDao;
import com.infs.dishupapp.models.Note;
import com.infs.dishupapp.models.Score;

import java.util.List;

public class ScoreRepository {
    private ScoreDao scoreDao;
    private LiveData<List<Score>> allScores;
//
//    public ScoreRepository(Application application) {
//        AppDataBase database = AppDataBase.getInstance(application);
//        scoreDao = database.scoreDao();
//        allScores = scoreDao.getAllScores();
//    }


}
