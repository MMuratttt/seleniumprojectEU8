package com.cydeo.tests.day11_actions_jsexecutor_practice;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Circle_Drag_N_Drop {

    @Test
    public void drag_n_drop_test() {

        //TC #: Drag and drop
        //1. Go to https://demos.telerik.com/kendo-ui/dragdrop/index
        //2. Drag and drop the small circle to bigger circle.
        //3. Assert:
        //-Text in big circle changed to: “You did great!”

        Driver.getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().findElement(By.id("onetrust-accept-btn-handler")).click();

        WebElement source = Driver.getDriver().findElement(By.id("draggable"));
        WebElement target = Driver.getDriver().findElement(By.id("droptarget"));

        BrowserUtils.sleep(3);
        actions.dragAndDrop(source,target).perform();

        String actual = Driver.getDriver().findElement(By.xpath("//div[.='You did great!']")).getText();

        Assert.assertEquals(actual,"You did great!");

    }


}
