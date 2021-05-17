package org.lyn.page;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author Yanni
 */
public class AddressListPage {
    WebDriver driver;

    public By addressInput = MobileBy.AccessibilityId("address_input_on_address_list_page");
    public By matchedAddressButton = MobileBy.AccessibilityId("matched address button");

    public AddressListPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void goToAddress() {
        driver.findElement(addressInput).clear();
        driver.findElement(addressInput).sendKeys("530 oakdene avenue");
        driver.findElement(matchedAddressButton).click();
    }

}
