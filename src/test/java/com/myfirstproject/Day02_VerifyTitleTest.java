package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyTitleTest {
    /*
    	1.Create a new class: VerifyTitleTest
	    2.Navigate to google homepage
	    3.Verify if google title is “Google”
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//.exe for windows
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //Actual title of a page
        String actualTitle=driver.getTitle();//Return type is "string"
        //Expected Title of the page
        String expectedTitle="Google";
        //Verification!!!!!!!!
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }
        else{
            System.out.println("FAIL");
            System.out.println("ACTUAL: "+ actualTitle);
            System.out.println("EXPECTED: "+expectedTitle);
        }

        driver.quit();
    }
}
