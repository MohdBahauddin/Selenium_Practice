package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_1 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement loginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
        loginBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 200 pixels
        js.executeScript("window.scrollBy(0, 200);");

        WebElement signupName = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        signupName.click();
        signupName.sendKeys("Mohammad Bahauddin Haque");

        WebElement signupEmail = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        signupEmail.click();
        signupEmail.sendKeys("mohdbahauddin123@gmail.com");

        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='signup-button']"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        WebElement genderBtn = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        genderBtn.click();
        // Scroll down by 200 pixels
        js.executeScript("window.scrollBy(0, 300);");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement days = driver.findElement(By.id("days"));
        WebElement month = driver.findElement(By.id("months"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        password.click();
        password.sendKeys("Phenomenal$123");

        Select select = new Select(days);
        select.selectByIndex(20);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        Select select1 = new Select(month);
        select1.selectByIndex(8);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement yearDropdown = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("years"))
        );

        Select select2 = new Select(yearDropdown);
        select2.selectByIndex(23);

        js.executeScript("window.scrollBy(0, 200);");
        WebElement newsLetter = driver.findElement(By.id("newsletter"));
        newsLetter.click();

        WebElement offers = driver.findElement(By.id("optin"));
        offers.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        js.executeScript("window.scrollBy(0, 300);");

        WebElement  firstName = driver.findElement(By.id("first_name"));
        firstName.sendKeys("Mohammad Bahauddin");

        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.sendKeys("Haque");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("Capgemini");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        js.executeScript("window.scrollBy(0, 200);");

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Chowk Shahzadpur");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Akbarpur");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Uttar Pradesh");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys(("AmbedKar Nagar"));

        WebElement zipCode = driver.findElement(By.id("zipcode"));
        zipCode.sendKeys("224122");

        WebElement phoneNumber = driver.findElement(By.id("mobile_number"));
        phoneNumber.sendKeys("9148987243");

        WebElement submitButton = driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        submitButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement accountCreated = driver.findElement(By.xpath("//b[text() = 'Account Created!']"));

        String textToVerify = accountCreated.getText();
        if(textToVerify.equals("Account Created!"))
        {
            System.out.println("Account Created Succesfully");
        }
        else
        {
            System.out.println("Account Creation Failed");
        }
    }
}
