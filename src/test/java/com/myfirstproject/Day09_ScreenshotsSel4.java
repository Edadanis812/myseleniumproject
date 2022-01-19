package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class Day09_ScreenshotsSel4 extends TestBase {
    /*
    -In Selenium 4, we can take screenshot of specific screenshot/
    -If you want, you do not to get whole screenshot. You can take screenshot only Google logo part.

     */
    @Test
    public void getTakeScreenshotTest() throws IOException {
        driver.get("https://www.google.com/");
        //Get the screenshot of ONLY THE GOOGLE LOGO
        WebElement googleLogo = driver.findElement(By.xpath("//img[@class='lnXdpd']"));
        File googleLogoImage = googleLogo.getScreenshotAs(OutputType.FILE);
        //Save the file as googleLogo.png
        File finalPath = new File("googleLogo.png");
        FileUtils.copyFile(googleLogoImage,finalPath);

    }
}
