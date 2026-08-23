# Selenium Shopping Automation

A beginner-level web automation project built using **Java, Selenium WebDriver, JUnit, Maven, and ChromeDriver**.

The purpose of this project is to demonstrate the basic concepts of browser automation by automating a simple shopping workflow on **SauceDemo**.

---

## Table of Contents

* [Project Overview](#project-overview)
* [Automation Flow](#automation-flow)
* [Tools and Technologies](#tools-and-technologies)
* [Versions Used](#versions-used)
* [Project Structure](#project-structure)
* [How the Automation Works](#how-the-automation-works)
* [Key Selenium Concepts](#key-selenium-concepts)
* [Test Validation](#test-validation)
* [How to Run](#how-to-run)
* [Future Improvements](#future-improvements)

---

## Project Overview

This project automates a basic e-commerce workflow using Selenium WebDriver.

The automation opens the SauceDemo website, logs in using a test account, adds two products to the shopping cart, opens the cart, and verifies that the expected product is present.

The project was created as a basic introduction to **UI test automation with Selenium**.

---

## Automation Flow

The automated test follows this flow:

```text
Open Chrome
    ↓
Open SauceDemo
    ↓
Enter Username
    ↓
Enter Password
    ↓
Click Login
    ↓
Add Sauce Labs Backpack
    ↓
Add Sauce Labs Bike Light
    ↓
Open Shopping Cart
    ↓
Read Product Name
    ↓
Assert Expected Product
```

---

## Tools and Technologies

| Tool / Technology  | Purpose                                           |
| ------------------ | ------------------------------------------------- |
| Java               | Programming language used to write the automation |
| Selenium WebDriver | Automates browser actions                         |
| ChromeDriver       | Allows Selenium to control Chrome                 |
| JUnit              | Provides assertions for test validation           |
| Maven              | Manages project dependencies and builds           |
| IntelliJ IDEA      | IDE used for development                          |
| Google Chrome      | Browser used for automation                       |
| SauceDemo          | Website used as the test application              |

---

## Versions Used

| Tool           | Version                                               |
| -------------- | ----------------------------------------------------- |
| Java / OpenJDK | 26                                                    |
| Selenium Java  | 4.35.0                                                |
| JUnit Jupiter  | 5.13.4                                                |
| Maven          | 3.x / Maven installed through development environment |
| IntelliJ IDEA  | Current installed version                             |
| Google Chrome  | Current installed version                             |

> Versions may change depending on the local development environment. The Selenium and JUnit versions above are the versions configured in `pom.xml` for this project.

---

## Project Structure

The basic project structure is:

```text
selenium-shopping-automation
│
├── pom.xml
│
└── src
    └── test
        └── java
            └── ShoppingTest.java
```

### `pom.xml`

The `pom.xml` file is the Maven configuration file.

It contains the external libraries required by the project, including Selenium and JUnit.

### `ShoppingTest.java`

This class contains the Selenium automation code.

---

## How the Automation Works

### 1. Start Chrome

Selenium creates a Chrome browser session using:

```java
WebDriver driver = new ChromeDriver();
```

`WebDriver` is used to control the browser, while `ChromeDriver` provides the connection to Google Chrome.

---

### 2. Open the Website

The automation navigates to SauceDemo:

```java
driver.get("https://www.saucedemo.com/");
```

`get()` tells the browser to navigate to the specified URL.

---

### 3. Enter Username

The username field is located using its HTML ID:

```java
driver.findElement(By.id("user-name"))
      .sendKeys("standard_user");
```

`findElement()` locates the webpage element.

`By.id()` tells Selenium to locate the element using its ID.

`sendKeys()` enters the specified text.

---

### 4. Enter Password

The password field is located and populated:

```java
driver.findElement(By.id("password"))
      .sendKeys("secret_sauce");
```

---

### 5. Login

The Login button is located using its ID and clicked:

```java
driver.findElement(By.id("login-button"))
      .click();
```

---

### 6. Add the First Product

The automation locates the Add to Cart button for Sauce Labs Backpack:

```java
driver.findElement(
    By.id("add-to-cart-sauce-labs-backpack")
).click();
```

---

### 7. Add the Second Product

The automation adds Sauce Labs Bike Light:

```java
driver.findElement(
    By.id("add-to-cart-sauce-labs-bike-light")
).click();
```

---

### 8. Open the Shopping Cart

The cart is located using its CSS class:

```java
driver.findElement(
    By.className("shopping_cart_link")
).click();
```

This demonstrates another Selenium locator strategy besides `By.id()`.

---

### 9. Read the Product Name

The product name is retrieved from the webpage:

```java
String product1 = driver.findElement(
    By.id("item_4_title_link")
).getText();
```

`getText()` retrieves the visible text from the element.

The value is stored in a Java `String` variable called `product1`.

---

### 10. Validate the Product

JUnit is used to compare the expected product name with the actual product name:

```java
Assertions.assertEquals(
    "Sauce Labs Backpack",
    product1
);
```

If the expected and actual values match, the assertion passes.

If they don't match, the test fails.

This is an important difference between **browser automation** and **test automation**. Selenium performs the actions, while the assertion verifies the result.

---

## Key Selenium Concepts Demonstrated

This project demonstrates the following basic Selenium operations:

### `get()`

Used to navigate to a URL.

```java
driver.get("https://www.saucedemo.com/");
```

### `findElement()`

Used to locate a webpage element.

```java
driver.findElement(...)
```

### `By.id()`

Locates an element using its HTML ID.

```java
By.id("user-name")
```

### `By.className()`

Locates an element using its CSS class.

```java
By.className("shopping_cart_link")
```

### `sendKeys()`

Enters text into an input field.

```java
.sendKeys("standard_user")
```

### `click()`

Clicks a webpage element.

```java
.click()
```

### `getText()`

Reads visible text from a webpage element.

```java
.getText()
```

### JUnit Assertion

Validates that the actual result matches the expected result.

```java
Assertions.assertEquals(expected, actual);
```

---

## Maven Dependencies

The project uses Maven to manage Selenium and JUnit dependencies.

The important dependencies are:

```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.35.0</version>
</dependency>

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.13.4</version>
    <scope>test</scope>
</dependency>
```

Maven downloads these libraries and makes them available to the project.

---

## How to Run

### Prerequisites

Install:

* Java 26
* IntelliJ IDEA
* Maven
* Google Chrome

### Steps

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the project dependencies.
4. Open `ShoppingTest.java`.
5. Run the Java program.
6. Chrome will open automatically.
7. Selenium will perform the shopping workflow.

---

## Test Data

The project uses the standard SauceDemo test credentials:

```text
Username: standard_user
Password: secret_sauce
```

These are test credentials provided by the SauceDemo application and are not personal credentials.

---

## Current Scope

This is intentionally a **basic Selenium project**.

It demonstrates:

* Browser initialization
* Website navigation
* Element identification
* Text input
* Button clicking
* Product selection
* Cart navigation
* Reading webpage content
* Basic test assertion

It does not yet implement a full automation framework.

---

## Future Improvements

The project can be extended by adding:

* TestNG or a more structured JUnit test setup
* Page Object Model
* Explicit waits
* Multiple test cases
* Test data management
* Configuration files
* Screenshot capture on failure
* Logging
* HTML test reports
* Maven test execution
* CI/CD integration
* GitHub Actions

These improvements would transform the project from a basic Selenium exercise into a more maintainable automation framework.

---

## Learning Objective

The main objective of this project is to understand the basic Selenium automation pattern:

```text
Locate Element
      ↓
Perform Action
      ↓
Read Result
      ↓
Validate Result
```

This project provides the foundation for building more structured Selenium automation frameworks using Java.
