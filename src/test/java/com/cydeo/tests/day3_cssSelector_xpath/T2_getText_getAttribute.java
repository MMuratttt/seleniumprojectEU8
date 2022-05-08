package com.cydeo.tests.day3_cssSelector_xpath;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_getText_getAttribute {
    public static void main(String[] args) {

       // 1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

       // 2- Go to: https://login1.nextbasecrm.com/

       driver.navigate().to("https://login1.nextbasecrm.com");

       // 3- Verify “remember me” label text is as expected:
       // Expected: Remember me on this computer

        String expectedRememberMeLabel = "Remember me on this computer";
        WebElement rememberMeLabel = driver.findElement(By.className("login-item-checkbox-label"));
        String actualRememberMeLabel = rememberMeLabel.getText();

        if(expectedRememberMeLabel.equals(actualRememberMeLabel)){
            System.out.println("Remember me label has PASSED");
        }else{
            System.out.println("Remember me label has FAILED!!!");
        }

        // 4- Verify “forgot password” link text is as expected:
       // Expected: Forgot your password?

        String expectedForgotPasswordText = "Forgot your password?";
        String actualForgotPasswordText = driver.findElement(By.className("login-link-forgot-pass")).getText();

        if(expectedForgotPasswordText.equals(actualForgotPasswordText)){
            System.out.println("Forgot password text has matched");
        }else{
            System.out.println("expectedForgotPasswordText = " + expectedForgotPasswordText);
            System.out.println("actualForgotPasswordText = " + actualForgotPasswordText);
            System.out.println("Forgot password text test FAILED!!!");
        }

        // 5- Verify “forgot password” href attribute’s value contains expected:
       // Expected: forgot_password=yes

        String expectedInHref = "forgot_password=yes";
        String actualHrefAttributeValue = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");

        if(actualHrefAttributeValue.contains(expectedInHref)){
            System.out.println("HREF Attribute value verification PASSED");
        }else{
            System.out.println("HREF Attribute value verification FAILED!!!");
        }










    }
}
