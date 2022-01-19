package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_VerifyURLTest {
    public static void main(String[] args) {
        /*
        Create a new class: VerifyURLTest
        Navigate to google homepage
        Verify if google homepage url is “www.google.com”
        */
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//.exe for windows
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

       //Getting the URL page
       String actualURL=driver.getCurrentUrl();
       String expectedURL=";www.google.com";

       //Verification
        if(actualURL.equals(expectedURL)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL: "+ actualURL);
            System.out.println("EXPECTED: "+expectedURL);
        }
        driver.quit();
        /*
        FAIL
        ACTUAL: https://www.google.com/
        EXPECTED: ;www.google.com
        *Then what do you do when your test case fails?
        1.Run scrip again to make sure
        2.Do manual testing to make sure
        3.Now. I know that expected and actual result is not the same
        4.Then we communicate with BA(write acceptance criteria) or talk to developer, tech lead, test lead

        -------------------NOTE-------------------
        *Testers do not fix a code. We report the bugs. Developers the fix.

        5.After verify the there is a bug then what do you do?
        -Follow the company procedures
        -If they are using JIRA XRAY then open a bug ticket.
        6.Ticket opened, dev told you that bug is fixed.
        -Retest to make sure.
        -if all good then close the bug ticket
         */
    }
}
