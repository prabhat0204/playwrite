import com.microsoft.playwright.*;
 
public class LoginTestPlaywright {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
 
            // Navigate to login page
            page.navigate("https://example.com/login");
 
            // Fill in username and password
            page.fill("#username", "testuser");
            page.fill("#password", "securepassword");
 
            // Click login button
            page.click("#loginButton");
 
            // Wait for dashboard to appear
            page.waitForSelector("#dashboard");
 
            // Verify login success
            if (page.isVisible("#dashboard")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
 
            // Close browser
            browser.close();
        }
    }
}
