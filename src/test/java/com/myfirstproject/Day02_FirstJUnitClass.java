package com.myfirstproject;
import org.junit.*;

public class Day02_FirstJUnitClass {
    /*
    * JUnit is one of the oldest JAVA TESTING framework
    * Developers also use JUnit for their UNIT Testing
    * UNIT: small part of the application
    * TESTER also use UNIT testing for their UNIT TESTING
    * JUNIT has 7 major annotation
    *   1.@Test annotation is used to create test cases
    *     No more main method
    *     NOTE: All test method will be "void".Because test method are used for assertions.
    *   2.@Before: Runs before each @Test annotation
    *   3.@After :Runs after each class @Test annotation
    *   4.BeforeClass: Runs only once before each class
    *   5.AfterClass: Runs only once after each class
    *   6.@Ignore: To skip a test case
    * */

    /*
    --------------JUNIT ASSERTION:
    We use JUnit assertion if actual and expected is equal
    Instead of using if else statement, we will use JUnit assertions
    It will come from Assert class
    1. Assert.assertEquals("ACTUAL","EXPECTED");
    2. Assert.assertTrue("ACTUAL".contains("EXPECTED"));
    3. Assert.assertFalse("ACTUAL".contains("EXPECTED"));
     */
    @Before // This is "Support Method". Eklenilen method sayisi kadar run edilir.
    public void setup(){
        System.out.println("This is Before method.");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }
    @After
    public void tearDown(){// "tearDown" mean close everything
        System.out.println("This is TEAR DOWN");
    }
    //ASSERTION:
    //if expected == actual
    @Test
    public void assertions(){
        //1.Assert.assertEquals("expected"," actual");
        //If assertion fails, then we see error message on the console.
        //If assertion pass, then we see a green checkmark only
        Assert.assertEquals("java","java");

        //2.Assert.assertTrue(BOOLEAN);
        Assert.assertTrue("Selenium".contains("e")); // We can add if/ else clause as well.

        //3.Assert.assertFalse(BOOLEAN);
        Assert.assertFalse("Selenium".contains("a")); //"Selenium".contains("a") ->FALSE

        //We can add a message as well.
       //This message will ONLY DISPLAY WHEN ASSERTION FAILS!!!!
        Assert.assertEquals("ASSERTION FAILED!","java","java");

    }
}

