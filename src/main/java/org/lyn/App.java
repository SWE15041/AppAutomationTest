
package org.lyn;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByIosNSPredicate;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws MalformedURLException {

        App app = new App();
        app.prepare();
    }

    public void prepare() throws MalformedURLException {
        File app = new File("/Users/Yanni/Automation/packages/wonderQA_1.35.0-567898db7.app");
//        File app = new File("/Users/Yanni/Automation/packages/wonderQA_1.35.0-c11c891d3.ipa");
//        File app = new File("/Users/Yanni/Automation/packages/wonderQA_1.36.0-3fbac4941.ipa");
//        File app = new File("/Users/Yanni/Library/Developer/Xcode/DerivedData/wonder-bhjtsafxuuffuxfbzqwpybdltyaw/Build/Products/Debug-iphonesimulator/wonder.app");
//        File app = new File("The absolute or relative path to an *.app, *.zip or ipa file");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.4");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        //The_target_version is the supported iOS version, e.g. 8.1, 8.2, 9.2 etc
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        //you are free to set additional capabilities
        AppiumDriver<IOSElement> driver = new AppiumDriver<>(new URL("http://127.0.0.1:4010/wd/hub"), capabilities);
//        testCase(driver);

        System.out.println("install app finished.");
//        System.out.println("remove app");
//        driver.removeApp("com.remarkablefoods.consumerQA");
//
//        System.out.println("install app");
//        driver.installApp(app.getAbsolutePath());

        driver.findElementByClassName("allow");

    }

    public void testCase(final AppiumDriver<IOSElement> driver) {
        FindsByIosNSPredicate<IOSElement> findsByIosNSPredicate = new FindsByIosNSPredicate<IOSElement>() {
            @Override
            public IOSElement findElement(String by, String using) {
                return driver.findElement(by, using);
            }

            @Override
            public List<IOSElement> findElements(String by, String using) {
                return driver.findElements(by, using);
            }
        };

        findsByIosNSPredicate.findElementByIosNsPredicate("some predicate");
        driver.findElement(MobileBy.iOSNsPredicateString("some predicate"));

    }

    public void installApp(AppiumDriver<IOSElement> driver ) {
//        driver.installApp();
    }
}
