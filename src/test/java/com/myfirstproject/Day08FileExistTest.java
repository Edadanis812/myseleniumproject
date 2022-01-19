package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

public class Day08FileExistTest {

    //And verify a file exist in your computer
    //Steps:
    //Download the image that I shared.
    //Move in your desktop
    //Verify that file exist.

    //This is coming from "Java".
    @Test
    public void isExist(){
        //It is going to give Home Path.
        String homeDirectory=System.getProperty("user.home");
        System.out.println(homeDirectory);
        //Path of the image
        String pathOfImage=homeDirectory+"/Desktop/download.png";
        System.out.println(pathOfImage);
        //Verify is a path exist.
        boolean isExist=Files.exists(Paths.get(pathOfImage));
        Assert.assertTrue(isExist);

    }
}
