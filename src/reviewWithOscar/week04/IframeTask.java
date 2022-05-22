package week04;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTask {

    //1. Go to https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
    //2. Switch to iframe.
    //3. Get the text “Double-click me to change my text color.” and verify the text

    @Test
    public void iframeTest() {
        WebDriver driver = WebDriverFactory.getDriver("Chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.navigate().to("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));

        String actualText = driver.findElement(By.xpath("//p[.='Double-click me to change my text color.']")).getText();

        String expectedText = "Double-click me to change my text color.";

        Assert.assertEquals(actualText,expectedText);


    }


}
