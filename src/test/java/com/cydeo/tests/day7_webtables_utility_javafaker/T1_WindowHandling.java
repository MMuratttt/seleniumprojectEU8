package com.cydeo.tests.day7_webtables_utility_javafaker;

import com.utilities.BrowserUtils;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WindowHandling {

    public WebDriver driver;


    //1. Create new test and make set ups
    //2. Go to : https://www.amazon.com
    //3. Copy paste the lines from below into your class
    //4. Create a logic to switch to the tab where Etsy.com is open
    //5. Assert: Title contains “Etsy”
    //
    //Lines to be pasted:
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

    @BeforeMethod
    public void setupMethod() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @Test
    public void windowHandlingTest() {

        driver.get("https://www.amazon.com");

        ((JavascriptExecutor) driver).executeScript("window.open('https://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('https://facebook.com','_blank');");
/*
        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);

            System.out.println("CurrentUrl() = " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains("etsy")){
            break;
        }}

        String actualTitle = driver.getTitle();
        String expectedInTitle = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedInTitle));
*/

        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
        driver.quit();


    }


}
