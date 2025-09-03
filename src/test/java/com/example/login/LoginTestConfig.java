package com.example.login;

public class LoginTestConfig {
    public static final String URL = "https://example.com/login";
    public static final String USERNAME_FIELD_ID = "username";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String DASHBOARD_ID = "dashboard";

    public static String getUsername() {
        return System.getProperty("test.username", "defaultUsername");
    }

    public static String getPassword() {
        return System.getProperty("test.password", "defaultPassword");
    }
}