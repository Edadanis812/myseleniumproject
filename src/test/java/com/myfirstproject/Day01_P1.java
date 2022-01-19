package com.myfirstproject;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_P1 {
    @Test
    public void test(){
        //Task:
        //System.setProperty("DRIVER TYPE","DRIVER PATH");
        //give path of driver
        //DRIVER PATH --> Where is your driver?
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        //Creating the WebDriver object = Polymorphism
        WebDriver driver=new ChromeDriver();
        //Now that I created driver object, I can use that to interact with the web based application
        //get("");-> used to go to a URL
        driver.get("https://www.google.com");

    }
    @Test
    public void navigation(){
        //Step 1: Set the path and driver name
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        //Step 2:
        WebDriver driver= new ChromeDriver();
        //Step 3:
        driver.get("https://www.google.com");
    }


}
