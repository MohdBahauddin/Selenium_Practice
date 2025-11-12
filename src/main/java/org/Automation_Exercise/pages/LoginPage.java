package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class LoginPage {
    WebDriver driver;
    JavascriptExecutor js;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    By email = By.xpath("//input[@data-qa='login-email']");
    By password = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");

    public void login(String userEmail, String userPassword){
        driver.findElement(email).sendKeys("mohdbahauddin123@gmail.com");
        driver.findElement(password).sendKeys("Phenomenal$123");
    }

    public void submitLogin(){
        driver.findElement(loginButton).click();
    }
}
