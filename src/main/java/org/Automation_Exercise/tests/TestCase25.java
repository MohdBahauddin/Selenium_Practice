package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;

public class TestCase25 extends BaseTest {
    public static void main(String[] args){
        TestCase25 test = new TestCase25();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.scrollToBottom();
        home.verifySubscription();
        home.clickArrow();
        home.verifyAutomationEngineersText();
    }
}
