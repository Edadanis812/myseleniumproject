package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        //getPageSource() returns page source code as a string
        //We might use this to verify if a certain text exist in the entire page
        //Note that pageSource is not used a lot to do assertions
        //Because it is too general and can lead false result
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//.exe for windows
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        //Getting the page source
        String pageSource=driver.getPageSource();
        //Checking if "Registry" exist on the entire page
        if (pageSource.contains("Registry")){
            System.out.println("PASS");
        }else{
            System.out.println("FAILS");
        }
        driver.quit();
    }
}
