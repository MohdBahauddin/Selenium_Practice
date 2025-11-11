package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.LoginPage;

public class TestCase2 extends BaseTest {
    public static void main(String[] args){
        TestCase1 testCase = new TestCase1();
        testCase.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        LoginPage login = new LoginPage(driver);
        login.login("mohdbahauddin123@gmail.com", "Phenomenal$123");
        login.submitLogin();
    }
}
