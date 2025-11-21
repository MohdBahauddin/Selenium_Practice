package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class PaymentsPage {
    protected WebDriver driver;
    JavascriptExecutor js;

    public PaymentsPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    By nameOnCard = By.xpath("//input[@data-qa='name-on-card']");
    By cardNumber = By.xpath("//input[@data-qa='card-number']");
    By cvc = By.xpath("//input[@data-qa='cvc']");
    By expiryMonth = By.xpath("//input[@data-qa='expiry-month']");
    By expiryYear = By.xpath("//input[@data-qa='expiry-year']");
    By payButton = By.xpath("//button[@data-qa='pay-button']");
    By paymentMessage = By.xpath("//div[@id='success_message']");
    By downloadInvoiceButton = By.xpath("//a[@href='/download_invoice/500']");
    By continuewButton = By.xpath("//a[@data-qa='continue-button']");

    public void fillPaymentDetails(String name, String number, String CVC, String expiration, String year){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(nameOnCard).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        driver.findElement(cvc).sendKeys(CVC);
        driver.findElement(expiryMonth).sendKeys(expiration);
        driver.findElement(expiryYear).sendKeys(year);
        js.executeScript("window.scrollBy(0,400);");
    }

    public void verifyPaymentStatus(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        String str = driver.findElement(paymentMessage).getText();
        System.out.println(str);
    }

    public void clickPaymentButton(){
        driver.findElement(payButton).click();
    }

    public void downloadInvoice(){
        driver.findElement(downloadInvoiceButton).click();
        driver.findElement(continuewButton).click();
    }
}
