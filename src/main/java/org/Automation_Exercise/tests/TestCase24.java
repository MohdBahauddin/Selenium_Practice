package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.*;

public class TestCase24 extends BaseTest {
    public static void main(String[] args){
        TestCase24 test = new TestCase24();
        test.runTest();
    }

    public void runTest(){
        setUp();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart2("1","1");

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
//        cart.proceedToCheckout1();

        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signup = new SignUpOrLoginPage(driver);
        signup.SignUp("John Wick","jognsick123@gmail.com","SickJohn@123");
        signup.fillAddress();
        signup.submitForm();
        signup.clickContinue();
        signup.verifyLogin();

        cart.NavigateToCartsPage();
        cart.proceedToCheckout1();
        cart.fillDescription("This is a description");

        PaymentsPage payments = new PaymentsPage(driver);
        payments.fillPaymentDetails("John Wick","1234567890123489","123","12","2030");
        payments.clickPaymentButton();
        payments.downloadInvoice();

        home.deleteAccount();
    }
}
