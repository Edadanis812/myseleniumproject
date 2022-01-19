package com.myfirstproject;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
public class Day11_ExtentReports extends TestBase {
//    3 libraries to remember?????
//    Extent reports are used for customized html reports
//    it is used to add steps on teh test cased when needed.
//    we have the extent reports set ups in test base

    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the google home page");
        driver.get("https://www.google.com");
        extentTest.pass("Searching for iphone");
        driver.findElement(By.name("q")).sendKeys("iphone x"+ Keys.ENTER);
        extentTest.pass("Printing the result");
//        Logging as failed
        extentTest.fail("THIS WILL FAIL");
//        logging as sipped
        extentTest.skip("THI IS SKIPPED");

    }
}