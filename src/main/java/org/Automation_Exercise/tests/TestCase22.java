package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.CartsPage;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;

public class TestCase22 extends BaseTest{
    public  static void main(String[] args){
        TestCase22 test = new TestCase22();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.scrollToBottom();
        home.scrollUp();
//        home.addToCart("1");
//        home.addToCart("2");
//        home.addToCart("3");
//        home.addToCart("4");
//        home.addToCart("5");
//        home.addToCart("6");

        home.clickRecommendedProduct("1");
        home.clickContinueShopping();
        home.clickRecommendedProduct("2");
        home.clickContinueShopping();
        home.clickRecommendedProduct("3");
        home.clickContinueShopping();
        home.clickRecommendedProduct("4");
        home.clickContinueShopping();
        home.clickRecommendedProduct("5");
        home.clickContinueShopping();
        home.clickRecommendedProduct("6");
        home.clickContinueShopping();

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.verifyProducts("1");
        cart.verifyProducts("2");
        cart.verifyProducts("3");

        ProductsPage product = new ProductsPage(driver);
        product.scrollPage1();

        cart.verifyProducts("4");
        cart.verifyProducts("5");
        cart.verifyProducts("6");
    }
}
