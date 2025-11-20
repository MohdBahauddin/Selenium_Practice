package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.CartsPage;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;
import org.Automation_Exercise.pages.SignUpOrLoginPage;

public class TestCase20 extends BaseTest {
    public static void main(String[] args){
        TestCase20 test = new TestCase20();
        test.runTest();
    }
    public void runTest(){
        setUp();

        ProductsPage product = new ProductsPage(driver);
        product.navigateToProductsPage();
        product.verifyProductsPage();
        product.searchProduct("Tshirt");
        product.addToCart2("1","2");
        product.addToCart2("2","28");
        product.addToCart2("3","29");
        product.scrollPage1();
        product.addToCart2("4","30");
        product.addToCart2("5","31");
        product.addToCart2("6","43");

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        product.scrollPage1();
        cart.verifyProducts("2");
        cart.verifyProducts("28");
        cart.verifyProducts("29");
        product.scrollPage1();
        cart.verifyProducts("30");
        cart.verifyProducts("31");
        cart.verifyProducts("43");

        HomePage home = new HomePage(driver);
        home.clickLogin();

        SignUpOrLoginPage signup = new SignUpOrLoginPage(driver);
        signup.login("johnvicks58@gmail.com", "JohnCena@123");
        signup.submitLogin();
        signup.verifyLogin();

        cart.NavigateToCartsPage();
        cart.verifyProducts("2");
        cart.verifyProducts("28");
        cart.verifyProducts("29");
        product.scrollPage1();
        cart.verifyProducts("30");
        cart.verifyProducts("31");
        cart.verifyProducts("43");



    }
}
