package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReviewUtils {

    public static void staticWait(int seconds){
        try {
            Thread.sleep(seconds*1000);
        }catch (Exception e){

        }

    }

    // will be used in demoblaze app, to navigate toı different links at the page
    // will click different links / web elements on the page

    public static void getLink(WebDriver driver, String link){
        driver.findElement(By.partialLinkText(link)).click();
        staticWait(1);
    }



}
