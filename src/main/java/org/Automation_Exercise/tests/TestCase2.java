package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.SignUpOrLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase2 extends BaseTest {
    public static void main(String[] args){
        TestCase2 testCase = new TestCase2();
        testCase.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signup = new SignUpOrLoginPage(driver);
        signup.login("johnvicks58@gmail.com", "JohnCena@123");
        signup.submitLogin();

        home.deleteAccount();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        signup.accountDeleted();
    }
}
