package shopping.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage( WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;

    }
}
