package com.myfirstproject;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
//1. Create a class
public class SignInHomework {
        WebDriver driver;

        @Before
        public void setUp(){
            System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            //2. Go to http://automationpractice.com/index.php
            driver.get("http://automationpractice.com/index.php");
            driver.manage().window().maximize();
        }
        @Test
        public void test() throws InterruptedException {
            //3.Click on sign in link
            driver.findElement(By.xpath("//a[@rel='nofollow']")).click();
            //4.Send your email and click on create an account button.We will use that email. Make sure to save that email.
            //If the email is already used for account creation you can not use it again.
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("ed08@gmail.com");
            driver.findElement(By.name("SubmitCreate")).click();
            //5.Verify the Text : CREATE AN ACCOUNT
            String CreateAnAccount = driver.findElement(By.xpath("//h1[@class='page-heading']")).getText();
            Assert.assertEquals("Failed!","CREATE AN ACCOUNT",CreateAnAccount);
            System.out.println(CreateAnAccount);
            //6. Verify the Text: Your Personal Information
            String PersonalInformation = driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
            Assert.assertEquals("Failed!","YOUR PERSONAL INFORMATION",PersonalInformation);
            System.out.println(PersonalInformation);
            //7. Verify the Text: Title
            String VerifyTitle =  driver.findElement(By.xpath("//*[text()='Title']")).getText();
            Assert.assertEquals("Failed!","Title",VerifyTitle);
            System.out.println(VerifyTitle);
            //8.Select Your Title
            driver.findElement(By.id("id_gender1")).click(); //MR or MRS.
            //9.Enter your first name
            driver.findElement(By.name("customer_firstname")).sendKeys("EDA");
            //10. Enter your last name
            driver.findElement(By.id("customer_lastname")).sendKeys("DANIS");
            //11. Enter your email
            driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("ed08@gmail.com");
            //12. Enter your password
            driver.findElement(By.id("passwd")).sendKeys("12345678E!");
            //13. Enter DATE OF BIRTH
            //For day
            WebElement dayOfBirth = driver.findElement(By.name("days"));
            Select selectDay = new Select(dayOfBirth);
            selectDay.selectByIndex(9);
            //For month
            WebElement monthOfBirth = driver.findElement(By.name("months"));
            Select selectMonth = new Select(monthOfBirth);
            selectMonth.selectByValue("12");
            //For year
            WebElement yearOfBirth = driver.findElement(By.name("years"));
            Select selectYear = new Select(yearOfBirth);
            selectYear.selectByValue("1994");
            //14. Click on Sign up for our newsletter!
            driver.findElement(By.id("newsletter")).click();
            //15. Enter your first name
            WebElement firstName = driver.findElement(By.id("firstname"));
            firstName.clear();
            firstName.sendKeys("Eda");
            //16. Enter your last name
            WebElement lastName = driver.findElement(By.name("lastname"));
            lastName.clear();
            lastName.sendKeys("Danis");
            //17. Enter your company
            driver.findElement(By.id("company")).sendKeys("Danisment Inc.");
            //18. Enter your address
            //address1
            driver.findElement(By.id("address1")).sendKeys("Varlik Mahallesi 186.sok Antalya/Muuratpasa");
            //address2
            driver.findElement(By.id("address2")).sendKeys("10 Weston Ave. Boston/MA");
            //19. Enter your city
            driver.findElement(By.name("city")).sendKeys("Quincy");
            //20. SELECT STATE
            WebElement state1 = driver.findElement(By.id("id_state"));
            Select selectState = new Select(state1);
            selectState.selectByVisibleText("Alabama");
            //21. Enter postal/ZIP code
            driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("02131");
            //22. SELECT COUNTRY
            WebElement country = driver.findElement(By.name("id_country"));
            Select selectCountry = new Select(country);
            selectCountry.selectByVisibleText("United States");
            //23. Enter additional information
            driver.findElement(By.xpath("//textarea[@cols='26']")).sendKeys("Failed");
            //24. Enter home phone
            driver.findElement(By.name("phone")).sendKeys("1242434");
            //25. Enter mobile phone
            driver.findElement(By.name("phone_mobile")).sendKeys("6177498080");
            //26. Enter reference name


            WebElement referenceName = driver.findElement(By.id("ABC"));
            referenceName.clear();
            referenceName.sendKeys("TechProEd");
            //27. Click Register
            driver.findElement(By.name("submitAccount")).click();
            Thread.sleep(3000);
            //28. Then verify MY ACCOUNT is displayed on the home page
            String myAccount = driver.findElement(By.className("page-heading")).getText();
            Assert.assertEquals("MY ACCOUNT", myAccount);
            System.out.println(myAccount);
        }
        @After
        public void tearDown(){
            driver.quit();
        }


}
