package com.example.test;

import com.microsoft.playwright.*;

public class LoginTest {
    private static final String LOGIN_URL = "http://example.com/login";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";
    private static final String DASHBOARD_SELECTOR = "#dashboard";

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();

        try {
            page.navigate(LOGIN_URL);
            page.fill("input[name='username']", USERNAME);
            page.fill("input[name='password']", PASSWORD);
            page.click("button[type='submit']");

            page.waitForSelector(DASHBOARD_SELECTOR, new Page.WaitForSelectorOptions().setTimeout(5000));
            if (page.isVisible(DASHBOARD_SELECTOR)) {
                System.out.println("Login successful, dashboard is visible.");
            } else {
                System.out.println("Login failed, dashboard is not visible.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            context.close();
            browser.close();
            playwright.close();
        }
    }
}