package com.myfirstproject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/*
Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfully clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello World”, click OK, and Verify “You entered: Hello Word”
 */
public class Day06_Alerts {

    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
        //TASK 1:
        //click on the first alert,
        //verify the text “I am a JS Alert” ,
        //click OK ,
        //and Verify “You successfully clicked an alert”


        //locating the fist button
        //driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        WebElement button1= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        //clicking
        button1.click();
        //Verify the text "I am a JS Alert"
        //We can not locate the element. That is why we are using switchTo()
        // We cannot inspect alert elements, sio we must use switchTo() function to handle it.
        String alertText=driver.switchTo().alert().getText();
        //We need to do assertion to check the string
        Assert.assertEquals("TEXT DOES NOT MATCH","I am a JS Alert",alertText);
        //Click OK means "accept()"
        driver.switchTo().alert().accept();
        //Verify “You successfully clicked an alert”
        String actualResult=driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",actualResult);
    }
    //TASK 2:
    //dismissAlert()=> click on the second alert,
    //verify text "I am a JS Confirm”,
    // click cancel, and
    // Verify “You clicked: Cancel”
    @Test
    public void dismissAlert(){

//        click on the second alert,
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
//        verify text "I am a JS Confirm”,
            String actualAlertText = driver.switchTo().alert().getText();
            Assert.assertEquals("I am a JS Confirm",actualAlertText);
//        click cancel, "
            driver.switchTo().alert().dismiss();
//        "and Verify “You clicked: Cancel”
            String actualResult = driver.findElement(By.id("result")).getText();
            Assert.assertEquals("You clicked: Cancel",actualResult);
    }

    //NOTE:
    //EXPECTED DATA COMES FROM THE USER STORIES/ACCEPTANCE CRITERIA
    //ACTUAL COMES FROM THE WEBSITE




    //Task 3:
    //sendKeysAlert()=> click on the third alert,
    // verify text “I am a JS prompt”,
    // type “Hello World”,
    // click OK, and
    // Verify “You entered: Hello Word”
    @Test
    public void sendKeysAlert(){
//    click on the third alert,
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
//    verify text “I am a JS prompt”,
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS prompt",actualText);
//    type “Hello World”, click OK,
        driver.switchTo().alert().sendKeys("Hello World");
//        click OK
        driver.switchTo().alert().accept();
        //    and Verify “You entered: Hello World”
        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You entered: Hello World",actualResult);
    }
}
