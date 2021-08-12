package com.sys.monitoring_system.entity;

public class loginVo {
    private String username;
    private String password;

    public loginVo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public loginVo() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
