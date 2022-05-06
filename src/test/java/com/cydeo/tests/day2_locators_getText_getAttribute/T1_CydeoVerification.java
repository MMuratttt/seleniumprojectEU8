package com.cydeo.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_CydeoVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com");

        String expectedURL = "cydeo";

        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("URL verification passed");
        }else{
            System.err.println("URL verification FAILED");
        }

        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle();

        if(expectedTitle.equals(actualTitle)){
            System.out.println("Title verification passed");
        }else{
            System.err.println("Title verification FAILED");
        }



    }
}
