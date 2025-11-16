package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.*;

public class TestCase14 extends BaseTest {
    public static void main(String[] args){
        TestCase14 test = new TestCase14();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart1();

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.proceedToCheckout();

        SignUpOrLoginPage sigup = new SignUpOrLoginPage(driver);
        sigup.SignUp("John Wick", "johnvicks58@gmail.com", "JohnCena@123");
        sigup.fillAddress();
        sigup.submitForm();
        sigup.clickContinue();
        sigup.verifyLogin();

        cart.NavigateToCartsPage();
        cart.proceedToCheckout1();
        cart.fillDescription("I love these products");

        PaymentsPage pay = new PaymentsPage(driver);
        pay.fillPaymentDetails("John Wick", "1234567890123458", "123", "12","32");
        pay.verifyPaymentStatus();
        pay.clickPaymentButton();

        home.deleteAccount();
    }
}
