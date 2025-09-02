package com.example.test;

import java.util.Map;

public class LoginTestConfig {
    public static final String LOGIN_URL = "https://example.com/login";
    public static final String USERNAME_FIELD_ID = "username";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String DASHBOARD_ID = "dashboard";
    public static final int SHORT_WAIT_SECONDS = 5;

    public static String getUsername() {
        return System.getenv("USERNAME") != null ? System.getenv("USERNAME") : System.getProperty("username");
    }

    public static String getPassword() {
        return System.getenv("PASSWORD") != null ? System.getenv("PASSWORD") : System.getProperty("password");
    }
}