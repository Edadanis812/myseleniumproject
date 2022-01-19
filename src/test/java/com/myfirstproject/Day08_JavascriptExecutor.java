package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day08_JavascriptExecutor extends TestBase {
    /*
      What is JS Executor?
    - It is a selenium api that is used for handling some elements.
    - Javascript executor has some methods that makes automation effective.

    How did you use it in your framework?
    - I used js executor to click elements, it works well handling the clicks.
    - I also use it for scrolling. Js executor let us scroll onto the specific web elements.
     */

    @Test
    public void scrollIntoView() throws InterruptedException  {
        //CREATING javascript executor object
        //Casting driver
        JavascriptExecutor je=(JavascriptExecutor) driver;
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        WebElement ourRooms = driver.findElement(By.xpath("//*[.='Our Rooms']"));
        //It is for specific element.
        je.executeScript("arguments[0].scrollIntoView(true);",ourRooms);

    }
    @Test
    public void clickWithJS(){
        driver.get("http://a.testaddressbook.com/sign_in");
        //Click on sign in button using js executor
        // //input[@type='submit']
        WebElement signInButton= driver.findElement(By.xpath("//input[@type='submit']"));
        //signInButton.click();
        //NOTE:Normally, click() method works with selenium. We use this whe it is good.
        //Some elements can be challenging to click.
        //In that case, we have javascripexecutor cllick as an alternative
        //This performs better on some applications
        //Note that we can use js click anytime. Because it is faster.
        //1.Create javascriptexcutor object
        JavascriptExecutor je= (JavascriptExecutor) driver;
        //2.Use the aproppriate method
        je.executeScript("arguments[0].click();",signInButton);
        //Assert that the click happened using the message
        Assert.assertTrue(driver.getPageSource().contains("Bad email or password."));
    }
    @Test
    public void scrollDownWithJS() throws InterruptedException {
        driver.get("https://www.carettahotel.com/");
        Thread.sleep(3000);
        //Scroll down to the page using js executor
        JavascriptExecutor je=(JavascriptExecutor) driver;
        //It is really common.It is going to take to bottom of the website.
        //We do not remember it.Also, we do not need to know javascript.
        //Try to remember only method
        je.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }



}
