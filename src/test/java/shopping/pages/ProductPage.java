package shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage( WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;

    }

    // Adds the Sauce Labs Backpack to the shopping cart.
    public void addBackpack(){
        // Wait until the Backpack button is clickable, then click the button.
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack"))).click();
    }

    public void addBikeLight(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }
}
