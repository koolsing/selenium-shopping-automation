package shopping.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    //LoginPage constructor
    // this.driver means the driver field belonging to the current LoginPage object.
    // driver means the WebDriver reference received by this constructor.
    // The constructor receives the existing WebDriver and WebDriverWait objects from the test class.
    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait= wait;
    }

    //login method to login
    public void login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
    }
}
