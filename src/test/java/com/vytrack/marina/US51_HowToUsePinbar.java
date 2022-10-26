package com.vytrack.marina;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US51_HowToUsePinbar {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // 1.Set up browser

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(" https://qa2.vytrack.com/user/login");
    }

    @Test
    public void pin_test() {

        //  Enter valid username // "user178"
        WebElement inputUsername = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        inputUsername.sendKeys("user178");


        //  Enter valid password// UserUser123
        WebElement inputPassword = driver.findElement(By.xpath("//input[@name='_password']"));
        inputPassword.sendKeys("UserUser123");


        // Click to Log In button
        WebElement loginBtn = driver.findElement(By.xpath("//div[@class='form-signin__footer control-group form-row']/button"));
        loginBtn.click();

        // Verify link ia as expected:
        // Expected :"Learn how to use this space"
        WebElement learnHowUseThisSpaceBtn = driver.findElement(By.xpath("//div[@class='pin-bar-empty']/a"));

        String actualLink = learnHowUseThisSpaceBtn.getText();
        Assert.assertEquals(actualLink, "Learn how to use this space");

        learnHowUseThisSpaceBtn.click();

        // Verify text  "How To Use Pinbar"
        WebElement howToUsePinbar =driver.findElement(By.xpath("//div[@class='clearfix']/h3"));

        String actualTitle = howToUsePinbar.getText();
        Assert.assertEquals(actualTitle, "How To Use Pinbar");

        // Verify text "Use pin icon on the right top corner of page to create fast access link in the pinbar."
        WebElement usePinIcon = driver.findElement(By.xpath("//div[@class='container-fluid']/div[1]/p[1]"));

        String actualTitle2 = usePinIcon.getText();
        Assert.assertEquals(actualTitle2,"Use pin icon on the right top corner of page to create fast access link in the pinbar.");


        // verify image
        WebElement imageSrc = driver.findElement(By.xpath("//img[@src='/bundles/oronavigation/images/pinbar-location.jpg']"));

        Assert.assertTrue(imageSrc.isDisplayed());

        System.out.println("Src attribute is: "+ imageSrc.getAttribute("src"));


    }
    @AfterMethod
    public void tearDown(){
        //driver.close();
        driver.quit();
    }

}
