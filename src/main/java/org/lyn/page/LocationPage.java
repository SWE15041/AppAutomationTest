package org.lyn.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Yanni
 */
public class LocationPage {
    //    address_input_on_location_start_page
    WebDriver driver;
    public By addressInput = MobileBy.AccessibilityId("address_input_on_location_start_page");
    public By continueButton = MobileBy.AccessibilityId("lets eat button");

    public LocationPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void toAddressListPage() {
        String text = driver.findElement(addressInput).getText();
        driver.findElement(addressInput).sendKeys("530 oakdene avenue");
        driver.findElement(addressInput).click();
    }
}
