package org.Automation_Exercise.tests;

import org.Automation_Exercise.pages.AccountPage;
import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;

public class TestCase1 extends BaseTest {

    public static void main(String[] args){
        TestCase1 test = new TestCase1();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        signup.SignUp("Mohammad Bahauddin Haque", "mohdbahauddin123@gmail.com", "Phenomenal$123");
        signup.fillAddress();
        signup.submitForm();

        AccountPage account = new AccountPage(driver);
        if (account.verifyAccountCreated()) {
            System.out.println("✅ Account Created Successfully");
        } else {
            System.out.println("❌ Account Creation Failed");
        }

        tearDown();

    }
}
