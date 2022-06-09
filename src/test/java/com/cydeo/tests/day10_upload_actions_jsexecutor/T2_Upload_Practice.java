package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void upload_test(){

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        //2. Find some small file from your computer, and get the path of it.
        //3. Upload the file.
        //4. Assert:
        //-File uploaded text is displayed on the page

        Driver.getDriver().get("https://practice.cydeo.com/upload");
        String path = "C:\\Users\\Murat Ulusal\\Desktop\\a2.jpg";

        WebElement fileUpload = Driver.getDriver().findElement(By.id("file-upload"));

        BrowserUtils.sleep(2);

        fileUpload.sendKeys(path);

        Driver.getDriver().findElement(By.id("file-submit")).click();

        String actualResult = Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']")).getText();

        String expectedResult = "File Uploaded!";

        Assert.assertTrue(actualResult.equals(expectedResult));




    }



}
