package org.Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase_2 {
    public static void main(String[] args) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationexercise.com");
        Thread.sleep(2000);

        WebElement loginBtn = driver.findElement(By.xpath("//a[@href='/login']"));

        loginBtn.click();

        WebElement loginEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        WebElement loginPassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 200 pixels
        js.executeScript("window.scrollBy(0, 200);");

        Thread.sleep(2000);
        loginEmail.click();
        loginEmail.sendKeys("mohdbahauddin123@gmail.com");

        loginPassword.click();
        loginPassword.sendKeys("Phenomenal$123");

        Thread.sleep(2000);
        loginButton.click();

        WebElement name = driver.findElement(By.xpath("//b[text()='Mohammad Bahauddin Haque']"));

        String NameVerify = name.getText();
        System.out.println(NameVerify);

        if(NameVerify.equals("Mohammad Bahauddin Haque")){
            System.out.println("Name Verified");
        }
        else{
            System.out.println("Name not Verified");
        }

        WebElement deleteAccount = driver.findElement(By.xpath("//a[@href='/delete_account']"));

        Thread.sleep(2000);
        deleteAccount.click();

        Thread.sleep(2000);
        WebElement accountDeleted = driver.findElement(By.xpath("//b[text()='Account Deleted!']"));

        String accountDeletedVerification = accountDeleted.getText();

        if(accountDeletedVerification.equals("ACCOUNT DELETED!"))
        {
            System.out.println("Account Deleted Successfully");
        }
        else{
            System.out.println("Account Deletion Failed");
        }
    }
}
