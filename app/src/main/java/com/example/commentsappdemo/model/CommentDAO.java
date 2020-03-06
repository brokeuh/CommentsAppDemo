package com.example.commentsappdemo.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;



import java.util.List;


@Dao
public interface CommentDAO {

    @Insert
    void insertComment(Comments c);

    @Query(value = " SELECT * FROM Comments ")
    LiveData<List<Comments>> getAllComments ();



}
