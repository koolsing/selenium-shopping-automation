import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ShoppingTest
{
   // public static void main(String[] args) {

    //the driver variable created inside setUp() would disappear when setUp() finishes.
    // We solve that by declaring driver at the class level. Now each object can have its own.
    //The variable exists at the class level, so both setUp() and shoppingTest() can use it.
    WebDriver driver;

    // Imagine you have 20 tests. You don't want usernames and passwords scattered throughout your code.
    // Store test data in variables instead of hardcoding values directly inside Selenium actions.
    // This makes the test easier to maintain and allows the same values to be reused.
    String username = "standard_user";
    String password = "secret_sauce";

    @BeforeEach
    void setup(){
        // Browser setup will go here
        //Create object + assign reference; now driver can access all methods of Chromedriver class
        driver = new ChromeDriver(); //
    }

    @Test
    // @Test tells JUnit that this method is a test case. JUnit Test Runner discovers @Test methods and executes them.
    // No main() method is required because JUnit controls test execution.

    public void shoppingTest(){
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String product1= driver.findElement(By.id("item_4_title_link")).getText();
        System.out.println(product1);

        String product2= driver.findElement(By.id("item_0_title_link")).getText();
        System.out.println(product2);

Assertions.assertEquals("Sauce Labs Backpack", product1);
Assertions.assertEquals("Sauce Labs Bike Light", product2);
    }

    @AfterEach
    void teardown(){
         driver.quit();

    }
}
