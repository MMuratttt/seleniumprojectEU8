package com.cydeo.tests.day6_alerts_iframes_windows;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowsPractice {


    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

    driver = WebDriverFactory.getDriver("chrome");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    driver.get("https://practice.cydeo.com/windows");


    }

    @AfterMethod
    public void tearDown(){

        driver.quit();  // close all opening window

    }

    @Test
    public void window_test(){

        String expectedTitle = "Windows";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }


    @Test
    public void newTabTest(){

        WebElement clickHere = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHere.click();

        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
        }

        String expectedTitle = "New Window";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }



    /*
        TC #5: Window Handle practice

        1. Create a new class called: T5_WindowsPractice
        2. Create new test and make set ups
        3. Go to : https://practice.cydeo.com/windows
        4. Assert: Title is “Windows”
        5. Click to: “Click Here” link
        6. Switch to new Window.
        7. Assert: Title is “New Window”
     */


}
