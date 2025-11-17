package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.*;

public class TestCase16 extends BaseTest {
    public static void main(String[] args){
        TestCase16 test = new TestCase16();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signup = new SignUpOrLoginPage(driver);
        signup.login("johnvicks95@test.com","JohnCena@123");
        signup.submitLogin();signup.verifyLogin();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart1();

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
