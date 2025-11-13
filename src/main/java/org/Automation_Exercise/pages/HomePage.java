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


    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void clickProducts(){
        driver.findElement(productsLink).click();
    }

    public void deleteAccount(){
        driver.findElement(deleteButton).click();
    }

    public void subscriptionEmail(String email){
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        driver.findElement(subscriptioinEmail).sendKeys(email);
        driver.findElement(subscriptionSubmitButton).click();
    }

    public String getSuccessMessage() {
        try {
            // Wait with short polling because message appears briefly
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            shortWait.pollingEvery(Duration.ofMillis(100));
            WebElement msg = shortWait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return msg.getText();
        } catch (Exception e) {
            return "Message not found!";
        }
    }
}


