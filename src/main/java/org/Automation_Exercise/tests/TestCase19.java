package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;

public class TestCase19 extends BaseTest {
        public static void main(String[] args){
            TestCase19 test = new TestCase19();
            test.runTest();
    }
    public void runTest(){
            setUp();

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage product = new ProductsPage(driver);
        product.verifyBrand();
    }
}
