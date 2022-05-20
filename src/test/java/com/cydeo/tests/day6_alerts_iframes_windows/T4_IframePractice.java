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

public class T4_IframePractice {

    /*
    1. Create a new class called: T4_Iframes
    2. Create new test and make set ups
    3. Go to: https://practice.cydeo.com/iframe
    4. Assert: “Your content goes here.” Text is displayed.
    5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
     */

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://practice.cydeo.com/iframe");

    }

    @AfterMethod
    public void closeMethod() {

        driver.close();

    }

    @Test
    public void iframe_test() {

        driver.switchTo().frame("mce_0_ifr");

        WebElement message = driver.findElement(By.xpath("//p[.='Your content goes here.']"));

        String expectedResult1 = "Your content goes here.";
        String actualResult1 = message.getText();

        Assert.assertEquals(expectedResult1, actualResult1);

        driver.switchTo().parentFrame();

        WebElement message2 = driver.findElement(By.xpath("//h3"));

        String actualResult2 = message2.getText();
        String expectedResult2 = "An iFrame containing the TinyMCE WYSIWYG Editor";

        Assert.assertTrue(actualResult2.equals(expectedResult2));

    }


}
