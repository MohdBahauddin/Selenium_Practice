package org.Automation_Exercise;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestCase_8 {
    public  static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://automationexercise.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement products = driver.findElement(By.xpath("//a[@href='/products']"));
        products.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        WebElement allProducts = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        String str = allProducts.getText();
        System.out.println(str);

        if(str.equals("ALL PRODUCTS")){
            System.out.println("We are at All Products Page.");
        }
        else{
            System.out.println("We are not at All Products Page");
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600);");

        WebElement viewProduct = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
        viewProduct.click();

        WebElement newArrival = driver.findElement(By.xpath("//img[@class='newarrival']"));
        newArrival.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement category = driver.findElement(By.xpath("//p[text()='Category: Women > Tops']"));
        String str1 = category.getText();

        if(str1.equals("Category: Women > Tops")){
            System.out.println("Category is Visible.");
        }
        else{
            System.out.println("Category is not visible.");
        }

        WebElement price = driver.findElement(By.xpath("//span[text()='Rs. 500']"));
        String str2 = price.getText();

        if(str2.equals("Rs. 500")){
            System.out.println("Price is visible.");
        }
        else{
            System.out.println("Price is not visible.");
        }

        WebElement availability = driver.findElement(By.xpath("//b[text()='Availability:']"));
        String str3 = availability.getText();

        if(str3.equals("Availability:")){
            System.out.println("Availability is visible.");
        }
        else{
            System.out.println("Availability is not visible.");
        }

        WebElement condition = driver.findElement(By.xpath("//b[text()='Condition:']"));
        String str4 = condition.getText();

        if(str4.equals("Condition:")){
            System.out.println("Condition is visible.");
        }
        else{
            System.out.println("Condition is not visible.");
        }

        WebElement brand = driver.findElement(By.xpath("//b[text()='Brand:']"));
        String str5 = brand.getText();

        if(str5.equals("Brand:")){
            System.out.println("Brand is visible.");
        }
        else{
            System.out.println("Brand is not visible.");
        }

    }
}
