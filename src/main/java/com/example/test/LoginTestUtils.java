package com.example.test;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginTestUtils {
    private static final Logger logger = Logger.getLogger(LoginTestUtils.class.getName());

    public static String getUsername(String[] args) {
        if (args.length > 0) {
            return args[0];
        } else {
            System.out.print("Enter username: ");
            Scanner scanner = new Scanner(System.in);
            return scanner.nextLine();
        }
    }

    public static String getPassword(String[] args) {
        if (args.length > 1) {
            return args[1];
        } else {
            System.out.print("Enter password: ");
            Scanner scanner = new Scanner(System.in);
            return new String(System.console().readPassword());
        }
    }

    public static void logSuccess(String message) {
        logger.log(Level.INFO, message);
    }

    public static void logFailure(String message) {
        logger.log(Level.SEVERE, message);
    }
}