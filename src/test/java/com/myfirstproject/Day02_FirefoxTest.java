package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_FirefoxTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");//.exe for windows
        WebDriver driver=new FirefoxDriver();
        driver.manage().window().maximize();
        //Going to the google.com
        driver.get("https://www.google.com");

        driver.quit();
    }
}
