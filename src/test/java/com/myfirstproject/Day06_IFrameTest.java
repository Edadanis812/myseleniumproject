package com.myfirstproject;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_IFrameTest {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(" https://the-internet.herokuapp.com/iframe");
    }
    //Create a class: IFrameTest
    //Create a method: iframeTest
    //Go to https://the-internet.herokuapp.com/iframe
    //Verify the Bolded text contains “Editor”
    //Locate the text box
    //Delete the text in the text box
    //Type “This text box is inside the iframe”
    //Verify the text Elemental Selenium text is displayed on the page
    @Test
    public void iframeTest(){
        //Verify the Bolded text contains "Editor"
        //When we check inspect, "//h3" is unique. That is why we can use it like that.

        String boldedText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(boldedText.contains("Editor"));


        //WE MUST SWITCH TO THE IFRAME TO LOCATE THE ELEMENTS INSIDE THE IFRAME
        //THERE ARE 3 WAY TO SWITCH TO IFRAME
        //1.INDEX (In this case we have only 1 iframe.That is why we wrote index:0)
        //driver.switchTo().frame(0);//switching the first frame by index
        //2.SWITCH BY ID OR NAME
        //driver.switchTo().frame("mce_0_ifr");
        //3.WEBELEMENT



        WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElement);
        //We can combine above code
        //WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")).frame(iframeElement);

        //Locate the text box



        WebElement textBox = driver.findElement(By.xpath("//p"));

        // Delete the text in the text box
        textBox.clear();
        //Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the iframe");
        //Verify the text Elemental Selenium text is displayed on the page
        // Elemental Selenium text is OUTSITE of the iFrame.That is why we need to switch to the parent or default content.
        //That element is OUTSIDE of the iframe. Then switch to the Parent or Default content
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
