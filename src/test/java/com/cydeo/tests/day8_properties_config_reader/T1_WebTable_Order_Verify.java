package com.cydeo.tests.day8_properties_config_reader;

import com.utilities.WebDriverFactory;
import com.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Go to: https://practice.cydeo.com/web-tables

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/web-tables");
    }


    @Test
    public void order_name_verify_test() {
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement actualName = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));
        String expectedName = "Bob Martin";
        Assert.assertEquals(expectedName, actualName.getText());

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021

        String expectedDate = "12/31/2021";
        String actualDate = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']/following-sibling::td[3]")).getText();
        Assert.assertTrue(actualDate.equals(expectedDate));

    }

    @Test
    public void test2() {

      String customerOrderDate1 = WebTableUtils.returnOrderDate(driver, "Ned Stark");
        System.out.println("customerOrderDate1 = " + customerOrderDate1);

    }

    @Test
    public void test3(){

        WebTableUtils.orderVerify(driver,"Bob Martin","12/31/2021");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
