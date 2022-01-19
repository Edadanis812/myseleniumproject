package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
    public class Day11_Homework extends TestBase {

        @Test
        public void homework(){
            driver.get("https://the-internet.herokuapp.com/tables");
            System.out.println("**** Last Name ****");
            List<WebElement> lastName = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[1]"));
            List<String> lastNames = new ArrayList<>();
            for(int i =0; i< lastName.size();i++){
                lastNames.add(lastName.get(i).getText());
            }
            Collections.sort(lastNames);
            System.out.println(lastNames);
        }
/* SECOND SOLUTION:

 */
        //
}
