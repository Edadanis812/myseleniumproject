package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day08_FileUploadTest {
    //Class Name: FileUploadTest
    //Method Name: fileUploadTest
    //When user goes to https://the-internet.herokuapp.com/upload
    //When user selects an image from the desktop
    //And click on the upload button
    //Then verify the File Uploaded!  Message displayed
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void fileUploadTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
//      send the path of the file
//        STEP1: Path of the image
        String pathOfImage=System.getProperty("user.home")+"/Desktop/download.png";

        Thread.sleep(3000);
//        STEP 2: send keys the path of the image
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys(pathOfImage);
//        STEP3 : Click upload
        WebElement submitButton = driver.findElement(By.id("file-submit"));
        submitButton.click();

        Thread.sleep(3000);
//        Verify the file is uploaded
        String actualSuccessMessage = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("File Uploaded!",actualSuccessMessage);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
