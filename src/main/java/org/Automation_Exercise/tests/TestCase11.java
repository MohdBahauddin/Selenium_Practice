package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;

public class TestCase11 extends BaseTest {
    public static void main(String[] args){
        TestCase11 test = new TestCase11();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickMart();
        home.scrollTillLast();
        home.subscriptionEmail("mohdbahauddin123@gmail");
        home.getSuccessMessage();
    }
}
