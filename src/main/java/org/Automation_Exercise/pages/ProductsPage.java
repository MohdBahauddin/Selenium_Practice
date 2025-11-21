package org.Automation_Exercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    protected WebDriver driver;
    protected Actions actions;
    JavascriptExecutor js;

    public ProductsPage(WebDriver driver){
        this.driver = driver;
        this.actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    By ProductsMenu = By.xpath("//a[@href='/products']");
    By allProducts = By.xpath("//h2[text()='All Products']");
    By searchProducts = By.id("search_product");
    By searchButton = By.id("submit_search");
    By product = By.xpath("//div[@class='product-overlay']");
//    By addToCartButton = By.xpath("//div[@class='product-overlay']//a[@data-product-id='1']");
//    By addToCartButton1 = By.xpath("//div[@class='product-overlay']//a[@data-product-id='2']");
    By continueShoppingButton = By.xpath("//button[@class='btn btn-success close-modal btn-block']");
    By viewProductsButton = By.xpath("//a[@href='/product_details/1']");
    By productQuantity = By.id("quantity");
    By addToCartButton2 = By.xpath("//button[@type='button']");
    By brands = By.xpath("//h2[text()='Brands']");
    By polo = By.xpath("//a[@href='/brand_products/Polo']");
    By userName = By.id("name");
    By userEmail = By.id("email");
    By review = By.id("review");
    By submit = By.id("button-review");

    public By getBrandName(String brand){
        return By.xpath("//a[@href='/brand_products/"+brand+"']");
    }
    public By addToCartButton(String i){
        return By.xpath("//div[@class='product-overlay']//a[@data-product-id='"+i+"']");
    }

    public void scrollPage(){
        js.executeScript("window.scrollBy(0,200);");
    }

    public void scrollPage1(){
        js.executeScript("window.scrollBy(0,600);");
    }


    public void navigateToProductsPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(ProductsMenu).click();
    }

    public Boolean verifyProductsPage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        js.executeScript("window.scrollBy(0,200);");
        String text = driver.findElement(allProducts).getText();
        return text.equalsIgnoreCase("ALL PRODUCTS");
    }

    public void searchProduct(String productName){
        driver.findElement(searchProducts).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public Boolean verifyProductIsVisible(){
        js.executeScript("window.scrollBy(0,500);");
        return driver.findElement(product).isDisplayed();
    }

    public void addToCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        js.executeScript("window.scrollBy(0,600);");

        // ************** 1st Product **************
        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-image-wrapper'])[1]")));

        actions.moveToElement(product1).perform();

        WebElement add1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='product-overlay']//a[@data-product-id='1'])")));

        add1.click();

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Continue Shopping']")));
        continueBtn.click();

        // ************** 2nd Product **************
        WebElement product2 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-image-wrapper'])[2]")));

        js.executeScript("arguments[0].scrollIntoView(true);", product2);
        actions.moveToElement(product2).perform();

        WebElement add2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='product-overlay']//a[@data-product-id='2'])")));

        add2.click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Continue Shopping']"))).click();
    }

    public void addToCart1() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        js.executeScript("window.scrollBy(0,600);");

        // ************** 1st Product **************
        WebElement product1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//div[@class='product-image-wrapper'])[1]")));

        actions.moveToElement(product1).perform();

        WebElement add1 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("(//div[@class='product-overlay']//a[@data-product-id='1'])")));

        add1.click();

        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Continue Shopping']")));
        continueBtn.click();
    }


public void addToCart2(String index, String productId) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));

    // Locate product card safely
    By productCard = By.xpath("(//div[@class='product-image-wrapper'])[" + index + "]");
    WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(productCard));

    // Scroll into view properly
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", product);

    // Hover
    actions.moveToElement(product).pause(Duration.ofMillis(300)).perform();

    // Overlay button that appears after hover
    By addToCartBtn = By.xpath("//a[@data-product-id='" + productId + "']");

    // Wait specifically for visible AND clickable
    WebElement addButton = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtn));
    wait.until(ExpectedConditions.elementToBeClickable(addButton));

    // Click reliably using JS (this site is glitchy)
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);

    // Continue Shopping
    WebElement continueBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Continue Shopping']"))
    );
    continueBtn.click();
}



    public void viewProduct(){
       js.executeScript("window.scrollBy(0,600);");
       driver.findElement(viewProductsButton).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
       String str = driver.getTitle();
       System.out.println(str);

    }

    public void verifyProductdetailsPage(){
        String str = driver.getTitle();
        if(str.equals("Automation Exercise - Product Details")){
            System.out.println("We are at products details page");
        }
        else{
            System.out.println("We are not at products details page");
        }
    }

    public void increaseQuantity(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(productQuantity).clear();
        driver.findElement(productQuantity).sendKeys("4");
        driver.findElement(addToCartButton2).click();
        driver.findElement(continueShoppingButton).click();
    }

    public void verifyBrand(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        js.executeScript("window.scrollBy(0,600);");
        String str = driver.findElement(brands).getText();
        System.out.println(str);
        if(str.equals("BRANDS")){
            System.out.println("Brand page is verified");
        }
        else{
            System.out.println("Brand page is not verified");
        }
    }

    public void clickBrand(String brandName){
//        driver.findElement(polo).click();
        By brand = getBrandName(brandName);
        driver.findElement(brand).click();
    }


    public void verifyBrandPage(String brand){
        String str = driver.getTitle();
        if(str.equals("Automation Exercise - "+brand+" Products")){
            System.out.println("Brand page is verified for " + brand);
        }
        else{
            System.out.println("Brand page is not verified " + brand);
        }
    }

    public void writeReview(String name, String emailAddress){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        js.executeScript("window.scrollBy(0,600);");
        driver.findElement(userName).sendKeys(name);
        driver.findElement(userEmail).sendKeys(emailAddress);
        driver.findElement(review).sendKeys("Good Product");
        driver.findElement(submit).click();
    }

    public void verifyReviewSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        By messageLocator = By.cssSelector(".alert-success");
        // You can replace with exact locator if needed

        WebElement msgElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(messageLocator)
        );

        // Read text quickly before it disappears
        String actualMessage = msgElement.getText().trim();

        if (actualMessage.contains("Thank you for your review.")) {
            System.out.println("Success message verified!");
        } else {
            throw new AssertionError("Success message NOT found. Actual: " + actualMessage);
        }
    }

}
