package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Day10_Synchronization1 {
    //Create a class:Synchronization1. Create a method: synchronization1
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click on remove button
    //And verify the message is equal to “It's gone!”
    //Then click on Add button
    //And verify the message is equal to “It's back!”

    //DO NOT USE TEST BASE, SINCE IMPLICIT WAIT IS ALREADY THERE
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void synchronization1() {
        //Click on remove button
        driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        //And verify the message is equal to “It's gone!”
        /*
        -After we click on the button, the “It's gone!” message take a few seconds.
        -Note that IF I DONT USE WAIT, then element will not be found
        -We are gonna get "Nosuchelementexception"
        -In this case we can use implicit and explicit wait
        -We will use "Explicit Wait" for the message
        -There 2 ways to create it.
            1. Create the WebDriverWait object
            2.Use appropriate condition
         */
        //        1. CREATE WEBDRIVERWAIT object
//        WebDriverWait wait = new WebDriverWait(driver,10);//SELENIUM3
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));//SELENIUM4
//        2. Use for a specific condition
//        We have problem of visibility on the It's gone message
//        So we will wait for that locator
//        Explicit wait does the followings:
//        1. waits for the element up to 10 secs
//        2. If the element is visible in 10 secs, then it RETURNS that element


        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String goneMessageText = goneMessage.getText();
        Assert.assertEquals("It's gone!",goneMessageText);
//        Then click on Add button
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
//        And verify the message is equal to “It's back!”

        WebElement backMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        String backMessageText = backMessage.getText();
        Assert.assertEquals("It's back!",backMessageText);
    }
    public void synchronization2() throws InterruptedException {
//NO WAIT IN THIS TEST
//        If you don not use wait, the message will not be found
//        Click on remove button
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();
//        getting teh message element
//        Thread.sleep(5000);
//        This test will wait because if imlicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement goneMessage = driver.findElement(By.xpath("//p[@id='message']"));
//        getting text of the message
        String goneMessageText = goneMessage.getText();
//        assertion
        Assert.assertEquals("It's gone!",goneMessageText);
    }


}
