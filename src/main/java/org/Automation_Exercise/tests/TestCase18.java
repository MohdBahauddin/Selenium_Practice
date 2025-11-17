package org.Automation_Exercise.tests;

import org.Automation_Exercise.BaseTest.BaseTest;
import org.Automation_Exercise.pages.HomePage;

public class TestCase18 extends BaseTest {
    public static void main(String[] args){
        TestCase18 test = new TestCase18();
        test.runTest();
    }

    public void runTest(){
        setUp();

        HomePage home = new HomePage(driver);
        home.clickCategory1("#Women","/category_products/1");
        home.verifyCategory("Women - Dress Products","WOMEN - DRESS PRODUCTS");
        home.clickCategory1("#Men","/category_products/3");
        home.verifyCategory("Men - Tshirts Products","MEN - TSHIRTS PRODUCTS");
    }
}
