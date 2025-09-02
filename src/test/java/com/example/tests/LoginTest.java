package com.example.tests;

import com.microsoft.playwright.*;
import static com.microsoft.playwright.options.WaitForSelectorState.*;

public class LoginTest {
    private static final String URL = "https://example.com/login";
    private static final String USERNAME_FIELD_ID = "username";
    private static final String PASSWORD_FIELD_ID = "password";
    private static final String LOGIN_BUTTON_ID = "loginButton";
    private static final String DASHBOARD_ELEMENT_ID = "dashboard";

    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate(URL);
            page.fill("#" + USERNAME_FIELD_ID, "testuser");
            page.fill("#" + PASSWORD_FIELD_ID, "password123");
            page.click("#" + LOGIN_BUTTON_ID);
            page.waitForSelector("#" + DASHBOARD_ELEMENT_ID, new Page.WaitForSelectorOptions().setState(VISIBLE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}