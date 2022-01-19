package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class Day01_Navigations {
    public static void main(String[] args) throws InterruptedException {
        //Step 1: set the path and driver name
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//.exe for windows
        //Step 2: create WebDriver object
        WebDriver driver=new ChromeDriver();
        //Maximum the window
        driver.manage().window().maximize();
        //Step 3: Now I have driver, I can use driver in automation
        //go to google
        driver.get("https://www.google.com/");

        //putting 5 second wait
        Thread.sleep(5000);//5 seconds hard wait

        //On the same class, Navigate to amazon home page https://www.amazon.com/
        driver.navigate().to(" https://www.amazon.com/");
        Thread.sleep(5000);
        //Navigate back to google
        driver.navigate().back();
        Thread.sleep(5000);
        //Navigate forward to amazon
        driver.navigate().forward();
        Thread.sleep(5000);
        //Refresh the page
        driver.navigate().refresh();
        Thread.sleep(5000);
        //Close/Quit the browse
        //To close a driver, we can use close() or quit()
        driver.close();
        //driver.quit();

        /*
        INTERVIEW QUESTION:
        -What is the difference between get() and navigate.to?
        1.get() easier to use, used more than navigate()
        2.get() is a little faster
        3.get() has one option(String) but navigate has two options such as string or url as parameter.
        4.navigate has more options: back,forward,refresh

        -What is the differences between close and quit?
        *close()-> closes only current working browser
        *quit()->closes all browsers
        *quick is more stronger.

        -What is the Thread.sleep()?
        *It is used to put some wait.
        *Thread,sleep(5000); puts 5 second ON THIS STEP
        *1000 is 1 sec and 5000 is 5 sec.
        *Thread.sleep() is a JAVA wait. It is not a Selenium wait.
        *Because this is HARD wait.
        *It means, this will put extra EVEN IF WE DON'T NEED
        *We will use selenium waits. They will be DYNAMIC WAIT.


         */


    }
}



