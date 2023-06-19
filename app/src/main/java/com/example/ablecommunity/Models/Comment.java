package com.example.ablecommunity.Models;

import com.google.firebase.database.ServerValue;

public class Comment {
    private String content,uid,u_img,uname;
    private Object timestamp;

    public Comment() {
    }

    public Comment(String content, String uid, String u_img, String uname) {
        this.content = content;
        this.uid = uid;
        this.u_img = u_img;
        this.uname = uname;
        this.timestamp= ServerValue.TIMESTAMP;
    }

    public Comment(String content, String uid, String u_img, String uname, Object timestamp) {
        this.content = content;
        this.uid = uid;
        this.u_img = u_img;
        this.uname = uname;
        this.timestamp = timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getU_img() {
        return u_img;
    }

    public void setU_img(String u_img) {
        this.u_img = u_img;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Object getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Object timestamp) {
        this.timestamp = timestamp;
    }
}
