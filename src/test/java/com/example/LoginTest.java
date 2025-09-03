package com.example;

import com.microsoft.playwright.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoginTest {
    private static final String URL = "https://example.com/login";
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties properties = new Properties();
        try (InputStream input = LoginTest.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
            USERNAME = properties.getProperty("username");
            PASSWORD = properties.getProperty("password");
            if (USERNAME == null || PASSWORD == null) {
                throw new RuntimeException("Properties file must contain 'username' and 'password' keys");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties", e);
        }
    }

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        try {
            page.navigate(URL);
            page.fill("#username", USERNAME);
            page.fill("#password", PASSWORD);
            page.click("#loginButton");
            page.waitForSelector("#dashboard", new Page.WaitForSelectorOptions().setTimeout(5000));
            page.waitForSelector("#dashboard", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE));
        } finally {
            context.close();
            browser.close();
            playwright.close();
        }
    }
}