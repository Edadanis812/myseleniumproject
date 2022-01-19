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
import java.util.concurrent.TimeUnit;

public class Day04_checkBox {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        driver = new ChromeDriver();
        //Adding implicitly wait
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //selenium 3
        //implicitly wait is used to put dynamic wait for the driver
        //dynamic wait means driver will only wait when needed
        //when we use implicitly wait in before method, then we do not need to use implicitly wait again
        //thread.sleep(10) means wait 10 s no matter what
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //selenium 4, max waiting is 10 s, wait up to 10 s
        driver.manage().window().maximize();
        // driver.get("https://www.carettahotel.com/Account/Logon");
    }

    @Test
    public void checkBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));

        //verify that checkbox1 is not checked
        Assert.assertTrue(!checkbox1.isSelected());  //if not checked will return true, and it will pass


        //locate the checkbox2
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //verify that checkbox 2 is selected
        Assert.assertTrue(checkbox2.isSelected()); //passes if checkbox2 is selected

        //how to check or uncheck a checkbox
        checkbox1.click();      //it will check
        checkbox2.click();      //it will uncheck

        //how to check only unchecked boxes?
        //if checkbox is not checked then click
        if (!checkbox1.isSelected()) {  //click if it is not checked
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        //asserting if both checkboxes are checked
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
    }
    @After
    public void TearDown(){ //It is using the close the browser.
        driver.quit();
    }
}