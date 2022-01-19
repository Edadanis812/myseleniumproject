package com.myfirstproject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;
public class Day06_NewTabs {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @Test
    public void newTabs() throws InterruptedException {
//        WINDOW HANDLE: getWindowHandle(); return the window handle of the current window.
        String window1Handle = driver.getWindowHandle();
        System.out.println(window1Handle);
//        Then user verifies the text : “Opening a new window”
        String window1Text = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",window1Text);
//        Then user verifies the title of the page is “The Internet”
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet",window1Title);
//        When user clicks on the “Click Here” button
        driver.findElement(By.linkText("Click Here")).click();
//        NOTE : when we click the link new tab open. THEN we must switch to the new tab
//        Getting all open window handles
        Set<String> allWindowHandles = driver.getWindowHandles();
//        Loop1: eachWindowHandle = window1handle
//        Loop2: eachWindowHandle = window2handle
//        [window1handle, window2handle]
//        Switching to the second window.
//        Logic: Switch IF DRIVER IS NOT ON THE WINDOW1
        for (String eachWindowHandle : allWindowHandles){
            if (!eachWindowHandle.equals(window1Handle)){
                driver.switchTo().window(eachWindowHandle);
                break;
            }
        }
//        Then user verifies the new window title is “New Window”
        String window2Title = driver.getTitle();
        Assert.assertEquals("New Window",window2Title);
        String window2Handle= driver.getWindowHandle();
        System.out.println(window2Handle);

//        Then user verifies the text: “New Window”
        String window2Text=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",window2Text);

//        When user goes back to the previous window and then verifies the title : “The Internet”

        //Switching back to window 1
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Switching back to window 2
        Thread.sleep(5000);
        driver.switchTo().window(window2Handle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        //Switching back to window 1
        Thread.sleep(5000);
        driver.switchTo().window(window1Handle);
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
    @After
    public void tearDown(){
        driver.close();

    }
}