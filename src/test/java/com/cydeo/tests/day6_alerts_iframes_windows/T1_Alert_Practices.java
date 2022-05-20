package com.cydeo.tests.day6_alerts_iframes_windows;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_Alert_Practices {

    /*
    TC #1: Information alert practice
    1. Open browser
    2. Go to website: http://practice.cydeo.com/javascript_alerts
    3. Click to “Click for JS Alert” button
    4. Click to OK button from the alert
    5. Verify “You successfully clicked an alert” text is displayed.
     */

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void closeMethod() {
        driver.close();
    }


    @Test
    public void alert_test1() {

        driver.findElement(By.xpath("//button[@class='btn btn-primary'][1]")).click();

        Alert alert = driver.switchTo().alert();

        alert.accept();

        String expectedAlert = "You successfully clicked an alert";
        String actualAlert = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expectedAlert, actualAlert);

    }


    /*
    TC #2: Confirmation alert practice
    1. Open browser
    2. Go to website: http://practice.cydeo.com/javascript_alerts
    3. Click to “Click for JS Confirm” button
    4. Click to OK button from the alert
    5. Verify “You clicked: Ok” text is displayed.
     */


    @Test
    public void alert_test2(){

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        String expectedResult = "You clicked: Ok";
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();

        Assert.assertTrue(expectedResult.equals(actualResult));


    }

    /*
    TC #3: Information alert practice
    1. Open browser
    2. Go to website: http://practice.cydeo.com/javascript_alerts
    3. Click to “Click for JS Prompt” button
    4. Send “hello” text to alert
    5. Click to OK button from the alert
    6. Verify “You entered:  hello” text is displayed.
     */

    @Test
    public void alert_test3(){

        WebElement promptBtn = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        promptBtn.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        alert.accept();

        String expectedResult = "You entered: hello";
        String actualResult = driver.findElement(By.cssSelector("p[id='result']")).getText();

        Assert.assertEquals(expectedResult,actualResult);



    }





}
