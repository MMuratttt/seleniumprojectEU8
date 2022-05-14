package week03;

import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestOrderTests {

    WebDriver driver;

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
    }

    @Test
    public void checkBoxTest(){
        System.out.println("Implementing step 3 and for of Test Case 1");
    }

    @Test
    public void deletePersonTest(){
        System.out.println("Implementing step 3 and for of Test Case 2");
    }



}
