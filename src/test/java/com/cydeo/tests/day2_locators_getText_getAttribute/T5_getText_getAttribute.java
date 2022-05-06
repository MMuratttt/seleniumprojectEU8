package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_getAttribute {

    public static void main(String[] args) {

        // 1- Open a chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 2- Go to: https://practice.cydeo.com/registration_form

        driver.navigate().to("https://practice.cydeo.com/registration_form");

        // 3- Verify header text is as expected:
        // Expected: Registration form

        String expectedHeader = "Registration form";
        WebElement actualHeader = driver.findElement(By.tagName("h2"));
        String headerText = actualHeader.getText();

        if(expectedHeader.equals(headerText)){
            System.out.println("Header is matching");
        }else{
            System.out.println("Header is NOT matching");
        }

        // 4- Locate “First name” input box

        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        // 5- Verify placeholder attribute’s value is as expected:
        // Expected: first name

        String expectedPlaceHolder = firstNameInput.getAttribute("placeholder");




    }

}
