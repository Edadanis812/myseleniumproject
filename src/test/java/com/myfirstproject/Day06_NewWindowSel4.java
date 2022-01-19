package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day06_NewWindowSel4 {
    @Test
    public void newWindows() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //Open google in window 1
        driver.get("https://www.google.com");


        String googleWindowHandle = driver.getWindowHandle();
        //Open Amazon in window 2
        //Creating a new empty Window and switching it
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.com");
        String amazonHandle = driver.getWindowHandle();


        //Open Linkedin in window 3
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinHandle = driver.getWindowHandle();

        //SWITCH BACK TO google window
        Thread.sleep(5000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("GOOGLE URL => "+driver.getCurrentUrl());
        //SWITCH BACK TO google amazon
        Thread.sleep(5000);
        driver.switchTo().window(amazonHandle);
        System.out.println("AMAZON URL => "+driver.getCurrentUrl());
        //SWITCH BACK TO google linkedIn
        Thread.sleep(5000);
        driver.switchTo().window(linkedinHandle);
        System.out.println("LINKEDIN URL => "+driver.getCurrentUrl());
    }
    }
