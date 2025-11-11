package org.Automation_Exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    By accountCreated = By.xpath("//b[text() = 'Account Created!']");

    public Boolean verifyAccountCreated(){
        String text = driver.findElement(accountCreated).getText();
        return text.equalsIgnoreCase("ACCOUNT CREATED!");
    }
}
