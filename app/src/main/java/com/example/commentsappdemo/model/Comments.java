package com.example.commentsappdemo.model;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class Comments {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String userName, content;
    @Ignore
    public Comments(String userName, String content) {
        this.userName = userName;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Comments() {
    }
}
