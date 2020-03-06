package com.example.commentsappdemo.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(version = 1, entities = {Comments.class}, exportSchema = false)

public abstract class DataBaseComments extends RoomDatabase {

    private static DataBaseComments sharedInstance;

    public static DataBaseComments getSharedInstance(Context context) {
        if(sharedInstance == null)
            createDB(context);

        return sharedInstance;
    }

    private static void createDB(Context context) {

        sharedInstance = Room.databaseBuilder(context, DataBaseComments.class, "comments_db").build();

    }

    public abstract CommentDAO getCommandDAO();

    public static ExecutorService dbExecuter = Executors.newFixedThreadPool(4);

}

