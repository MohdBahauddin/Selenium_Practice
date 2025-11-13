package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;
import org.openqa.selenium.JavascriptExecutor;

public class TestCase10 extends BaseTest {
    public static void main(String[] args){
        TestCase10 test = new TestCase10();
        test.runTest();
    }

    public void runTest(){

        setUp();

        HomePage home = new HomePage(driver);
        home.subscriptionEmail("mohdbahauddin123@gmail.com");

        home.getSuccessMessage();
    }
}
