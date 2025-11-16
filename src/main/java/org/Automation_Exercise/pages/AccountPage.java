package org.Automation_Exercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    By accountCreated = By.xpath("//b[text() = 'Account Created!']");
    By signUpName = By.xpath("//input[@data-qa='signup-name']");
    By signUpEmail = By.xpath("//input[@data-qa='signup-email']");
    By signUpButton = By.xpath("//button[@data-qa='signup-button']");
    By gender = By.id("id_gender1");
    By fillPassword = By.id("password");

    public Boolean verifyAccountCreated(){
        String text = driver.findElement(accountCreated).getText();
        return text.equalsIgnoreCase("ACCOUNT CREATED!");
    }

    public void signUp(String name, String email){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(signUpName).sendKeys(name);
        driver.findElement(signUpEmail).sendKeys(email);
        driver.findElement(signUpButton).click();
    }

    public void fillDetails(String password, String firstName, String lastName, String Company){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(gender).click();
        driver.findElement(fillPassword).sendKeys(password);

    }
}
