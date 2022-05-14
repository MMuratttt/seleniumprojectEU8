package week03;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestOrderTests {

    WebDriver driver;
    private Thread BrowserUtils;

    @BeforeMethod
    public void loginToWebOrders(){
        System.out.println("Login steps for application");
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test" + Keys.ENTER);

    }

    @AfterMethod
    public void closeBrowser(){
        System.out.println("Closing the browser for following test cases");
        driver.close();
    }

    @Test
    public void checkBoxTest(){
        System.out.println("Implementing step 3 and for of Test Case 1");

        WebElement checkAllBtn = driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();

        List<WebElement> checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement each : checkBoxes) {
            Assert.assertTrue(each.isSelected(),"Checkbox IS NOT checked");
        }

        driver.findElement(By.linkText("Uncheck All")).click();

        checkBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); // we need to relocate, otherwise StaleElementReferenceException

        for (WebElement each : checkBoxes) {
            Assert.assertFalse(each.isSelected(),"Checkboxes still selected");
        }



    }

    @Test
    public void deletePersonTest() throws InterruptedException {
        System.out.println("Implementing step 3 and for of Test Case 2");

        String name = "Mark Smith";
    /*
    Locate the checkBox using the person's Name: Bob Feather
    find with name(child)--> go to parent (whole row) --> down to td of checkbox */
        //td[.='Bob Feather']/../td[1]/input
        //td[.='Bob Feather']/preceding-sibling::*/input
        String locatorOfCheckBoxWithName = "//td[.='"+name+"']/../td[1]/input";
        WebElement checkBox = driver.findElement(By.xpath(locatorOfCheckBoxWithName));
        checkBox.click();  // select the checkbox with click()

        // locate delete button and click
        driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();

        // put some waiting time
        BrowserUtils.sleep(2);
// After we delete, we can get all the names of the customers as a List, then verify that deleted name is NOT in the list
        // need to get all the names from the table
        // common locator : //tr//td[2]
        List<WebElement> namesElements = driver.findElements(By.xpath("//tr//td[2]"));
        for (WebElement namesElement : namesElements) {
            // verify each elements text that it does not contain deleted person
            Assert.assertFalse(namesElement.getText().contains(name));
        }

    }



    }




