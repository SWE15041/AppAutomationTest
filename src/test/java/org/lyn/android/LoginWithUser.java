package org.lyn.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.Test;
import org.lyn.page.AddressListPage;
import org.lyn.page.LocationPage;
import org.lyn.page.LoginPage;
import org.lyn.page.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.sql.Driver;

/**
 * @author Yanni
 */
public class LoginWithUser {
    private AndroidDriver<WebElement> driver;

    @Test
    public void login() throws Exception {
        // apk location
        String appLocation = "/Users/yannilan/workspace/Chancetop/Automation/app/wonder_QA_2.3.1-156f19c90.apk";

        // appium desired capabilities for android
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel XL API 30");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11.0");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.APP, new File(appLocation).getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        // appium port
        String appiumPort = "4012";

        // appium start
//        AndroidDriver<WebElement> driver = new AndroidDriver<>(new URL(String.format("http://127.0.0.1:%s/wd/hub", appiumPort)), capabilities);
        driver = new AndroidDriver<>(new URL(String.format("http://127.0.0.1:%s/wd/hub", appiumPort)), capabilities);
        String email = "yannilan@regression.com";
        String password = "pwd11111";
        loginWithEmail(email, password);
    }

    public void loginWithEmail(String email, String password) throws InterruptedException {
//        ElementAction action = new ElementAction();
//        click(MobileBy.AccessibilityId("Allow"));
        WelcomePage welcomePage = new WelcomePage();
        click(welcomePage.loginButton);
        LoginPage loginPage = new LoginPage(driver);
        click(loginPage.loginWithEmailButton);
        loginPage.login(email, password);
//        click(MobileBy.AccessibilityId("Allow While Using App"));

//        LocationPage locationPage = new LocationPage(driver);
////        locationPage.toAddressListPage();
//        click(locationPage.addressInput);

//        Thread.sleep(5000);
        AddressListPage addressListPage = new AddressListPage(driver);
        addressListPage.goToAddress();
        if (driver != null) {
            driver.quit();
        }
    }

    public void click(By by) {
        new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(by))
            .click();
    }
}
