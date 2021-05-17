package org.lyn.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Yanni
 */
public class LoginPage {
    WebDriver driver;
    public By loginWithEmailButton = MobileBy.AccessibilityId("login_with_email_on_login_page");
    public By emailInput = MobileBy.AccessibilityId("email_input_on_email_login_page");
    public By passwordInput = MobileBy.AccessibilityId("password_input_on_email_login_page");
    public By loginButton = MobileBy.AccessibilityId("login_button_on_email_login_page");

    public LoginPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void sendKeysEmail(String email) {
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void sendKeysPassword(String password) {
        driver.findElement(passwordInput).clear();
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void login(String email, String password) {
        sendKeysEmail(email);
        sendKeysPassword(password);
        driver.findElement(loginButton).click();
    }

}
