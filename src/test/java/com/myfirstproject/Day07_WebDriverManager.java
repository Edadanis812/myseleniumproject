package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Day07_WebDriverManager {
    WebDriver driver;
    @Before
    public void setUp(){
        //Notes:
        //    System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//    =>>>>>WebDriverManager.chromedriver().setup();


        //setProperty is extra work. That is why we can use other code.
        //System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        //From now on, we will  WebDriverManager.chromedriver().setup();
        //WebDriverManager.chromedriver().setup(); calls and set up the driver
        //This is more efficient because we do not need to create path for location.EX: We can change directly to firefox.
        //No need to give path, automatically used require driver related files.
        //Easy to use it.
        //Easy to create different driver.
        WebDriverManager.chromedriver().setup();
        //Headless
        //Below will run headless.
        //You will not see the browser
        //But test will execute
        //driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
}
