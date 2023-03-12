package com.ssnk.service;

import java.io.Serializable;

public class CurrentUser implements Serializable {
    private static CurrentUser currentUser=null;

    public int id;
    public String username;
    public boolean isMaker = false;
    public boolean isChecker = false;
    public boolean isAdmin = false;

    private CurrentUser() {

    }

    public static CurrentUser getCurrentUser() {
        if(currentUser == null)
            currentUser = new CurrentUser();
        return currentUser;
    }
}
