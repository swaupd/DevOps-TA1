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

### Test Cases for Login.html

| Test Case No. | Description | Test Steps | Expected Output | Actual Output | Status |
|---------------|-------------|------------|-----------------|---------------|---------|
| TC_L01 | Verify Valid Login | 1. Enter valid username "ritesh"<br>2. Enter valid password "Admin@123"<br>3. Click Submit | Should login successfully and store user details | Login successful | ✅ PASS |
| TC_L02 | Verify Invalid Username | 1. Enter short username "user"<br>2. Enter valid password | 1. Red border on username field<br>2. Submit button disabled | Validation working | ✅ PASS |
| TC_L03 | Verify Password Toggle | 1. Enter password<br>2. Click show/hide button<br>3. Click again | Password visibility should toggle | Toggle working | ✅ PASS |
| TC_L04 | Verify Password Validation | 1. Enter password without special char<br>2. Enter valid password | 1. Red border for invalid<br>2. Green border for valid | Validation working | ✅ PASS |
| TC_L05 | Verify Empty Fields | 1. Leave fields empty<br>2. Click Submit | Submit button should be disabled | Button disabled | ✅ PASS |
| TC_L06 | Verify Remember Me | 1. Check Remember Me<br>2. Login<br>3. Reopen page | Credentials should be remembered | Not implemented | ❌ FAIL |
| TC_L07 | Verify Register Link | 1. Click Register link | Should redirect to registration page | Redirects correctly | ✅ PASS |
| TC_L08 | Verify Form Reset | 1. Enter data<br>2. Click Reset | All fields should clear | Reset working | ✅ PASS |
| TC_L09 | Verify Password Strength | 1. Enter weak password<br>2. Enter strong password | Should show strength indicator | Not implemented | ❌ FAIL |
| TC_L10 | Verify Session Storage | 1. Login successfully<br>2. Check session storage | User details should be stored | Storage working | ✅ PASS |

### Test Cases for Registration.html

| Test Case No. | Description | Test Steps | Expected Output | Actual Output | Status |
|---------------|-------------|------------|-----------------|---------------|---------|
| TC_R01 | Verify Valid Registration | 1. Fill all fields correctly<br>2. Click Submit | Should register successfully | Registration works | ✅ PASS |
| TC_R02 | Verify Email Validation | 1. Enter invalid email<br>2. Enter valid email | 1. Show error for invalid<br>2. Accept valid | Validation working | ✅ PASS |
| TC_R03 | Verify Password Match | 1. Enter different passwords | Should show mismatch error | Error shown | ✅ PASS |
| TC_R04 | Verify Username Unique | 1. Enter existing username | Should show "already exists" | Not implemented | ❌ FAIL |
| TC_R05 | Verify Required Fields | 1. Submit empty form | Should show required messages | Messages shown | ✅ PASS |
| TC_R06 | Verify Phone Format | 1. Enter invalid phone<br>2. Enter valid phone | Should validate format | Validation working | ✅ PASS |
| TC_R07 | Verify Terms Checkbox | 1. Try submit without checking | Submit should be disabled | Button disabled | ✅ PASS |
| TC_R08 | Verify Form Reset | 1. Fill form<br>2. Click Reset | Should clear all fields | Reset working | ✅ PASS |
| TC_R09 | Verify Login Link | 1. Click Login link | Should redirect to login | Redirects correctly | ✅ PASS |
| TC_R10 | Verify Success Message | 1. Complete registration | Should show success message | Message shown | ✅ PASS |

### Test Summary
- Total Tests: 30 (10 Home + 10 Login + 10 Registration)
- Passed: 27
- Failed: 3
- Pass Rate: 90%

### Failed Test Details

1. **TC_01: Home Link Navigation**
   - Issue: Using relative path instead of Spring Boot mapping
   - Fix: Change `href="index.html"` to `href="/"`

2. **TC_09: Responsive Design**
   - Issue: Layout not optimized for mobile devices
   - Fix: Add media queries for smaller screens

3. **TC_L06: Remember Me Functionality**
   - Issue: Remember Me checkbox not implemented
   - Fix: Implement local storage for remembered credentials

4. **TC_L09: Password Strength Indicator**
   - Issue: No visual password strength feedback
   - Fix: Add password strength meter

5. **TC_R04: Username Uniqueness Check**
   - Issue: No backend validation for existing usernames
   - Fix: Implement API endpoint for username availability check

### Test Environment
- Browser: Chrome 121.0.6167.185
- Resolution: 1920x1080
- Operating System: Windows 10
- Spring Boot Version: 3.2.3
