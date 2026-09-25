# Step by step flow achieved

## First step
Java
↓
main()
↓
Selenium
↓
Chrome

## Second step

IntelliJ
↓
JUnit
↓
find @Test
↓
shoppingTest()
↓
Selenium
↓
Chrome

## Third Step
@BeforeEach
↓
Chrome opens
↓
@Test runs
↓
Shopping automation happens
↓
Assertion checks product
↓
@AfterEach
↓
Chrome closes
↓
PASS

## Next step
@BeforeEach
↓
Create ChromeDriver + open Chrome
↓
@Test
↓
Open SauceDemo
↓
Login using username + password variables (no hardcoding in tests)
↓
Add products + open cart
↓
Verify product with assertion
↓
@AfterEach
↓
Close Chrome
↓
PASS


## Next step
@BeforeEach
↓
Create ChromeDriver + open Chrome
↓
@Test
↓
Open SauceDemo
↓
Login using username + password variables
↓
Add products + open cart
↓
Verify product 1 + product 2 with assertions
↓
@AfterEach
↓
Close Chrome
↓
PASS



Next step
expectedProduct1
↓
"Sauce Labs Backpack"

product1
↓
actual text from webpage

assertEquals(expectedProduct1, product1)

FLow:
@BeforeEach
↓
Create ChromeDriver
↓
Create WebDriverWait
↓
Open SauceDemo
↓
Login
↓
Wait for Login → click
↓
Add products
↓
Wait for Cart → click
↓
Wait for Backpack → read text
↓
Wait for Bike Light → read text
↓
Compare expected vs actual
↓
@AfterEach
↓
Close Chrome
↓
PASS


Next step
@BeforeEach
↓
Create ChromeDriver
↓
Create WebDriverWait
↓
@Test
↓
Test data
↓
Open SauceDemo
↓
Login
↓
Add products
↓
Wait for Cart → click
↓
Wait for products → read text
↓
Assert expected vs actual + failure message
↓
@AfterEach
↓
Close Chrome
↓
PASS



Next step
SHOPPING TEST
|
|
WebDriver driver
|
↓
ChromeDriver object
|
|
↓
LoginPage loginPage =
new LoginPage(driver)
|
↓
CREATE LoginPage OBJECT
|
↓
LoginPage(WebDriver driver)
CONSTRUCTOR
|
↓
this.driver = driver
|
┌───────────┴───────────┐
↓                       ↓
LoginPage's field       Constructor parameter
WebDriver driver        WebDriver driver
|                       |
└───────────┬───────────┘
|
↓
SAME WebDriver OBJECT
|
↓
ChromeDriver


Next
@BeforeEach
↓
Create ChromeDriver
↓
Create WebDriverWait
↓
@Test shoppingTest()
↓
Open SauceDemo
↓
Create LoginPage object
↓
LoginPage receives existing driver
↓
[Next step: move login actions into LoginPage]


Next
LoginPage
|
├── driver
|
├── constructor
|      ↓
|   receives WebDriver
|
└── login()
↓
username
password
login button


Next
ShoppingTest
|
├── driver ──────→ ChromeDriver
|
└── wait ─────────→ WebDriverWait
|
↓
new LoginPage(driver, wait)
|
↓
LoginPage object
-----------------------------

Next
Before:
ShoppingTest
↓
Find username
↓
Find password
↓
Wait for login button
↓
Click login

Now:
ShoppingTest
↓
loginPage.login(username, password)
↓
LoginPage
↓
Enter username
↓
Enter password
↓
Wait for login button
↓
Click login

Now, using Page Objects, ShoppingTest describes the test flow, 
while LoginPage contains the details of how login is performed.

Bug Fix: Page not loading fast so added wait for the item locator.
-------------------------------

Current State:
ShoppingTest
↓
Create ChromeDriver
↓
Create WebDriverWait
↓
Open SauceDemo
↓
Create LoginPage(driver, wait)
↓
loginPage.login(username, password)
↓
┌──────────────────────┐
│      LoginPage       │
│                      │
│ Enter username       │
│ Enter password       │
│ Wait for login       │
│ Click login          │
└──────────────────────┘
↓
Wait for Backpack
↓
Add Backpack
↓
Add Bike Light
↓
Open Cart
↓
Verify products
↓
Close browser