package week02;

import com.utilities.ReviewUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test02 {

    public static void main(String[] args) {

             //   - Go to:  http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

             //   - Verify title equals: String expectedTitle = "Web Orders Login"

        String expectedTitleBeforeLogin = "Web Orders Login";

        if(expectedTitleBeforeLogin.equals(driver.getTitle())){
            System.out.println("success");
        }else{
            System.exit(1);
        }

        WebElement userNameBox = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement signInButton = driver.findElement(By.id("ctl00_MainContent_login_button"));

        userNameBox.sendKeys("Tester");
        passwordBox.sendKeys("test");
        signInButton.click();

        String expectedHomePageTitle = "Web Orders";

        if(expectedHomePageTitle.equals(driver.getTitle())){
            System.out.println("passed");
        }else{
            System.exit(1);
        }


        ReviewUtils.staticWait(2);

        driver.close();

             //   - Enter username: Tester
             //   - Enter password: test
             //   - Click “Sign In” button
             //   - Verify title equals: String expectedHomePageTitle = "Web Orders"









    }
}
