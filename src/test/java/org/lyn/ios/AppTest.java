package org.lyn.ios;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lyn.page.AddressListPage;
import org.lyn.page.LocationPage;
import org.lyn.page.LoginPage;
import org.lyn.page.WelcomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.NoSuchElementException;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private IOSDriver<WebElement> driver;
//
//    public void click(By by) {
//        try {
//            WebElement webElement = findElement(locator);
//            webElement.click();
//            log.info("click元素："+locator.getLocalorName()+"["+"By."+locator.getType()+":"+locator.getElement()+"]成功！");
//        } catch (NoSuchElementException e) {
//            // TODO: handle exception
//            log.error("找不到元素，click失败:"+locator.getLocalorName()+"["+"By."+locator.getType()+":"+locator.getElement()+"]");
//            e.printStackTrace();
//            throw e;
//        }
//
//    }

    @Before
    public void setup() throws Exception {
        File app = new File("/Users/yannilan/workspace/Chancetop/Automation/app/wonderQA_2.3.1-5e55a20ce.app");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");

        driver = new IOSDriver<>(new URL("http://127.0.0.1:4010/wd/hub"), capabilities);
//        System.out.println("remove app");
//        driver.removeApp("com.remarkablefoods.consumerQA");
//        System.out.println("install app");
//        driver.installApp(app.getAbsolutePath());
//        System.out.println("install app finished.");
    }

    @Test
    public void clickAllowNotifyMe() throws Exception {
        System.out.println("current page: welcome page");
        String buttonElementId = "Allow";
        IOSElement buttonElement1 = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(buttonElementId)));
        buttonElement1.click();
        IOSElement buttonElement2 = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(buttonElementId)));
        buttonElement2.click();

//        driver.launchApp();
        IOSElement login_button_on_welcome_page = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login_button_on_welcome_page")));
        login_button_on_welcome_page.click();
        System.out.println("current page: login page");

        IOSElement login_with_email_on_login_page = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login_with_email_on_login_page")));
        login_with_email_on_login_page.click();

        String email = "yannilan@regression.com";
        String password = "pwd11111";
        IOSElement email_input_on_email_login_page = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("email_input_on_email_login_page")));
        email_input_on_email_login_page.sendKeys(email);
        IOSElement password_input_on_email_login_page = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("password_input_on_email_login_page")));
        password_input_on_email_login_page.sendKeys(password);
        IOSElement login_button_on_email_login_page = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("login_button_on_email_login_page")));
        login_button_on_email_login_page.sendKeys(password);


        IOSElement allowLocation = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Allow While Using App")));
        allowLocation.click();

    }

    /**
     * 1. on welcome page, click "LOGIN" button, redirect to login page
     * 2. on login page, click "LOGIN WITH EMAIL" button, input "email" and "password" text, click "LOG IN"
     * 3. login page to home page
     */
    @Test
    public void loginWithEmail() throws InterruptedException {
//        ElementAction action = new ElementAction();
        click(MobileBy.AccessibilityId("Allow"));
        WelcomePage welcomePage = new WelcomePage();
        click(welcomePage.loginButton);
        LoginPage loginPage = new LoginPage(driver);
        click(loginPage.loginWithEmailButton);
        String email = "yannilan@regression.com";
        String password = "pwd11111";
        loginPage.login(email, password);
        click(MobileBy.AccessibilityId("Allow While Using App"));


        LocationPage locationPage = new LocationPage(driver);
//        locationPage.toAddressListPage();
        click(locationPage.addressInput);

//        Thread.sleep(5000);
        AddressListPage addressListPage=new AddressListPage(driver);
        addressListPage.goToAddress();

    }

    public void click(By by) {
        new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(by))
            .click();
    }

    public void handleAlert() {
        click(MobileBy.AccessibilityId("Allow"));
        click(MobileBy.AccessibilityId("Allow While Using App"));
    }

    @After
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
