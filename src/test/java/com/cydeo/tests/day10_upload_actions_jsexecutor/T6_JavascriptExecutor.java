package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavascriptExecutor {

    @Test
    public void javascript_executor_test1() {

        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite_scroll
        //3- Use below JavaScript method and scroll
        //a.  750 pixels down 10 times.
        //b.  750 pixels up 10 times
        //
        //JavaScript method to use : window.scrollBy(0,0)

        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        //down
        for (int i = 0; i < 10; i++) {

            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,750)");

        }

        //up
        for (int i = 0; i < 10; i++) {

            BrowserUtils.sleep(1);
            js.executeScript("window.scrollBy(0,-750)");

        }

    }


}
