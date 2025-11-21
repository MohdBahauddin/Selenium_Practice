package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;

public class TestCase21 extends BaseTest {
    public static void main(String[] args){
        TestCase21 test = new TestCase21();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage product = new ProductsPage(driver);
        product.verifyProductsPage();
        product.viewProduct();

        product.writeReview("John Wick", "johnvicks@gmail.com");
        product.verifyReviewSuccessMessage();
    }
}
