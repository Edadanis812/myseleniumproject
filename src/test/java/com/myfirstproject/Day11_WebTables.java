package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_WebTables extends TestBase {

    @Test
    public void printEntireTable(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Table Data***");
        WebElement entireTable = driver.findElement(By.xpath("(//table[@id='table1'])"));
        System.out.println(entireTable);

    }

    @Test
    public void getRows(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***Print Table Rows***");
        List<WebElement> tableRows = driver.findElements(By.xpath("(//table[@id='table1'])//tbody//tr"));
        int rowNum=1;
        for (WebElement eachRow : tableRows){
            System.out.println("Row Number "+rowNum+" => "+eachRow.getText());
            rowNum++;
        }
    }
    @Test
    public void getRow3(){
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***3rd Row***");
        WebElement row3 = driver.findElement(By.xpath("(//table[@id='table1'])//tbody//tr[3]"));
        System.out.println(row3.getText());
    }
    @Test
    public void getCellData() {
        // THIS PART IS REALLY IMPORTANT.
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***All Table Data***");
        //(//table[@id='table1'])//tbody//tr//td
        //(//table[@id='table1'])//tbody//td
        ////table[@id='table1']//tbody//td
        int dataNumber = 1;
        List<WebElement> allCellData = driver.findElements(By.xpath("//table[@id='table1']//tbody//td"));
        for (WebElement eachCellData : allCellData) {
            System.out.println("Data number " + dataNumber + " => " + eachCellData.getText());
            dataNumber++;
        }
    }
    @Test
    public void getColumns(){
        //Get column 5
        //(//table[@id='table1'])//tbody//tr//td[5]
        //table[@id='table1']//qstr//td[5]
        // table[@id='table1']//td[5]
        driver.get("https://the-internet.herokuapp.com/tables");
        System.out.println("***5th Column Data***");
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tbody//tr//td[5]"));
        for (WebElement columnData :column5Data){
            System.out.println(columnData.getText());
        }
    }
    //    Create a printCellData method
//     printCellData(2,3)  => 2nd row 3rd column => //table[@id='table1']//tbody//tr[2]//td[3]
//     printCellData(1,4)  => 1st row 4th column => //table[@id='table1']//tbody//tr[1]//td[4]
    public void printCellData(int row, int column){
        try {
            String dynamicXpath ="//table[@id='table1']//tbody//tr["+row+"]//td["+column+"]";
            WebElement cellData =driver.findElement(By.xpath(dynamicXpath));
            System.out.println(cellData.getText());
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
        }
    }
    @Test
    public void printCellTest(){
        driver.get("https://the-internet.herokuapp.com/tables");
        printCellData(3,2);
    }
}
