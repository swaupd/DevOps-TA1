# Random Advice Generator

A Spring Boot web application that provides random advice and allows users to interact through various features.

## Features

### 1. Home Page (index.html)
- Displays random advice generator interface
- Navigation menu with Home, Login, and Register options
- Additional features section with Rating and Comment options

#### Test Cases for Home Page
1. **Navigation Links**
   - Test: Verify all navigation links are working
   - Expected: Links should redirect to correct pages
   ```java
   @Test
   public void testNavigationLinks() {
       // Test home link
       assertEquals("/", homeLink.getHref());
       
       // Test login link
       assertEquals("/login", loginLink.getHref());
       
       // Test register link
       assertEquals("/register", registerLink.getHref());
   }
   ```

2. **Advice Generator**
   - Test: Verify advice generation functionality
   - Expected: Should display new advice when button is clicked
   ```java
   @Test
   public void testAdviceGeneration() {
       // Test initial advice display
       assertNotNull(adviceText);
       
       // Test advice button click
       adviceButton.click();
       assertNotEquals(initialAdvice, newAdvice);
   }
   ```

3. **Feature Buttons**
   - Test: Verify rating and comment buttons
   - Expected: Should redirect to respective pages
   ```java
   @Test
   public void testFeatureButtons() {
       // Test rating button
       assertEquals("/rating", ratingButton.getHref());
       
       // Test comment button
       assertEquals("/comment", commentButton.getHref());
   }
   ```

### 2. Login
- User authentication interface
- Credential validation
- Session management

### 3. Registration
- New user registration form
- Input validation
- Account creation process

### 4. Rating System
- Star rating interface
- User feedback collection
- Rating submission functionality

### 5. Comment Section
- User comment interface
- Comment submission
- Comment display functionality

## Technical Stack
- Spring Boot 3.2.3
- Thymeleaf
- HTML/CSS/JavaScript
- Maven

## Project Structure
