package org.Automation_Exercise.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;


public class SignUpPage {
    WebDriver driver;
    JavascriptExecutor js;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    By name = By.xpath("//input[@data-qa='signup-name']");
    By email = By.xpath("//input[@data-qa='signup-email']");
    By signupButton = By.xpath("//button[@data-qa='signup-button']");
    By gender = By.id("id_gender1");
    By password = By.id("password");
    By days = By.id("days");
    By months = By.id("months");
    By years = By.id("years");
    By newsletter = By.id("newsletter");
    By optin = By.id("optin");
    By firstName = By.id("first_name");
    By lastName = By.id("last_name");
    By company = By.id("company");
    By address1 = By.id("address1");
    By address2 = By.id("address2");
    By state = By.id("state");
    By city = By.id("city");
    By zipcode = By.id("zipcode");
    By phone = By.id("mobile_number");
    By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    public void SignUp(String userName, String userEmail, String userPassword){
        js.executeScript("window.scrollBy(0,200);");
        driver.findElement(name).sendKeys(userName);
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(signupButton).click();

        driver.findElement(gender).click();
        driver.findElement(password).sendKeys(userPassword);

        new Select(driver.findElement(days)).selectByIndex(20);
        new Select(driver.findElement(months)).selectByIndex(8);
        new Select(driver.findElement(years)).selectByIndex(23);

        js.executeScript("window.scrollBy(0,200);");

        driver.findElement(newsletter).click();
        driver.findElement(optin).click();
    }

    public void fillAddress(){
        driver.findElement(firstName).sendKeys("Mohamamd Bahauddin");
        driver.findElement(lastName).sendKeys("Haque");
        driver.findElement(company).sendKeys("Capgemini");
        driver.findElement(address1).sendKeys("Chowk Shahzadpur");
        driver.findElement(address2).sendKeys("Akbarpur");
        driver.findElement(state).sendKeys("Uttar Pradesh");
        driver.findElement(city).sendKeys("AmbedKar Nagar");
        driver.findElement(zipcode).sendKeys("224122");
        driver.findElement(phone).sendKeys("9148987243");
    }

    public void submitForm() {
        driver.findElement(createAccountBtn).click();
    }
}
