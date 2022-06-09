package com.cydeo.tests.day10_upload_actions_jsexecutor;

import com.cydeo.tests.day8_properties_config_reader.ConfigurationReader;
import com.github.javafaker.Faker;
import com.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_Registration_Form {

    @Test
    public void registration_form_test(){

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        //3. Enter first name
        //4. Enter last name
        //5. Enter username
        //6. Enter email address
        //7. Enter password
        //8. Enter phone number
        //9. Select a gender from radio buttons
        //10. Enter date of birth
        //11. Select Department/Office
        //12. Select Job Title
        //13. Select programming language from checkboxes
        //14. Click to sign up button
        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.

        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));

        Faker faker = new Faker();

        WebElement firstName = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = Driver.getDriver().findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys(faker.name().lastName());

        String user = faker.bothify("help????###");
        WebElement userName = Driver.getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys(user);

        WebElement email = Driver.getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(user + "@email.com");

        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(faker.numerify("########"));

        WebElement phone = Driver.getDriver().findElement(By.xpath("//input[@name='phone']"));
        phone.sendKeys(faker.numerify("###-###-####"));

        WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
        gender.click();

        WebElement birthday = Driver.getDriver().findElement(By.xpath("//input[@name='birthday']"));
        birthday.sendKeys(faker.number().numberBetween(1,12) + "/"
                + faker.number().numberBetween(1,12) + "/"
                + faker.number().numberBetween(1930,2020));

        Select department = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        department.selectByIndex(faker.number().numberBetween(1,9));

        Select jobTitle = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByIndex(faker.number().numberBetween(1,8));

        Driver.getDriver().findElement(By.id("inlineCheckbox2")).click();

        Driver.getDriver().findElement(By.id("wooden_spoon")).click();

        String expectedResult = "You’ve successfully completed registration.";
        String actualResult = Driver.getDriver().findElement(By.xpath("//h4/following-sibling::p[1]")).getText();

        Assert.assertEquals(expectedResult,actualResult);




    }



}
