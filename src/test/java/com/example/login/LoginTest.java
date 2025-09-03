package com.example.login;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.WaitForSelectorState;

public class LoginTest {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://example.com/login");

            page.fill("#username", "your_username");
            page.fill("#password", "your_password");
            page.click("#loginButton");

            page.waitForSelector("#dashboard", new Page.WaitForSelectorOptions().setState(WaitForSelectorState.VISIBLE).setTimeout(5000));
            boolean isDashboardVisible = page.isVisible("#dashboard");

            if (isDashboardVisible) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }

            context.close();
            browser.close();
        } catch (PlaywrightException e) {
            System.err.println("Playwright error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}