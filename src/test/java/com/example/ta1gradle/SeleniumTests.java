package com.example.ta1;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class SeleniumTests {
    private static WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080";

    @BeforeAll
    public static void setUp() {
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testIndexPage() {
        driver.get(BASE_URL + "/index.html");
        assertEquals("Random Advice Generator", driver.getTitle(), "Index Page title mismatch");
        assertTrue(driver.findElement(By.linkText("Login")).isDisplayed(), "Login link not found");
        assertTrue(driver.findElement(By.linkText("Register")).isDisplayed(), "Register link not found");
    }

    @Test
    public void testLoginPage() {
        driver.get(BASE_URL + "/Login.html");
        assertEquals("Login", driver.getTitle(), "Login Page title mismatch");
        assertTrue(driver.findElement(By.id("username")).isDisplayed(), "Username field not found");
        assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field not found");
        assertTrue(driver.findElement(By.id("submit-btn")).isDisplayed(), "Login button not found");
    }

    @Test
    public void testRegistrationPage() {
        driver.get(BASE_URL + "/Registration.html");
        assertEquals("Registration", driver.getTitle(), "Registration Page title mismatch");
        assertTrue(driver.findElement(By.id("Firstname")).isDisplayed(), "First Name field not found");
        assertTrue(driver.findElement(By.id("Lastname")).isDisplayed(), "Last Name field not found");
        assertTrue(driver.findElement(By.id("email")).isDisplayed(), "Email field not found");
        assertTrue(driver.findElement(By.id("password")).isDisplayed(), "Password field not found");
        assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Register button not found");
    }

    @Test
    public void testCustomerCommentPage() {
        driver.get(BASE_URL + "/customer_comment.html");
        assertEquals("Customer Comment Section", driver.getTitle(), "Customer Comment Page title mismatch");
        assertTrue(driver.findElement(By.id("comment")).isDisplayed(), "Comment box not found");
        assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Submit button not found");
    }

    @Test
    public void testRatingPage() {
        driver.get(BASE_URL + "/rating.html");
        assertEquals("Rating Form", driver.getTitle(), "Rating Page title mismatch");
        assertTrue(driver.findElement(By.className("rating")).isDisplayed(), "Rating stars not found");
        assertTrue(driver.findElement(By.tagName("button")).isDisplayed(), "Submit button not found");
    }
}
