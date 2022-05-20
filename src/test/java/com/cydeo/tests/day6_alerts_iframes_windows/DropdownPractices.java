package com.cydeo.tests.day6_alerts_iframes_windows;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropdownPractices {


    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/dropdown");

    }


    @Test
    public void dropdown_task5(){

        /*
        1. Open Chrome browser
        2. Go to http://practice.cydeo.com/dropdown
        3. Select Illinois
        4. Select Virginia
        5. Select California
        6. Verify final selected option is California.
        Use all Select options. (visible text, value, index)
         */


        Select stateDropdown = new Select(driver.findElement( By.xpath("//select[@id='state']")) );

        stateDropdown.selectByVisibleText("Illinois");

        stateDropdown.selectByValue("VA");

        stateDropdown.selectByIndex(5);   // starts from 1


        String expectedOptionText = "California";
        String actualOptionText = stateDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedOptionText,actualOptionText);

    }

    @Test
    public void dropdown_task6(){

        /*
        1. Open Chrome browser
        2. Go to https://practice.cydeo.com/dropdown
        3. Select “December 1st, 1923” and verify it is selected.
        Select year using  : visible text
        Select month using   : value attribute
        Select day using : index number
         */

        Select yearDropdown = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        Select monthDropdown = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        Select dayDropdown = new Select(driver.findElement(By.xpath("//select[@id='day']")));

        yearDropdown.selectByVisibleText("1923");
        monthDropdown.selectByValue("11");
        dayDropdown.selectByIndex(0);

        String expectedYear = "1923";
        String expectedmonth = "December";
        String expectedday = "1";

        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedYear,actualYear);
        Assert.assertEquals(expectedmonth,actualMonth);
        Assert.assertEquals(expectedYear, actualYear);



    }

    @AfterMethod
    public void closeMethod(){
        driver.close();
    }





}
