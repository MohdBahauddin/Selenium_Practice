package org.Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_3 {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement loginBtn = driver.findElement(By.xpath("//a[@href='/login']"));
        loginBtn.click();

        WebElement loginPage = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        String str = loginPage.getText();

        if(str.equals("Login to your account")){
            System.out.println("We are at login Page");
        }
        else{
            System.out.println("We are not at login page");
        }

        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 200 pixels
        js.executeScript("window.scrollBy(0, 200);");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginEmail.click();
        loginEmail.sendKeys("mohdbahauddin12@gmail.com");

        loginPassword.click();
        loginPassword.sendKeys("Phenomenal$3");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        loginButton.click();

        WebElement loginFailed = driver.findElement(By.xpath("//p[text()='Your email or password is incorrect!']"));
        String str1 = loginFailed.getText();

        if(str1.equals("Your email or password is incorrect!")){
            System.out.println("Login Failed");
        }
        else{
            System.out.println("Login successfull");
        }
    }

}
