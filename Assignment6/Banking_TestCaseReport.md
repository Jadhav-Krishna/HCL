# Manual Test Case Report
# Automate Banking Website

## Test Case Report
**Project Name:** Automate Banking System  
**Prepared By:** Junior Developer  
**Date:** January 15, 2026  

---

## Test Case 1: Account Login

**Test Case ID:** TC_BANK_001  
**Test Scenario:** Verify customer can login to banking portal  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to login page | - | Login page displays | - | - |
| 2 | Enter customer ID | ID: CUST12345 | Customer ID entered | - | - |
| 3 | Enter password | Password: Bank@123 | Password entered | - | - |
| 4 | Click Login button | - | User logged in successfully | - | - |

---

## Test Case 2: View Account Balance

**Test Case ID:** TC_BANK_002  
**Test Scenario:** Verify account balance can be viewed  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Login to account | - | Dashboard displayed | - | - |
| 2 | Click View Balance | - | Account balance page opens | - | - |
| 3 | Verify balance display | - | Current balance shown | - | - |

---

## Test Case 3: Fund Transfer

**Test Case ID:** TC_BANK_003  
**Test Scenario:** Verify fund transfer between accounts  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Fund Transfer | - | Transfer page displays | - | - |
| 2 | Enter beneficiary account | Account: 123456789012 | Account number entered | - | - |
| 3 | Enter amount | Amount: 5000 | Amount entered | - | - |
| 4 | Enter remarks | Remarks: Payment | Remarks entered | - | - |
| 5 | Click Transfer | - | OTP page displayed | - | - |
| 6 | Enter OTP | OTP: 123456 | OTP entered | - | - |
| 7 | Click Confirm | - | Transfer successful | - | - |

---

## Test Case 4: View Transaction History

**Test Case ID:** TC_BANK_004  
**Test Scenario:** Verify transaction history can be viewed  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Login to account | - | Dashboard displayed | - | - |
| 2 | Click Transaction History | - | Transaction list page opens | - | - |
| 3 | Select date range | Range: Last 30 days | Date range selected | - | - |
| 4 | Click View | - | Transactions displayed | - | - |

---

## Test Case 5: Bill Payment

**Test Case ID:** TC_BANK_005  
**Test Scenario:** Verify bill payment functionality  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Bill Payment | - | Bill payment page opens | - | - |
| 2 | Select biller | Biller: Electricity Board | Biller selected | - | - |
| 3 | Enter consumer number | Number: 1234567890 | Consumer number entered | - | - |
| 4 | Fetch bill | - | Bill amount displayed | - | - |
| 5 | Click Pay | - | Payment successful | - | - |

---

## Test Case 6: Add Beneficiary

**Test Case ID:** TC_BANK_006  
**Test Scenario:** Verify beneficiary can be added  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Manage Beneficiary | - | Beneficiary page displays | - | - |
| 2 | Click Add Beneficiary | - | Add beneficiary form appears | - | - |
| 3 | Enter account number | Account: 987654321098 | Account entered | - | - |
| 4 | Enter IFSC code | IFSC: SBIN0001234 | IFSC entered | - | - |
| 5 | Enter beneficiary name | Name: Raj Kumar | Name entered | - | - |
| 6 | Click Add | - | Beneficiary added successfully | - | - |

---

## Test Case 7: Download Statement

**Test Case ID:** TC_BANK_007  
**Test Scenario:** Verify account statement can be downloaded  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Login to account | - | Dashboard displayed | - | - |
| 2 | Click Download Statement | - | Statement page opens | - | - |
| 3 | Select date range | Range: Jan 2026 | Date range selected | - | - |
| 4 | Select format | Format: PDF | Format selected | - | - |
| 5 | Click Download | - | Statement downloaded | - | - |

---

## Test Case 8: Change Password

**Test Case ID:** TC_BANK_008  
**Test Scenario:** Verify password can be changed  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Settings | - | Settings page displays | - | - |
| 2 | Click Change Password | - | Change password form appears | - | - |
| 3 | Enter old password | Password: Bank@123 | Old password entered | - | - |
| 4 | Enter new password | Password: NewBank@456 | New password entered | - | - |
| 5 | Confirm new password | Password: NewBank@456 | Password confirmed | - | - |
| 6 | Click Update | - | Password changed successfully | - | - |

---

## Test Case 9: Fixed Deposit Creation

**Test Case ID:** TC_BANK_009  
**Test Scenario:** Verify fixed deposit can be created  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Fixed Deposit | - | FD page displays | - | - |
| 2 | Click Create FD | - | FD form appears | - | - |
| 3 | Enter deposit amount | Amount: 100000 | Amount entered | - | - |
| 4 | Select tenure | Tenure: 1 year | Tenure selected | - | - |
| 5 | View interest rate | - | Interest rate displayed | - | - |
| 6 | Click Create | - | FD created successfully | - | - |

---

## Test Case 10: Logout Functionality

**Test Case ID:** TC_BANK_010  
**Test Scenario:** Verify user can logout successfully  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Click logout button | - | Confirmation dialog appears | - | - |
| 2 | Confirm logout | - | User logged out | - | - |
| 3 | Verify redirect | - | Login page displayed | - | - |

---

## Summary

**Total Test Cases:** 10  
**Test Cases Passed:** -  
**Test Cases Failed:** -  
**Test Cases Blocked:** -  
**Test Cases Not Executed:** -  

**Remarks:** Banking system test cases ready. Execution pending.
