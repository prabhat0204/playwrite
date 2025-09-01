package com.example;

import com.microsoft.playwright.*;
import java.util.Scanner;

public class LoginTest {
    private static final String LOGIN_URL = "https://example.com/login";

    public static void main(String[] args) {
        String username;
        String password;

        if (args.length == 2) {
            username = args[0];
            password = args[1];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            username = scanner.nextLine();
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        Page page = browser.newPage();

        try {
            page.navigate(LOGIN_URL);
            page.fill("#username", username);
            page.fill("#password", password);
            page.click("#loginButton");
            page.waitForSelector("#dashboard", new Page.WaitForSelectorOptions().setTimeout(5000));

            if (page.isVisible("#dashboard")) {
                System.out.println("Login successful, dashboard is visible.");
            } else {
                System.out.println("Login failed, dashboard is not visible.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            page.close();
            browser.close();
            playwright.close();
        }
    }
}