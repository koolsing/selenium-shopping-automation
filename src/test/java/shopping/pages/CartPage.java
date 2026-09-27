package shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;
    }

    public void openCart(){
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
    }

    public String getBackPackName(){
        String product1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_4_title_link"))).getText();
        System.out.println(product1);
        return product1;
    }

    public String getBikeLightName(){
        String product2= wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("item_0_title_link"))).getText();
        System.out.println(product2);
        return product2;
    }
}
