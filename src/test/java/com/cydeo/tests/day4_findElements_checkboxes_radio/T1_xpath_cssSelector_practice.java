package com.cydeo.tests.day4_findElements_checkboxes_radio;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_practice {
    public static void main(String[] args) {

        /*
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/forgot_password
        3. Locate all the WebElements on the page using XPATH and/or CSS
        locator only (total of 6)
        a. “Home” link
        b. “Forgot password” header
        c. “E-mail” text
        d. E-mail input box
        e. “Retrieve password” button
        f. “Powered by Cydeo text
        4. Verify all web elements are displayed.
        First solve the task with using cssSelector only. Try to create 2 different
        cssSelector if possible

        Then solve the task using XPATH only. Try to create 2 different
        XPATH locator if possible
         */

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("https://practice.cydeo.com/forgot_password");

        WebElement homeLink_ex1 = driver.findElement(By.cssSelector("a[class='nav-link']"));
        WebElement homeLink_ex2 = driver.findElement(By.cssSelector("a.nav-link"));  // . for class     # for id
        WebElement homeLink_ex3 = driver.findElement(By.cssSelector("a[href='/']"));


        WebElement header_ex1 = driver.findElement(By.cssSelector("div.example > h2"));
        WebElement header_ex2 = driver.findElement(By.xpath("//h2[text()='Forgot Password']"));
        WebElement header_ex3 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));


        WebElement emailLabel = driver.findElement(By.xpath("//label[@for='email']"));


        WebElement inputBox_ex1 = driver.findElement(By.xpath("//input[@name='email']"));
        WebElement inputBox_ex2 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));  // xpath contains method


        WebElement retrievePasswordBtn = driver.findElement(By.xpath("//button[@id='form_submit']"));


        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));


        System.out.println("homeLink_ex1.isDisplayed() = " + homeLink_ex1.isDisplayed());
        System.out.println("header_ex1.isDisplayed() = " + header_ex1.isDisplayed());
        System.out.println("emailLabel.isDisplayed() = " + emailLabel.isDisplayed());
        System.out.println("inputBox_ex1.isDisplayed() = " + inputBox_ex1.isDisplayed());
        System.out.println("retrievePasswordBtn.isDisplayed() = " + retrievePasswordBtn.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());


    }
}
