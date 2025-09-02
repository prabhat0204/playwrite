package com.example.login;

public class LoginTestConfig {
    public static final String LOGIN_URL = "http://example.com/login";
    public static final String USERNAME_FIELD_ID = "username";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String DASHBOARD_ELEMENT_ID = "dashboard";

    private String username;
    private String password;

    public LoginTestConfig() {
        this.username = System.getenv("TEST_USERNAME");
        this.password = System.getenv("TEST_PASSWORD");
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}