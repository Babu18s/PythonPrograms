package org.example;


import io.appium.java_client.AppiumBy;
//import io.appium.java_client.TouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NaukriTest {
    AndroidDriver androidDriver;
    WebDriverWait wait;
@Test
    public void verifyHomePage() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities =new DesiredCapabilities();
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
    desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
    desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Ravi Singavarapu\\Downloads\\APK\\Naukri.com_base.apk");

    androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

    wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))).click();
   // androidDriver.findElement(AppiumBy.id()).click();
    wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.id("naukriApp.appModules.login:id/textViewLabel")));

    String naukriStartPageHeading = androidDriver.findElement(AppiumBy.id("naukriApp.appModules.login:id/textViewLabel")).getText();
    System.out.println(naukriStartPageHeading);
    Assert.assertEquals(naukriStartPageHeading, "Get started on Naukri");
    scrollToBottom();

}
    public void scrollToBottom(){
        Dimension size = androidDriver.manage().window().getSize();

        int y1 = size.getHeight(); // 1000
        int x1 = size.getWidth(); //500

        System.out.println("height :: " + y1);
        System.out.println("width :: " + x1 );

        int startY = (int)(y1*(.30));
        int endY = (int)(y1*(.70));
        int x = (int) (x1/2);

        System.out.println("startY :: " + startY);
        System.out.println("endY :: " + endY);

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction
                .press(PointOption.point(x,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }

    public void swipeRightToLeft(){
        Dimension size = androidDriver.manage().window().getSize();

        int startX = (int)(size.getWidth() * (0.8));
        int endX = (int)(size.getWidth() * (0.2));
        int y = (int)(size.getHeight()/2);

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction
                .press(PointOption.point(startX, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
                .moveTo(PointOption.point(endX, y))
                .release()
                .perform();

    }
    }

