package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewTabsSel4 {
    //INTERVIEW: Will be asked differences S3 and S4 in handling windows?


    //New tab acilmasini sagliyor. Slenium 4 ile for each loop kullanmadan yapmamizi sagliyor.
    //Task sonunda hangi tab gidecegini gosteriyoruz.
    @Test
    public void newTabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        //1.Open google in the tab 1
        driver.get("https://www.google.com");
        String googleWindowHandle= driver.getWindowHandle();//to switch back. That is why we are using handle
        //2.Open amazon in the tab 2
        //This is going to create and switch new EMPTY/BLANK TAB
       WebDriver amazonTab= driver.switchTo().newWindow(WindowType.TAB);
        amazonTab.get("https://www.amazon.com");
       String amazonWindowHandle=driver.getWindowHandle();  //so to get every new tab's id , do we use driver.getWindowHandle(); ?

       //3.Open Linkedin in a new tab
        //Create a new empty tab and switch tto tha automatically
        WebDriver linkedinTab=driver.switchTo().newWindow(WindowType.TAB);
        linkedinTab.get("https://www.linkedin.com");
        //getting the window handle of that window b/c I am working on multiple tabs
        String linkedinWindowHandle=driver.getWindowHandle();


        //Switching back to google tab
        Thread.sleep(3000);//3 sec
        driver.switchTo().window(googleWindowHandle);
        System.out.println("Google URL =>"+ driver.getCurrentUrl());

        //Switching back to amazon tab
        Thread.sleep(3000);//3 sec
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("Amazon URL =>"+ driver.getCurrentUrl());

        //Switching back to LinkedIn tab
        Thread.sleep(3000);//3 sec
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("LinkedIn URL =>"+ driver.getCurrentUrl());


    }
}
