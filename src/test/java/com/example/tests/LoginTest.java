package com.example.tests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.options.WaitForSelectorState.VISIBLE;

public class LoginTest {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    private static final String USERNAME = System.getenv("TEST_USERNAME");
    private static final String PASSWORD = System.getenv("TEST_PASSWORD");
    private static final String LOGIN_URL = "https://example.com/login";
    private static final String DASHBOARD_ID = "dashboard";

    public LoginTest() {
        setup();
    }

    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        context = browser.newContext();
        page = context.newPage();
    }

    public void loginTest() {
        try {
            page.navigate(LOGIN_URL);
            page.fill("#" + TestConfig.USERNAME_ID, USERNAME);
            page.fill("#" + TestConfig.PASSWORD_ID, PASSWORD);
            page.click("#" + TestConfig.LOGIN_BUTTON_ID);
            page.waitForSelector("#" + DASHBOARD_ID, new Page.WaitForSelectorOptions().setState(VISIBLE));
            boolean isLoggedIn = page.isVisible("#" + DASHBOARD_ID);
            System.out.println("Login " + (isLoggedIn ? "successful" : "failed"));
        } catch (Exception e) {
            System.out.println("An error occurred during the login test: " + e.getMessage());
        } finally {
            cleanup();
        }
    }

    public void cleanup() {
        if (context != null) {
            context.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }

    public static void main(String[] args) {
        new LoginTest().loginTest();
    }
}