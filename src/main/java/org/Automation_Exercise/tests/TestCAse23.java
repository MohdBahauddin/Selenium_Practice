package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.CartsPage;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;
import org.Automation_Exercise.pages.SignUpOrLoginPage;

public class TestCase23 extends BaseTest {
    public static void main(String[] args){
        TestCase23 test = new TestCase23();
        test.runTest();
    }

    public void runTest(){
        setUp();
        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signup = new SignUpOrLoginPage(driver);
        signup.SignUp("John Wick","jognsick123@gmail.com","SickJohn@123");
        signup.fillAddress();
        signup.submitForm();
        signup.clickContinue();
        signup.verifyLogin();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart2("1","1");

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.proceedToCheckout1();

        home.deleteAccount();

    }
}
