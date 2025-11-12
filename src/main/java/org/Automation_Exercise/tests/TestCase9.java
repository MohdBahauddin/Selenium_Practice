package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.TestCase_4;
import org.Automation_Exercise.pages.HomePage;
import org.Automation_Exercise.pages.ProductsPage;

public class TestCase9 extends BaseTest {
    public static void main(String[] args){
        TestCase9 test = new TestCase9();
        test.runTest();
    }
    
    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickProducts();

        ProductsPage products = new ProductsPage(driver);
        products.verifyProductsPage();
        products.searchProduct("Men Tshirt");
        products.verifyProductIsVisible();
    }
    
}
