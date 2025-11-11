package org.Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_7 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement testCases = driver.findElement(By.xpath("//a[@href='/test_cases']"));
        testCases.click();

        WebElement testCaseText = driver.findElement(By.xpath("//b[text()='Test Cases']"));
        String str = testCaseText.getText();
        System.out.println(str);

        if(str.equals("TEST CASES")){
            System.out.println("We are at test cases Page.");
        }
        else{
            System.out.println("We are not at test cases Page.");
        }

    }
}
