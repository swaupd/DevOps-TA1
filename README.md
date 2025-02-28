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

2. **Advice Generator**
   - Test: Verify advice generation functionality

3. **Feature Buttons**
   - Test: Verify rating and comment buttons

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
| **Test Case No.** | **Description** | **Test Steps** | **Expected Output** | **Actual Output** | **Status** |
|------------------|----------------|----------------|----------------------|------------------|------------|
| **TC_01** | Verify page loads with correct title | Open the webpage in the browser | Page title should be "Rating Form" | ✅ Page title is "Rating Form" | ✅ Pass |
| **TC_02** | Verify clicking a star selects it | Click on any star (e.g., 3rd star) | The selected star should turn gold | ❌ Only one star turns gold instead of all before it | ❌ Fail |
| **TC_03** | Verify all stars are clickable | Click each star one by one | Each clicked star should turn gold | ❌ Only the last clicked star stays active, others do not stay active | ❌ Fail |
| **TC_04** | Verify feedback textbox is present | Check if the textarea is visible | The feedback textbox should be displayed | ✅ Textarea is visible | ✅ Pass |
| **TC_05** | Verify feedback input works | Enter text into the feedback box | Text should appear in the box | ✅ Text appears correctly in the box | ✅ Pass |
| **TC_06** | Verify submit button exists | Check if the submit button is visible | The submit button should be displayed | ✅ Submit button is visible | ✅ Pass |
| **TC_07** | Verify alert on submitting without a rating | Click submit without selecting a rating | An alert should appear saying "Please select a rating before submitting" | ❌ Alert text has a typo ("slect" instead of "select") | ❌ Fail |
| **TC_08** | Verify submitting with rating and feedback | Select a rating, enter feedback, and submit | Alert should show rating and feedback text | ✅ Alert displays rating and feedback correctly | ✅ Pass |
| **TC_09** | Verify multiple star clicks update selection | Click one star, then another | The latest clicked star should be active, previous should be inactive | ❌ Only the last clicked star remains active | ❌ Fail |
| **TC_10** | Verify feedback is cleared after submission | Enter feedback, submit, and check the box | The feedback textbox should be empty after submission | ❌ Feedback is not cleared after submission | ❌ Fail |

### 5. Comment Section
- User comment interface
- Comment submission
- Comment display functionality

### Test Cases for Comment Section

| Test Case No. | Input | Expected Output | Status |
|---------------|-------|-----------------|--------|
| TC_01 | Enter “This is a test comment” and click “Submit” | The comment should appear in the comments section | ✅ Pass |
| TC_02 | Enter “First comment” and submit, then enter “Second comment” and submit | Both comments should appear in the comments section, with the latest one at the top | ✅ Pass |
| TC_03 | Enter “   Hello, world!   “ and click “Submit” | The comment should appear in the comments section, trimmed to “Hello, world!” | ✅ Pass |
| TC_04 | Enter “Great service! 😊💯🔥” and click “Submit” | The comment should appear in the comments section with emojis | ✅ Pass |
| TC_05 | Enter “Order #12345 was great!” and click “Submit” | The comment should appear in the comments section | ✅ Pass |
| TC_06 | Click “Submit” without entering text | No comment should be added (function prevents empty submission) | ❌ Fail |
| TC_07 | Enter “      “ (only spaces) and click “Submit” | No comment should be added | ❌ Fail |
| TC_08 | Enter “Persistent comment”, submit, then refresh the page | The comment should NOT be present after the page reloads | ❌ Fail |
| TC_09 | Enter a comment with 1000+ characters and click “Submit” | May cause UI issues if no character limit is enforced | ❌ Fail |
| TC_10 | Enter “Check reset”, click “Submit”, then check the input box | The comment box should be cleared after submitting | ✅ Pass |

## Technical Stack
- Spring Boot 3.2.3
- Thymeleaf
- HTML/CSS/JavaScript
- Maven

## Project Structure

### Test Cases for index.html

| Test Case No. | Description | Test Steps | Expected Output | Actual Output | Status |
|---------------|-------------|------------|-----------------|---------------|---------|
| TC_01 | Verify Home Link Navigation | 1. Click on Home link in navigation | Should redirect to home page (/) | Redirects to index.html | ❌ FAIL |
| TC_02 | Verify Advice Generation | 1. Load the page<br>2. Click "Get New Advice" button | 1. Button should be visible<br>2. New advice text should appear | 1. Button visible<br>2. New advice displayed | ✅ PASS |
| TC_03 | Verify Rating Button | 1. Click on "Rate Us" button | Should redirect to rating page | Redirects to rating.html | ✅ PASS |
| TC_04 | Verify Comment Button | 1. Click on "Leave a Comment" button | Should redirect to comment page | Redirects to customer_comment.html | ✅ PASS |
| TC_05 | Verify Login Link | 1. Click on Login link | Should redirect to login page | Redirects to Login.html | ✅ PASS |
| TC_06 | Verify Register Link | 1. Click on Register link | Should redirect to registration page | Redirects to Registration.html | ✅ PASS |
| TC_07 | Verify Advice API Integration | 1. Load the page<br>2. Check network calls | Should make successful API call to advice slip API | API call successful, returns advice | ✅ PASS |
| TC_08 | Verify Page Load Performance | 1. Load the page<br>2. Measure load time | Page should load within 3 seconds | Loads in 2.5 seconds | ✅ PASS |
| TC_09 | Verify Responsive Design | 1. View page on mobile device<br>2. Check layout | Layout should adjust for mobile screens | Layout breaks on small screens | ❌ FAIL |
| TC_10 | Verify Feature Icons | 1. Check if Font Awesome icons load<br>2. Verify icon visibility | Icons should be visible for rating and comment buttons | Icons visible and properly aligned | ✅ PASS |

### Test Summary
- Total Tests: 10
- Passed: 8
- Failed: 2
- Pass Rate: 80%

### Failed Test Details

1. **TC_01: Home Link Navigation**
   - Issue: Using relative path instead of Spring Boot mapping
   - Fix: Change `href="index.html"` to `href="/"`

2. **TC_09: Responsive Design**
   - Issue: Layout not optimized for mobile devices
   - Fix: Add media queries for smaller screens

### Test Environment
- Browser: Chrome 121.0.6167.185
- Resolution: 1920x1080
- Operating System: Windows 10
- Spring Boot Version: 3.2.3
