package com.redisweb.redisweb.Entity;

import java.io.Serializable;

public class User implements Serializable {

    private String id;
    private String rule;
    private String password;



    public User(String id, String rule, String password) {
        this.id = id;
        this.rule = rule;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
