package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day08_AuthenticationTest {
    //Auth are used for security reason
    //One way to auth is to use below syntax:
    //https://username:password@URL
    //       username : admin
    //       password : admin
    //       url      :  the-internet.herokuapp.com/basic_auth
    //     URL FOR AUTH:
    //     https://admin:admin@the-internet.herokuapp.com/basic_auth
    //driver.get(“https://admin:admin@the-internet.herokuapp.com/basic_auth”);
    //This will auth the page
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void basicAuth(){
        //Authentication is done for verification
        //https://username:password@URL
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");//login
        String congratsMessage=driver.findElement(By.xpath("//p")).getText();
        Assert.assertTrue(congratsMessage.contains("Congratulations!"));
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
