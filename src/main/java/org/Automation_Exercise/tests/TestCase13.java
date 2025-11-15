package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.CartsPage;
import org.Automation_Exercise.pages.ProductsPage;

public class TestCase13 extends BaseTest {
    public static void main(String[] args){
        TestCase13 test = new TestCase13();
        test.runTest();
    }

    public void runTest(){
        setUp();

        ProductsPage product = new ProductsPage(driver);
        product.navigateToProductsPage();
        product.viewProduct();
        product.verifyProductdetailsPage();
        product.increaseQuantity();

        CartsPage cart = new CartsPage(driver);
        cart.NavigateToCartsPage();
        cart.verifyProductQuantinty();

    }
}
