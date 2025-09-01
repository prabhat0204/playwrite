package com.example.pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;
    private String usernameSelector = "#username";
    private String passwordSelector = "#password";
    private String loginButtonSelector = "#loginButton";
    private String dashboardSelector = "#dashboard";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void enterUsername(String username) {
        page.fill(usernameSelector, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordSelector, password);
    }

    public void clickLoginButton() {
        page.click(loginButtonSelector);
    }

    public boolean isDashboardVisible() {
        return page.isVisible(dashboardSelector);
    }

    public void cleanup() {
        page.close();
    }
}