package com.myfirstproject;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
public class Day05_JavaFakerTest {
    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void radioButton(){
        driver.get("https://www.facebook.com/");
//        clicking on the create new account link
        driver.findElement(By.linkText("Create new account")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.phoneNumber().cellPhone());
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
//        Selecting birth month
        WebElement month=driver.findElement(By.id("month"));
        Select monthSelect = new Select(month);
        monthSelect.selectByVisibleText("Jun");
//        Selecting birth day
        WebElement day = driver.findElement(By.id("day"));
        Select daySelect = new Select(day);
        daySelect.selectByIndex(2);
//        Selecting birth year
        WebElement year = driver.findElement(By.id("year"));
        Select yearSelect = new Select(year);
        yearSelect.selectByVisibleText("2000");
//        Clicking on the Sign up
        driver.findElement(By.name("websubmit")).click();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
}