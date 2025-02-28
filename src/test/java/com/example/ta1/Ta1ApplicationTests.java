//package com.example.ta1;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//class Ta1ApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//
//}
package com.example.ta1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class Ta1ApplicationTests {
    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080";

    @BeforeClass
    public void setUp() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void testIndexPage() {
        driver.get(BASE_URL + "/index.html");
        Assert.assertEquals(driver.getTitle(), "Random Advice Generator", "Index Page title mismatch");
        Assert.assertTrue(driver.findElement(By.linkText("Login")).isDisplayed(), "Login link not found");
        Assert.assertTrue(driver.findElement(By.linkText("Register")).isDisplayed(), "Register link not found");
    }

    @Test(priority = 2)
    public void testLoginPage() {
        driver.get(BASE_URL + "/Login.html");
        Assert.assertEquals(driver.getTitle(), "Login", "Login Page title mismatch");
        Assert.assertTrue(driver.findElement(By.id("username")).isDisplayed(), "Username field not found");
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field not found");
        Assert.assertTrue(driver.findElement(By.id("submit-btn")).isDisplayed(), "Login button not found");
    }

    @Test(priority = 3)
    public void testRegistrationPage() {
        driver.get(BASE_URL + "/Registration.html");
        Assert.assertEquals(driver.getTitle(), "Registration", "Registration Page title mismatch");
        Assert.assertTrue(driver.findElement(By.id("Firstname")).isDisplayed(), "First Name field not found");
        Assert.assertTrue(driver.findElement(By.id("Lastname")).isDisplayed(), "Last Name field not found");
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed(), "Email field not found");
        Assert.assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field not found");
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Register button not found");
    }

    @Test(priority = 4)
    public void testCustomerCommentPage() {
        driver.get(BASE_URL + "/customer_comment.html");
        Assert.assertEquals(driver.getTitle(), "Customer Comment Section", "Customer Comment Page title mismatch");
        Assert.assertTrue(driver.findElement(By.id("comment")).isDisplayed(), "Comment box not found");
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Submit button not found");
    }

    @Test(priority = 5)
    public void testRatingPage() {
        driver.get(BASE_URL + "/rating.html");
        Assert.assertEquals(driver.getTitle(), "Rating Form", "Rating Page title mismatch");
        Assert.assertTrue(driver.findElement(By.className("rating")).isDisplayed(), "Rating stars not found");
        Assert.assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Submit button not found");
    }
}
