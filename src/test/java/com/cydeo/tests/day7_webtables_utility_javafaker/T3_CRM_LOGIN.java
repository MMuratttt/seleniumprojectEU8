package com.cydeo.tests.day7_webtables_utility_javafaker;

import com.utilities.BrowserUtils;
import com.utilities.CRM_Utilities;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_LOGIN {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod(){

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

@AfterMethod
public void tearDownMethod(){
    //   driver.close();
}


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
