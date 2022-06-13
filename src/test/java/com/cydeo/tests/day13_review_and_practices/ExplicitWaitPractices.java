package com.cydeo.tests.day13_review_and_practices;

import com.cydeo.pages.DynamicControlsPage;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitPractices {

    DynamicControlsPage dynamicControlsPage;

    @BeforeMethod
    public void setupMethod() {

        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        dynamicControlsPage = new DynamicControlsPage();

    }

    @Test
    public void remove_button_test() {

//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/dynamic_controls
//3- Click to “Remove” button

        dynamicControlsPage.removeButton.click();

//4- Wait until “loading bar disappears”

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));


//5- Verify:
//a. Checkbox is not displayed

        try {

            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());

        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }
        // Assert

//b. “It’s gone!” message is displayed.
        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());


    }

    @Test
    public void enable_button_test(){

        //Click to “Enable” button
        //4- Wait until “loading bar disappears”
        //5- Verify:
        //a. Input box is enabled.
        //b. “It’s enabled!” message is displayed.
        dynamicControlsPage.enableButton.click();

        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());


        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);
        System.out.println("dynamicControlsPage.inputBox.isEnabled() = "
                + dynamicControlsPage.inputBox.isEnabled());

        Assert.assertTrue(dynamicControlsPage.inputBox.isEnabled());

        Assert.assertTrue(dynamicControlsPage.message.isDisplayed());

        Assert.assertTrue(dynamicControlsPage.message.getText().equals("It's enabled!"));







    }


}
