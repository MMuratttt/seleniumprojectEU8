package com.cydeo.tests.day5_testNG_intro_dropdowns;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {

        /*
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/add_remove_elements/
        3. Click to “Add Element” button
        4. Verify “Delete” button is displayed after clicking.
        5. Click to “Delete” button.
        6. Verify “Delete” button is NOT displayed after clicking.
        USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
         */


        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        WebElement addElementBtn = driver.findElement(By.xpath("//button[.='Add Element']"));

        Thread.sleep(2000);
        addElementBtn.click();

        WebElement deleteBtn = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        Thread.sleep(2000);
        deleteBtn.click();


        try{

            System.out.println("deleteBtn.isDisplayed() = " + deleteBtn.isDisplayed());

        }catch(StaleElementReferenceException e){

            System.out.println("StaleElementReferenceException is Thrown");
            System.out.println("This means thw web element deleted from the page");
            System.out.println("deleteButton.isDisplayed() = false");

        }

        driver.close();

    }
}
