package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.CartsPage;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;
import org.Automation_Exercise.pages.SignUpOrLoginPage;

public class TestCase17 extends BaseTest {
    public static void main(String[] args){
        TestCase17 test = new TestCase17();
        test.runTest();
    }

    public void runTest(){
        setUp();

        ProductsPage product = new ProductsPage(driver);
        product.addToCart1();

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.deleteProductFromCart();
        cart.verifyProductRemovedFromCart();
    }
}
