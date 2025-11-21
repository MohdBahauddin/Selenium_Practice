package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By loginLink = By.xpath("//a[@href='/login']");
    By productsLink = By.xpath("//a[@href='/products']");
    By deleteButton = By.xpath("//a[@href='/delete_account']");
    By subscriptioinEmail = By.id("susbscribe_email");
    By subscriptionSubmitButton = By.id("subscribe");
    By successMessage = By.xpath("//div[@class='alert-success' and contains(text(),'You have been successfully subscribed!')]");
    By clickCart = By.xpath("//a[@href='/view_cart']");

    public By getCategoryHeading(String categoryName) {
        return By.xpath("//h2[text()='" + categoryName + "']");
    }

    public By clickCategory(String categoryType){
        return By.xpath("//h4[@class='panel-title']//a[@href='" +categoryType+"']");
    }

    public By subCategory(String subCategoryType){
        return By.xpath("//a[@href='" +subCategoryType +"']");
    }


    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void clickProducts(){
        driver.findElement(productsLink).click();
    }

    public void clickMart(){
        driver.findElement(clickCart).click();
    }

    public void deleteAccount(){
        driver.findElement(deleteButton).click();
    }

    public void subscriptionEmail(String email){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(subscriptioinEmail).sendKeys(email);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(subscriptionSubmitButton).click();
    }

    public void scrollTillLast(){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
    }

    public String getSuccessMessage() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement msg = wait.until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//div[contains(@class,'alert-success')]")
                    )
            );
            return msg.getText();
        } catch (Exception e) {
            return "Message not found!";
        }
    }

    public void clickCategory1(String categoryType1, String subCategoryType1){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        By category = clickCategory(categoryType1);
        By subCategory = subCategory(subCategoryType1);

        js.executeScript("window.scrollBy(0,600);");
        driver.findElement(category).click();
        driver.findElement(subCategory).click();
    }

    public void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void verifyCategory(String expectedCategory, String expectedText) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        By heading = getCategoryHeading(expectedCategory);

        String actualText = driver.findElement(heading).getText();


        if (actualText.equals(expectedText)) {
            System.out.println(actualText);
        } else {
            System.out.println("Category NOT verified");
        }
    }

    public void scrollUp(){
        js.executeScript("window.scrollBy(0,-300);");
    }

    public void addToCart(String productId){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
        By addToCartButton = By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='"+productId+"']");
        driver.findElement(addToCartButton).click();
        driver.findElement(continueShoppingButton).click();
    }

    public void clickRecommendedProduct(String productId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll to recommended items
        WebElement rec = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("recommended-item-carousel"))
        );
        js.executeScript("arguments[0].scrollIntoView(true);", rec);
        js.executeScript("window.scrollBy(0, -180);"); // adjust

        // Product inside carousel
        By prod = By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='" + productId + "']");

        WebElement product = wait.until(
                ExpectedConditions.presenceOfElementLocated(prod)
        );

        // Click via JS (most reliable)
        js.executeScript("arguments[0].click();", product);
    }

    public void clickContinueShopping(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
        driver.findElement(continueShoppingButton).click();
    }

}


