import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Assertions;

public class ShoppingTest
{
   // public static void main(String[] args) {

    // @Test tells JUnit that this method is a test case.
    // JUnit Test Runner discovers @Test methods and executes them.
    // No main() method is required because JUnit controls test execution.

    @Test
           public void shoppingTest(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        driver.findElement(By.className("shopping_cart_link")).click();

        String product1= driver.findElement(By.id("item_4_title_link")).getText();
        System.out.println(product1);

Assertions.assertEquals("Sauce Labs Backpack", product1);


       // driver.quit();
    }
}
