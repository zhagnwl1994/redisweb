package com.redisweb.redisweb.Entity;

import java.io.Serializable;

public class Book implements Serializable {
    private String username;
    private int language;

    public Book() {
    }

    public Book(String username, int language) {
        this.username = username;
        this.language = language;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Book{" +
                "username='" + username + '\'' +
                ", language=" + language +
                '}';
    }
}
