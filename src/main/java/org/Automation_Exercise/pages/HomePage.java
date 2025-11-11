package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By loginLink = By.xpath("//a[@href='/login']");

    public void clickLogin(){
        driver.findElement(loginLink).click();
    }

    public void deleteAccount(){
        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        deleteAccount.click();
    }
}
