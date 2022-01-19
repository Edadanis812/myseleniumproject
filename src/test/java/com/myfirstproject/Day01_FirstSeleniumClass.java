package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_FirstSeleniumClass {
    public static void main(String[] args) {
        //System.setProperty("DRIVER TYPE","DRIVER PATH");
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//.exe for windows
        //Creating the WebDriver object
        //Polymorphism
        WebDriver driver=new ChromeDriver();
        //Now that I created driver object, I can use that to interact with the web based application
        //get("");-> used to go to a URL
        driver.get("https://www.google.com/");
    }
}
