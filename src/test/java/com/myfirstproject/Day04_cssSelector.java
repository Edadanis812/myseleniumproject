package com.myfirstproject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day04_cssSelector {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");// WINDOWS
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.carettahotel.com/Account/Logon");
    }
    @Test
    public void cssTest(){
        /*
        CssSelector: This is similiar to xpath
        tag[attribute='value']
        #=id
        .=class
        EX: <input id="btnSubmit" type="submit" value="Log in" class="btn btn-primary py-3 px-5">
        css = input[id = 'btnSubmit']
        css = .btn-primary
        css =  #btnSubmit

         */
        //Username
        driver.findElement(By.cssSelector("input[id='UserName']")).sendKeys("manager");
        //Password
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Manager1!");
        //Login Button
        //driver.findElement(By.cssSelector("input[type=submit']")).click(); OR
        driver.findElement(By.cssSelector("#btnSubmit")).click();
    }
    @After
    public void TearDown(){ //It is using the close the browser.
        driver.quit();
    }
}
