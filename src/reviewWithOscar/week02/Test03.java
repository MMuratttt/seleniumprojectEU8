package week02;

import com.utilities.ReviewUtils;
import com.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Test03 {
    public static void main(String[] args) {

        // You have to implement the following Web automated checks over our
        // DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
    //Customer navigation through product categories: Phones, Laptops and Monitors
        // Navigate to "Laptop" → "Sony vaio i5" and verify the price is 790 dollars

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.demoblaze.com/index.html");

        ReviewUtils.staticWait(1);


        driver.findElement(By.partialLinkText("Laptops")).click();

        ReviewUtils.staticWait(1);


        driver.findElement(By.linkText("Sony vaio i5")).click();

        ReviewUtils.staticWait(1);


        int expectedPrice = 790;

        String priceText = driver.findElement(By.tagName("h3")).getText();

        int actualPrice = Integer.parseInt(priceText.split(" ")[0].substring(1));
        System.out.println("actualPrice = " + actualPrice);

        if(expectedPrice == actualPrice){
            System.out.println("PASSED");
        }else{
            System.exit(-1);
        }

        driver.close();



    }
}
