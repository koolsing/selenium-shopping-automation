package shopping.pages;
//these areJUnit, Java and Selenium packages
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShoppingTest
{
   // public static void main(String[] args) {

    //the driver variable created inside setUp() would disappear when setUp() finishes.
    // We solve that by declaring driver at the class level. Now each object can have its own.
    //The variable exists at the class level, so both setUp() and shoppingTest() can use it.
    WebDriver driver;
    WebDriverWait wait;



    // Imagine you have 20 tests. You don't want usernames and passwords scattered throughout your code.
    // Store test data in variables instead of hardcoding values directly inside Selenium actions.
    // This makes the test easier to maintain and allows the same values to be reused.
    String username = "standard_user";
    String password = "secret_sauce";

    //expected arguments for assertion method
    String expectedProduct1 = "Sauce Labs Backpack";
    String expectedProduct2 = "Sauce Labs Bike Light";

    @BeforeEach
    void setup(){
        // Browser setup will go here
        //Create object + assign reference; now driver can access all methods of Chromedriver class
        driver = new ChromeDriver();

        //constructor call of WebDriverWait class in which we pass arguments
        //      -Webdriver object,
        //      - timing in seconds passed to ofSeconds methods in Duration class,
        //      it's a static method so it's called using class(Duration) name.
        //  WebdriverWait object created -> Webdriver object passed, Duration object passed-> this info is passed to WebdriverWait object
        // now we assign the WebDriverWait object to WebDriverWait reference variable
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // @Test tells JUnit that this method is a test case. JUnit Test Runner discovers @Test methods and executes them.
    // No main() method is required because JUnit controls test execution.
    @Test
    public void shoppingTest(){
        //That becomes a problem when the project grows. Imagine 20 tests all knowing the Login button's ID.
        // Change that ID and congratulations, you now have 20 broken tests.
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver, wait);
      //  driver.findElement(By.id("user-name")).sendKeys(username);
       // driver.findElement(By.id("password")).sendKeys(password);

        //      driver.findElement(By.id("login-button")).click();

        // until is a method of WebDriverWait class
        // elementToBeClickable is a method of ExpectedConditions class
        // By is a Selenium class used to create locator objects that tell Selenium how to find an element.
   //     wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button"))).click();

        loginPage.login(username, password);

        ProductPage productPage = new ProductPage(driver,wait);


// - Return type: WebElement — a reference to the located DOM element, on which you can call methods like .sendKeys(), .click(), .getText(), etc.
//  - Parameter: By (package org.openqa.selenium) — a locator strategy like By.id(...), By.xpath(...), By.cssSelector(...).
//  So in driver.findElement(By.id("user-name")), driver is typed as WebDriver, and it inherits findElement from SearchContext.

        productPage.addBackpack();

        productPage.addBikeLight();

        CartPage cartPage = new CartPage(driver,wait);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();


        String product1= wait.until(ExpectedConditions.elementToBeClickable(By.id("item_4_title_link"))).getText();
        System.out.println(product1);

        String product2= wait.until(ExpectedConditions.elementToBeClickable(By.id("item_0_title_link"))).getText();
        System.out.println(product2);

Assertions.assertEquals(expectedProduct1, product1, "Backpack product name does not match"); // message if it fails
Assertions.assertEquals(expectedProduct2, product2, "Bike Light product name does not match");
    }

    @AfterEach
    void teardown(){
        driver.quit();
    }
}
