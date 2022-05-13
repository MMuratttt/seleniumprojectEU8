package com.cydeo.tests.day3_cssSelector_xpath;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_cssSelector_getText {
    public static void main(String[] args) {

        // 1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        // 2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes

        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        // 3- Verify “Reset password” button text is as expected:
        // Expected: Reset password

        String expectedButtonText = "Reset password";
        WebElement resetPasswordButton = driver.findElement(By.cssSelector("button[value='Reset password']"));

       String actualButtonText = resetPasswordButton.getText();

       if(expectedButtonText.equals(actualButtonText)){
           System.out.println("Passed"); 
       }else{
           System.err.println("FAILED!!!");
       }




    }
}
