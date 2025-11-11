package org.Automation_Exercise;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_6 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement automationExercise = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));

        if(automationExercise.isDisplayed()){
            System.out.println("We are at Home Page");
        }
        else{
            System.out.println("We are not at Home page");
        }

        WebElement contactUS = driver.findElement(By.xpath("//a[@href='/contact_us']"));
        contactUS.click();

        WebElement getInTouch = driver.findElement(By.xpath("//h2[text()='Get In Touch']"));
        String str1 = getInTouch.getText();
        System.out.println(getInTouch);

        if(str1.equals("Get In Touch")){
            System.out.println("We are at Contact Us Page");
        }
        else{
            System.out.println("We are not at Contact Us Page");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200);");

        WebElement fillName = driver.findElement(By.xpath("//input[@data-qa='name']"));
        fillName.sendKeys("Mohammad Bahauddin Haque");

        WebElement fillEmail = driver.findElement(By.xpath("//input[@data-qa='email']"));
        fillEmail.sendKeys("mohdbahauddin123@gmail.com");

        WebElement fillSubject = driver.findElement(By.xpath("//input[@data-qa='subject']"));
        fillSubject.sendKeys("I want new High Paying Job");

        WebElement fillMessage = driver.findElement(By.xpath("//textarea[@data-qa='message']"));
        fillMessage.sendKeys("I am learning Automation testing to login better job with roles like SDET or DEVOPS and also with better pay");

//        js.executeScript("window.scrollBy(0,100);");

        WebElement uploadFile = driver.findElement(By.xpath("//input[@type='file']"));
        uploadFile.sendKeys("C:\\Users\\ASUS\\OneDrive\\Desktop\\SDE_Template_Sharath.pdf");

        WebElement submitButton = driver.findElement(By.xpath("//input[@type='submit']"));
        submitButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='status alert alert-success']"));
        String str2 = successMessage.getText();

        if(str2.equals("Success! Your details have been submitted successfully.")){
            System.out.println("Details submitted successfully");
        }
        else{
            System.out.println("Details submission failed");
        }

        WebElement successButton = driver.findElement(By.xpath("//a[@class='btn btn-success']"));
        successButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement automationExerciseImage = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        if(automationExerciseImage.isDisplayed()){
            System.out.println("Successfully landed to Home Page");
        }
        else{
            System.out.println("We are not at Home page");
        }

    }
}
