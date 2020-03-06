package com.example.commentsappdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.commentsappdemo.model.CommentDAO;
import com.example.commentsappdemo.model.Comments;
import com.example.commentsappdemo.model.DataBaseComments;


import java.util.List;

public class CommentsViewModel extends AndroidViewModel {

    private final LiveData<List<Comments>> COMMENTS;

    private DataBaseComments database;

    public CommentsViewModel(@NonNull Application application) {
        super(application);

        database = DataBaseComments.getSharedInstance(application);
        COMMENTS = database.getCommandDAO().getAllComments();

    }

    public LiveData<List<Comments>> getCOMMENTS() {
        return COMMENTS;

    }

    public void insertComment(Comments c) {

        DataBaseComments.dbExecuter.execute(new Runnable() {
            @Override
            public void run() {
                database.getCommandDAO().insertComment(c);
            }
        });

    }
}
