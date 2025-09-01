package com.example;

import java.util.Arrays;

public class LoginTestConfig {
    public static final String LOGIN_URL = "https://example.com/login";
    public static final String USERNAME_FIELD_ID = "username";
    public static final String PASSWORD_FIELD_ID = "password";
    public static final String LOGIN_BUTTON_ID = "loginButton";
    public static final String DASHBOARD_ID = "dashboard";
    public static final int SHORT_WAIT_SECONDS = 5;

    public static String getUsername(String[] args) {
        String username = System.getenv("USERNAME");
        if (username == null || username.isEmpty()) {
            if (args.length > 0) {
                username = args[0];
            } else {
                throw new IllegalArgumentException("Username must be provided via environment variable or command-line argument.");
            }
        }
        return username;
    }

    public static String getPassword(String[] args) {
        String password = System.getenv("PASSWORD");
        if (password == null || password.isEmpty()) {
            if (args.length > 1) {
                password = args[1];
            } else {
                throw new IllegalArgumentException("Password must be provided via environment variable or command-line argument.");
            }
        }
        return password;
    }
}