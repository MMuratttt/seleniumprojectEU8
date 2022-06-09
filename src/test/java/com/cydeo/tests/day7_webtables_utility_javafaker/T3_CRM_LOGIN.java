package com.cydeo.tests.day7_webtables_utility_javafaker;

import com.cydeo.tests.base.TestBase;
import com.utilities.BrowserUtils;
import com.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T3_CRM_LOGIN extends TestBase {



    @Test
    public void crm_login_test(){

        driver.get("http://login1.nextbasecrm.com/");

        WebElement inputUsername = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        inputUsername.sendKeys("helpdesk1@cybertekschool.com");


        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        inputPassword.sendKeys("UserUser");



        WebElement loginBtn = driver.findElement(By.xpath("//input[@class='login-btn']"));
        loginBtn.click();

        BrowserUtils.verifyTitle(driver,"Portal");


    }

    @Test
    public void crm_login_test_2(){

        driver.get("http://login1.nextbasecrm.com/");

        // calling utility method
        CRM_Utilities.crm_login(driver);

        BrowserUtils.verifyTitle(driver,"Portal");


    }

    @Test
    public void crm_login_test_3(){

        driver.get("http://login1.nextbasecrm.com/");

        // calling utility method
        CRM_Utilities.crm_login(driver,"helpdesk2@cybertekschool.com","UserUser");

        BrowserUtils.verifyTitle(driver,"Portal");


    }


        //1. Create new test and make set ups
        //2. Go to : http://login1.nextbasecrm.com/
        //3. Enter valid username
        //4. Enter valid password
        //5. Click to `Log In` button
        //6. Verify title is as expected:
        //Expected: Portal





}
