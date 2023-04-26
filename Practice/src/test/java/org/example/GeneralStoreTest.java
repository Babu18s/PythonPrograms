package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.*;

public class GeneralStoreTest {
    AndroidDriver androidDriver;
    WebDriverWait wait;

    @Test
    public void verifyHomePage() throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\Ravi Singavarapu\\Downloads\\APK\\General-Store.apk");

        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);

        wait = new WebDriverWait(androidDriver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.Spinner"))).click();
        /*scrollToElement();
       List<WebElement> androidDriverElements=androidDriver.findElements(AppiumBy.className("android.widget.TextView"));
        ArrayList<String> countryList=new ArrayList<>();
       // Set<String> countryList=new LinkedHashSet<>();
        for (WebElement b:androidDriverElements) {
           String r= b.getText();
            countryList.add(r);
        }*/
        Set<String> countryList=new LinkedHashSet<>();
        // shoePage();
        for(int i=0;i<=27;i++){
            Thread.sleep(2000);
            gettingCountryList(countryList);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            scrollToBottom();

        }
        //gettingCountryList(countryList);
        System.out.println(countryList);
        System.out.println(countryList.size());
        scrollToElement();
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Raja");
        androidDriver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();

        //ArrayList<String> shoesList=new ArrayList<>();
        Set<String> shoesList=new LinkedHashSet<>();
       // shoePage();
        for(int i=0;i<=7;i++){
            Thread.sleep(3000);
            gettingShoeList(shoesList);
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            scrollToBottom();

        }
        System.out.println(shoesList);
        System.out.println(shoesList.size());
    }

    public void scrollToElement()  {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"India\"))"))).click();

       /* androidDriver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Yugoslavia\"))"));*/
    }
    public void shoePage(){
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().text(\"Nike SFB Jungle\"))")));

    }
    public void scrollToBottom(){
        Dimension size = androidDriver.manage().window().getSize();

        int y1 = size.getHeight(); // 1000
        int x1 = size.getWidth(); //500

       /* System.out.println("height :: " + y1);
        System.out.println("width :: " + x1 );*/

        int startY = (int)(y1*(.90));
        int endY = (int)(y1*(.30));
        int x = (int) (x1/2);

       /* System.out.println("startY :: " + startY);
        System.out.println("endY :: " + endY);*/

        TouchAction touchAction = new TouchAction(androidDriver);
        touchAction
                .press(PointOption.point(x,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(x, endY))
                .release()
                .perform();
    }
    public void gettingShoeList(Set<String> shoesList){
        List<WebElement> elementList=  androidDriver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\".*productName\")"));
        //Set<WebElement> elements=androidDriver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceIdMatches(\".*productName\")"));


        for (WebElement c:elementList){
            shoesList.add(c.getText());
        }
//
    }
    public void gettingCountryList( Set<String> countryList){
        List<WebElement> androidDriverElements=androidDriver.findElements(AppiumBy.className("android.widget.TextView"));

        for (WebElement b:androidDriverElements) {
            String r= b.getText();
            countryList.add(r);
        }
    }
}
