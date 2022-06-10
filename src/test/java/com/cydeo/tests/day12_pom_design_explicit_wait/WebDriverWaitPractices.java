package com.cydeo.tests.day12_pom_design_explicit_wait;

import com.cydeo.pages.DynamicLoad1Page;
import com.cydeo.pages.DynamicLoad7Page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitPractices {

    @Test
    public void dynamic_load_test_7(){

        //1. Go to https://practice.cydeo.com/dynamic_loading/7
        //2. Wait until title is “Dynamic title”
        //3. Assert: Message “Done” is displayed.
        //4. Assert: Image is displayed.

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");

        // creating the wait object to be able to create certain condition to wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

        //use the "wait" object to create our expected condition
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(new DynamicLoad7Page().doneMessage.isDisplayed());

        BrowserUtils.sleep(2);
        Assert.assertTrue(new DynamicLoad7Page().spongeBobImage.isDisplayed());

    }

    @Test
    public void dynamic_load_test_1(){

        //1. Go to https://practice.cydeo.com/dynamic_loading/1
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");

        //2. Click to start
        DynamicLoad1Page dynamicLoad1Page = new DynamicLoad1Page();
        dynamicLoad1Page.startButton.click();


        //3. Wait until loading bar disappears
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicLoad1Page.loadingBar));



        //4. Assert username inputbox is displayed
        Assert.assertTrue(dynamicLoad1Page.userName.isDisplayed());




        //5. Enter username: tomsmith
        dynamicLoad1Page.userName.sendKeys("tomsmith");

        //6. Enter password: incorrectpassword
        dynamicLoad1Page.inputPassword.sendKeys("incorrectpassword");

        //7. Click to Submit button
        dynamicLoad1Page.submitButton.click();

        //8. Assert “Your password is invalid!” text is displayed.
        Assert.assertTrue(dynamicLoad1Page.errorMessage.isDisplayed());


    }

}
