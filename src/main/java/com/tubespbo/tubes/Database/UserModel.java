package com.tubespbo.tubes.Database;

public class UserModel {
    private String username;
    private String password;
    private int role;

    public UserModel(String username, String password, int role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    public int getRole(){
        return role;
    }
}
