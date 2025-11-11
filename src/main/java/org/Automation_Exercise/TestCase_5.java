package org.Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestCase_5 {
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

        WebElement errorMessage = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));
        String message = errorMessage.getText();

        if(message.equals("Email Address already exist!"))
        {
            System.out.println("Email Address already exist!");
        }
        else{
            System.out.println("Login successful");
        }

    }
}
