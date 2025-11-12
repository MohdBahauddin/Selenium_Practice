package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By loginLink = By.xpath("//a[@href='/login']");

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }
}
