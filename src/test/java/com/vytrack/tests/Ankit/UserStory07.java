package com.vytrack.tests.Ankit;

import com.vytrack.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class UserStory07 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");
    }

    @Test
    public void login_Store_manager() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("storemanager205");
        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);
    }

    @Test
    public void login_Sales_manager() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("salesmanager144");
        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);
    }
    @Test
    public void login_Truck_Driver() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("user178");
        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);
    }
    @Test
    public void Verify_Vehicles() {
        //Enter username
        WebElement userName1 = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName1.sendKeys("storemanager205");

        //Enter password
        WebElement password1 = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password1.sendKeys("UserUser123" + Keys.ENTER);

        //open vehicles  page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");

        //verify the vehicles are not selected
        WebElement checkbox = driver.findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']/thead/tr/th/div/button/input"));
        System.out.println("checkboxes are selected  = " + checkbox.isSelected());

        //click the first box to select all the vehicles
        checkbox.click();
        System.out.println("checkboxes are selected  = " + checkbox.isSelected());}





    @Test
    public void verify_each_vehicle() {
        //Enter username
        WebElement userName = driver.findElement(By.xpath("//input[@id='prependedInput']"));
        userName.sendKeys("salesmanager144");
        //Enter password
        WebElement password = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
        password.sendKeys("UserUser123" + Keys.ENTER);

        //open vehicles  page
        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");

        //verify that user can select any vehicle they want
        WebElement car1= driver.findElement(By.xpath("//tbody[@class='grid-body']/tr[1]/td[1]/input"));
        System.out.println("car1.isSelected() = " + car1.isSelected());
        car1.click();
        System.out.println("car1.isSelected()   = " + car1.isSelected());


    }
}
