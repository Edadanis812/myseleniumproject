package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

//Notes:
/*
We can't test windows application with selenium. But we can use JAVA to test.
 We can use Java to check if a file exist on our computer or not
System.getProperty("user.dir"); =>gives the path of the current folder
System.getProperty("user.home"); =>gives you the user folder
Files.exists(Paths.get(“path of the file”)); =>Checks if a file path exist on your computer or not
We can use this Java concept to check if a downloaded file is in our download folder
 */
public class Day08_FileDownloadTest{
    //Create a class:FileDownloadTest
    //downloadTest()
    //In the downloadTest() method, do the following test:
    //Go to https://the-internet.herokuapp.com/download
    //Download flower.png file
    //Then verify if the file downloaded successfully
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
        @Test
        public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.linkText("IMG_1354.jpg")).click();
//        Verify if the download is successful
//        Waiting for th file to be downloaded completely
        Thread.sleep(2000);
//        path of the downloaded file
        String filePath = System.getProperty("user.home")+"/Downloads/IMG_1354.jpg";

//        Verification
        boolean isDownloaded = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownloaded);

    }
    @After
    public void tearDown(){
        driver.quit();
    }




}
