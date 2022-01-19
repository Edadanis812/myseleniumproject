package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day11_ReadExcel {

    //Task
    //Import the apache poi dependency in your pom file
    //Create resources directory under java folder(right click on java and create the folder)
    //Add the excel file on the resources folder
    //Create a new package: excelautomation
    //Create a new class : ReadExcel
    //Create a new test method : readExcel()
    //Store the path of the  file in a string
    //Open the file
    //Open the workbook using fileinputstream
    //Open the first worksheet
    //Go to first row
    //Go to first cell on that first row and print
    //Go to second cell on that first row and print
    //Go to 2nd row first cell  and assert if the data equal to USA
    //Go to 3rd row 2nd cell-chain the row and cell
    //Find the number of row
    //Find the number of used row
    //Print country, capitol key value pairs as map object
    @Test
    public void readExcel() throws IOException {
        //Store the path of the  file in a string
        String path = "./src/test/java/resources/Capitals.xlsx";
//        Open the file
        FileInputStream fileInputStream = new FileInputStream(path);
//        Open the workbook using fileinputstream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Open the first worksheet
        Sheet sheet1 = workbook.getSheetAt(0);
//        Go to first row
        Row row1 = sheet1.getRow(0);
//        Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
//        Go to second cell on that first row and print
        Cell cell2=row1.getCell(1);
        //System.out.println(cell2);
        System.out.println(cell2.toString());//we have string version as well
//        Go to 2nd row first cell  and assert if the data equal to USA
       //Cell row2Cell1=sheet1.getRow(1).getCell(0);//IMPORTANT, WE CONVERT IT TO STRING FOR ASSERT
        String actualRow2Cell1=sheet1.getRow(1).getCell(0).toString();
        System.out.println(actualRow2Cell1);
        Assert.assertEquals("USA",actualRow2Cell1);
//        Go to 3rd row 2nd cell-chain the row and cell
        String row3Cell2=sheet1.getRow(2).getCell(1).toString();
        System.out.println(row3Cell2);
//        Find the number of row (THIS IS INTERVIEW QUESTION)-(We have 2 methods.)->11
        //Index starts from 0 so add 1 to match the row number
        int lastRowNumber=sheet1.getLastRowNum()+1; //LastRowNumber is giving less row number.That is we are adding +1-->11
        System.out.println(lastRowNumber);
//        Find the number of used row->11
        //Index starts from 1 so no need to add 1 to match
        int numberOfRowUsed= sheet1.getPhysicalNumberOfRows();
        System.out.println(numberOfRowUsed);
//        Print country, capitol key value pairs as map object
        //{USA=DC, France=Paris....}
        //We need to use any collection map,treeMap.hashMap etc.
        Map<String,String> countryCapitals=new HashMap<>();
        //Using loop to get each cell data and store in the map
        for(int rowNumber=1;rowNumber<lastRowNumber;rowNumber++){
            //Boyle teker teker yazmaktansa. Tek line'da olayi bitiriyoruz.
//            usa=sheet1.getRow(1).getCell(0);
//            france=sheet1.getRow(2).getCell(0);
//            england=sheet1.getRow(3).getCell(0);
//            turkey=england=sheet1.getRow(4).getCell(0);
//            D.C=sheet1.getRow(1).getCell(1);
//            paris=sheet1.getRow(2).getCell(1);
//            london=sheet1.getRow(3).getCell(1);
//            ankara=sheet1.getRow(4).getCell(1);
            //We this pattern to get countries and capitals
            String countries=sheet1.getRow(rowNumber).getCell(0).toString();
            String capitals=sheet1.getRow(rowNumber).getCell(1).toString();
//            System.out.println("Countries : "+countries);
//            System.out.println("Capitals : "+capitals);
            //Map put function is used to add key value print inside the map
            //It is really important.During the interview,they are gonna ask it.
            //We can use any collection.
            countryCapitals.put(countries,capitals); //Using map
        }
        System.out.println(countryCapitals);//When we print it outside of loop, It is going to print 1 time with all.

    }
}
