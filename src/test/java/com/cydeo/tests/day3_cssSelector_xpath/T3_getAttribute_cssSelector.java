package com.cydeo.tests.day3_cssSelector_xpath;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_getAttribute_cssSelector {
    public static void main(String[] args) {

       // 1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com");

       // 3- Verify “Log in” button text is as expected:

        WebElement signInButton = driver.findElement(By.cssSelector("input.login-btn"));
        String actualSignInButtonText = signInButton.getAttribute("value");

        String expectedSignInButtonText = "Log In";

        if(actualSignInButtonText.equals(expectedSignInButtonText)){
            System.out.println("Passed");
        }else{
            System.err.println("FAILED");
        }

       // Expected: Log In





    }
}
