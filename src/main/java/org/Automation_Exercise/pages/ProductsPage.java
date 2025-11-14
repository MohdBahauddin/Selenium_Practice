package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    protected WebDriver driver;
    protected Actions actions;
    JavascriptExecutor js;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    By ProductsMenu = By.xpath("//a[@href='/products']");
    By allProducts = By.xpath("//h2[text()='All Products']");
    By searchProducts = By.id("search_product");
    By searchButton = By.id("submit_search");
    By product = By.xpath("//div[@class='product-overlay']");
    By addToCartButton = By.xpath("//div[@class='product-overlay']//a[@data-product-id='1']");
    By addToCartButton1 = By.xpath("//div[@class='product-overlay']//a[@data-product-id='2']");
    By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");

    public void navigateToProductsPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(ProductsMenu).click();
    }

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

    public void addToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        js.executeScript("window.scrollBy(0,600);");

        // 1st Product
        WebElement image1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-image-wrapper'])[1]")));
        actions.moveToElement(image1).perform();

        // Wait until button is clickable (no overlay)
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();

        // 2nd Product
        WebElement image2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-image-wrapper'])[2]")));

        js.executeScript("arguments[0].scrollIntoView(true);", image2);
        actions.moveToElement(image2).perform();

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton1)).click();
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }



}
