package com.example.ta1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class SeleniumTests {

    private WebDriver driver;
    private String baseUrl = "http://localhost:8080";

    public static void main(String[] args) {
        SeleniumTests tests = new SeleniumTests();
        tests.run();
    }

    public void run() {
        try {
            setUp();
            int choice = getTestChoice();
            runSelectedTest(choice);
        } catch (Exception e) {
            System.out.println("Error during test execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    private void setUp() {
        System.out.println("Setting up Safari WebDriver...");
        driver = new SafariDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    private void tearDown() {
        System.out.println("Cleaning up resources...");
        if (driver != null) {
            driver.quit();
        }
    }

    private void runSelectedTest(int choice) {
        switch (choice) {
            case 1:
                testIndexPage();
                break;
            case 2:
                testLoginPage();
                break;
            case 3:
                testRegistrationPage();
                break;
            case 4:
                testCustomerCommentPage();
                break;
            case 5:
                testRatingPage();
                break;
            case 6:
                testAllPages();
                break;
            default:
                System.out.println("Invalid choice. Running index page test by default.");
                testIndexPage();
        }
    }

    private int getTestChoice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n==== Selenium Test Selection ====");
        System.out.println("1. Test Index Page");
        System.out.println("2. Test Login Page");
        System.out.println("3. Test Registration Page");
        System.out.println("4. Test Customer Comment Page");
        System.out.println("5. Test Rating Page");
        System.out.println("6. Test All Pages");
        System.out.print("\nEnter your choice (1-6): ");
        
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            return 1; // Default to index page if input is invalid
        }
    }

    private void testIndexPage() {
        System.out.println("Testing Index Page Loading...");
        driver.get(baseUrl + "/");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Index Page Test Completed");
    }

    private void testLoginPage() {
        System.out.println("Testing Login Page Loading...");
        driver.get(baseUrl + "/login");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Login Page Test Completed");
    }

    private void testRegistrationPage() {
        System.out.println("Testing Registration Page Loading...");
        driver.get(baseUrl + "/register");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Registration Page Test Completed");
    }

    private void testCustomerCommentPage() {
        System.out.println("Testing Customer Comment Page Loading...");
        driver.get(baseUrl + "/comment");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Customer Comment Page Test Completed");
    }

    private void testRatingPage() {
        System.out.println("Testing Rating Page Loading...");
        driver.get(baseUrl + "/rating");
        System.out.println("Page Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println("Rating Page Test Completed");
    }

    private void testAllPages() {
        System.out.println("Testing All Pages Sequentially...");
        testIndexPage();
        testLoginPage();
        testRegistrationPage();
        testCustomerCommentPage();
        testRatingPage();
        System.out.println("All Pages Test Completed");
    }
}
