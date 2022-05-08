package com.cydeo.tests.day3_cssSelector_xpath;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_locators_getText {

    public static void main(String[] args) {

            //  1- Open a chrome browser

       // WebDriverManager.chromedriver().setup();
     //   WebDriver driver = new ChromeDriver();

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

            // 2- Go to: https://login1.nextbasecrm.com/

        driver.get("https://login1.nextbasecrm.com");

            // 3- Enter incorrect username: “incorrect”

        WebElement userNameInput = driver.findElement(By.name("USER_LOGIN"));
        userNameInput.sendKeys("incorrect");

            // 4- Enter incorrect password: “incorrect”

        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");

            // 5- Click to login button.

        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

            // 6- Verify error message text is as expected:

        String errorMessage = driver.findElement(By.className("errortext")).getText();
        String expectedErrorMessage = "Incorrect login or password";

             // Expected: Incorrect login or password

        if(errorMessage.equals(expectedErrorMessage)){
            System.out.println("PASSED");
        }else{
            System.out.println("FAILED");
        }
}
}