package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartsPage {
    WebDriver driver;
    JavascriptExecutor js;

    public CartsPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    By cartsMenu = By.xpath("//a[@href='/view_cart']");
    By product1 = By.xpath("//a[text()='Blue Top']");
    By product2 = By.xpath("//a[text()='Men Tshirt']");
    By price1 = By.xpath("//p[text()='Rs. 500']");
    By price2 = By.xpath("//p[text()='Rs. 400']");
    By quantity1 = By.xpath("//button[text()='1']");
    By quantity2 = By.xpath("//button[text()='4']");
    By proceedToCheckoutButton = By.xpath("//a[@class='btn btn-default check_out']");
    By continueToCartButton = By.xpath("//button[text()='Continue On Cart']");
    By registerAndLoginButton = By.xpath("//u[text()='Register / Login']");
    By description = By.xpath("//textarea[@class='form-control']");
    By placeOrderButton = By.xpath("//a[@href='/payment']");

    public void NavigateToCartsPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(cartsMenu).click();
    }

    public void verifyCart(){
        String str1 = driver.findElement(product1).getText();
        String str2 = driver.findElement(product2).getText();

        if((str1.equals("Blue Top") && (str2.equals("Men Tshirt")))){
            System.out.println("Cart is Verified");
        }
        else{
            System.out.println("Cart is not Verified");
        }
    }

    public void verifyPriceAndQuantity() {

        js.executeScript("window.scrollBy(0,200);");

        // Get prices
        String priceProduct1 = driver.findElement(price1).getText();
        String priceProduct2 = driver.findElement(price2).getText();

        // Get all quantities with findElements
        List<WebElement> quantities = driver.findElements(By.xpath("//button[@class='disabled']"));

        String q1 = quantities.get(0).getText();
        String q2 = quantities.get(1).getText();

        // Verify prices
        if (priceProduct1.equals("Rs. 500") && priceProduct2.equals("Rs. 400")) {
            System.out.println("Price verified");
        } else {
            System.out.println("Price NOT verified");
        }

        // Verify quantities
        if (q1.equals("2") && q2.equals("1")) {
            System.out.println("Quantity verified");
        } else {
            System.out.println("Quantity NOT verified");
        }
    }

    public void verifyProductQuantinty(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String str = driver.findElement(quantity2).getText();

        if(str.equals("4")){
            System.out.println("Quantity verified");
        }
        else{
            System.out.println("Quantity is not verified");
        }
    }

    public void proceedToCheckout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(proceedToCheckoutButton).click();
        driver.findElement(registerAndLoginButton).click();
    }

    public void proceedToCheckout1(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(proceedToCheckoutButton).click();
//        driver.findElement(registerAndLoginButton).click();
    }

    public void fillDescription(String fillDescription){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        js.executeScript("window.scrollBy(0,900);");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(description).sendKeys(fillDescription);
        driver.findElement(placeOrderButton).click();
    }



}
