package com.ieg.myblog.models;

public class User {
    private String name;
    private String email;
    private byte[] icon;

    public User() {
    }

    public User(String name, String email, byte[] icon) {
        this.name = name;
        this.email = email;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }
}
