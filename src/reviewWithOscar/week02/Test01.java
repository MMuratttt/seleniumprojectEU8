package week02;

import com.utilities.ReviewUtils;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Test01 {

    public static void main(String[] args) {


        //  open chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        // maximize

        driver.manage().window().maximize();

//  go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com");

        ReviewUtils.staticWait(1);

        WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot Password"));
        forgotPasswordLink.click();

//  enter any email

        WebElement emailBox = driver.findElement(By.name("email"));

        String expectedEmail = "mike.smith@garbage.com";
        emailBox.sendKeys(expectedEmail);

//  verify that email is displayed in the input box

        // String actualEmail = emailBox.getText();
        String actualEmail = emailBox.getAttribute("value");

        System.out.println("actualEmail: " + actualEmail);

        if(actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("PASS email verification");
        }else{
            System.out.println("FAILED email verification");
            System.out.println("actualEmail: " + actualEmail);
            System.out.println("expectedEmail: " + expectedEmail);
        }

        //  click on Retrieve password

        driver.findElement(By.id("form_submit")).click();

        ReviewUtils.staticWait(1);

        driver.close();

        //  verify that confirmation message says 'Your e-mail's been sent!'






    }
}
