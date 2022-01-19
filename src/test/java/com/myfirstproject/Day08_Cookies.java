package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class Day08_Cookies {
    //IT SHOULD BE INTERVIEW QUESTION WITH COOKIES
    //EACH WEBSITE HAS DIFFERENT COOKIES

    //Class: Cookies
    //Method: handleCookies

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @Test
    public void handleCookies(){
        //-Go to amazon  and automate the tasks:
        driver.get("https://www.amazon.com");
        //1. Find the total number of cookies
        Set<Cookie> allCookies=driver.manage().getCookies();
        //System.out.println(allCookies.size());
        int numberOfCookies=allCookies.size();
        System.out.println(numberOfCookies);
        //2. Print all the cookies
        for(Cookie eachCookie:allCookies){
            System.out.println("Each Cookies: "+eachCookie);
            System.out.println("Each Cookie Name: "+eachCookie.getName());
            System.out.println("Each Cookie Values: "+eachCookie.getValue());
        }
        //3. Get the cookies by their name
            //When we want to get single cookie, we can get by cookie name
        System.out.println("Cookie name i18n-prefs: "+driver.manage().getCookieNamed("i18n-prefs"));
        //4. Add new cookie
            //1.Create cookie object
        Cookie cookie=new Cookie("My-Fav-Cookie","White-Chocolate");
            //2.Add cookie
        driver.manage().addCookie(cookie);
            //Check if cookie is added
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//8
        //5. Delete cookie by name
        driver.manage().deleteCookieNamed("session-id");//deleting last cookie
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//7
        //6. Delete all of the cookies
            //Always, we have to go to "driver"
        driver.manage().deleteAllCookies();
            //check if all cookies are deleted
        allCookies=driver.manage().getCookies();
        System.out.println(allCookies.size());//0
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}
