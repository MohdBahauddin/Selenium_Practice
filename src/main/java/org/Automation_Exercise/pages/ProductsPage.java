package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class ProductsPage {
    protected WebDriver driver;
    JavascriptExecutor js;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    By allProducts = By.xpath("//h2[text()='All Products']");
    By searchProducts = By.id("search_product");
    By searchButton = By.id("submit_search");
    By product = By.xpath("//div[@class='product-overlay']");

    public Boolean verifyProductsPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        js.executeScript("window.scrollBy(0,200);");
        String text = driver.findElement(allProducts).getText();
        return text.equalsIgnoreCase("ALL PRODUCTS");
    }

    public void searchProduct(String productName){
        driver.findElement(searchProducts).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public Boolean verifyProductIsVisible(){
        js.executeScript("window.scrollBy(0,50 0);");
        return driver.findElement(product).isDisplayed();
    }


}
