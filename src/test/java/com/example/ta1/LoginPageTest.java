import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private static final String BASE_URL = "file:///path/to/your/Login.html"; // Update this path
    
    @BeforeClass
    public void setUp() {
        // Set up ChromeDriver - update the path according to your system
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testValidLogin() {
        driver.get(BASE_URL);
        
        // Find elements
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement submitButton = driver.findElement(By.id("submit-btn"));
        
        // Enter valid credentials
        usernameField.sendKeys("ritesh");
        passwordField.sendKeys("Admin@123");
        
        // Verify submit button is enabled
        Assert.assertTrue(submitButton.isEnabled());
        
        // Submit form
        submitButton.click();
        
        // Verify local storage has user details (you might need to adjust this verification)
        String userDetails = (String) ((JavascriptExecutor) driver)
            .executeScript("return localStorage.getItem('userDetails');");
        Assert.assertNotNull(userDetails);
        Assert.assertTrue(userDetails.contains("ritesh"));
    }

    @Test
    public void testInvalidLogin() {
        driver.get(BASE_URL);
        
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        
        // Test with invalid username (too short)
        usernameField.sendKeys("user");
        passwordField.sendKeys("Admin@123");
        
        // Verify username field has red border
        String usernameBorder = usernameField.getCssValue("border");
        Assert.assertTrue(usernameBorder.contains("red"));
        
        // Verify submit button is disabled
        WebElement submitButton = driver.findElement(By.id("submit-btn"));
        Assert.assertFalse(submitButton.isEnabled());
    }

    @Test
    public void testPasswordToggle() {
        driver.get(BASE_URL);
        
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement showPassButton = driver.findElement(By.id("show-pass"));
        
        // Verify initial password field type is "password"
        Assert.assertEquals(passwordField.getAttribute("type"), "password");
        
        // Click show password button
        showPassButton.click();
        
        // Verify password is now visible
        Assert.assertEquals(passwordField.getAttribute("type"), "text");
        
        // Click show password button again
        showPassButton.click();
        
        // Verify password is hidden again
        Assert.assertEquals(passwordField.getAttribute("type"), "password");
    }

    @Test
    public void testPasswordValidation() {
        driver.get(BASE_URL);
        
        WebElement passwordField = driver.findElement(By.id("password"));
        
        // Test invalid password (no special character)
        passwordField.sendKeys("Password123");
        
        // Verify password field has red border
        String passwordBorder = passwordField.getCssValue("border");
        Assert.assertTrue(passwordBorder.contains("red"));
        
        // Clear and test valid password
        passwordField.clear();
        passwordField.sendKeys("Admin@123");
        
        // Verify password field has green border
        passwordBorder = passwordField.getCssValue("border");
        Assert.assertTrue(passwordBorder.contains("green"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
} 