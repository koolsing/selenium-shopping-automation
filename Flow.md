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