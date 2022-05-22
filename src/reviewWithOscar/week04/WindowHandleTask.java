package week04;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandleTask {

    /*
    automate the following scenarios for this website https://shino.de/parkcalc/
Scenario 1)
-  Using the Valet parking lot, set today as the entry date & time and tomorrow as the exit
giving a full 24 hour window (you can attempt to use the DatePicker).
     */


     @Test
     public void windowTask(){

          WebDriver driver = WebDriverFactory.getDriver("chrome");
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

          driver.get("https://shino.de/parkcalc/");

          driver.findElement(By.xpath(("//img[@src='cal.gif'][1]"))).click();

          Set<String> windowHandles = driver.getWindowHandles();

          String mainWindowHandle = driver.getWindowHandle();

          for (String eachWindowHandle : windowHandles) {
               if(!eachWindowHandle.equals(mainWindowHandle)){
                    driver.switchTo().window(eachWindowHandle);
               }
          }

          driver.findElement(By.linkText("24")).click();

          driver.switchTo().window(mainWindowHandle);
        //  ReviewUtils.staticWait(5);

          WebElement pmButton = driver.findElement(By.xpath(("//input[@name='StartingTimeAMPM'][2]")));

          pmButton.click();

          Assert.assertTrue(pmButton.isSelected());

          driver.quit();


     }



}
