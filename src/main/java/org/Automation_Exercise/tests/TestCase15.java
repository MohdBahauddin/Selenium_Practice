package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.*;

public class TestCase15 extends BaseTest {
    public static void main(String[] args){
        TestCase15 test = new TestCase15();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signUp = new SignUpOrLoginPage(driver);
        signUp.SignUp("John Wick", "johnvicks95@test.com", "JohnCena@123");
        signUp.fillAddress();
        signUp.submitForm();
        signUp.clickContinue();
        signUp.verifyLogin();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart2("1","1");

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.proceedToCheckout1();
        cart.fillDescription("This is a test product");


        PaymentsPage pay = new PaymentsPage(driver);
        pay.fillPaymentDetails("John Wick", "1234567890123458", "123", "12","32");
        pay.verifyPaymentStatus();
        pay.clickPaymentButton();

        home.deleteAccount();
    }
}
