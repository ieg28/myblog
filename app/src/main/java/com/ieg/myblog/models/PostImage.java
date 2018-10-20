package com.ieg.myblog.models;

public class PostImage {
    private String user;
    private String title;
    private String body;
    private String imagePath;
    private long time;

    public PostImage() {
    }

    public PostImage(String user, String title, String body, String imagePath, long time) {
        this.user = user;
        this.title = title;
        this.body = body;
        this.imagePath = imagePath;
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
