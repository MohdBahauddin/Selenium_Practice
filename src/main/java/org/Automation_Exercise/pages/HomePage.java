package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By loginLink = By.xpath("//a[@href='/login']");
    By productsLink = By.xpath("//a[@href='/products']");
    By deleteButton = By.xpath("//a[@href='/delete_account']");

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void clickProducts(){
        driver.findElement(productsLink).click();
    }

    public void deleteAccount(){
        driver.findElement(deleteButton).click();
    }
}
