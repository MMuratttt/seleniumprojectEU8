package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {

    /*  1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/abtest
        3- Locate “CYDEO” link, verify it is displayed.
        4- Refresh the page.
        5- Verify it is displayed, again.   */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/abtest");

        WebElement cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));

        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

        driver.navigate().refresh();

        // refreshing the web element reference by re-assigning (re-locating) the web element
        cydeoLink = driver.findElement(By.xpath("//a[@target='_blank']"));

        System.out.println("cydeoLink.isDisplayed() = " + cydeoLink.isDisplayed());

    }
}
