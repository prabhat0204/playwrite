package com.example.login;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = null;
        try {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://example.com/login");
            page.fill("#username", "your_username");
            page.fill("#password", "your_password");
            page.click("#loginButton");
            page.waitForSelector("#dashboard", new Page.WaitForSelectorOptions().setTimeout(5000));
            boolean isDashboardVisible = page.isVisible("#dashboard");
            System.out.println("Login successful: " + isDashboardVisible);
        } catch (Exception e) {
            logger.error("An error occurred during the login process", e);
        } finally {
            if (browser != null) {
                browser.close();
            }
            playwright.close();
        }
    }
}