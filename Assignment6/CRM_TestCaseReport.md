# Manual Test Case Report
# Customer Relationship Management (CRM) System

## Test Case Report
**Project Name:** Customer Relationship Management System  
**Prepared By:** Junior Developer  
**Date:** January 15, 2026  

---

## Test Case 1: User Login Functionality

**Test Case ID:** TC_CRM_001  
**Test Scenario:** Verify user can login with valid credentials  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Open CRM application | URL: http://crm.example.com | Login page displays | - | - |
| 2 | Enter valid username | Username: admin@crm.com | Username accepted | - | - |
| 3 | Enter valid password | Password: Admin@123 | Password accepted | - | - |
| 4 | Click Login button | - | User redirected to dashboard | - | - |

---

## Test Case 2: Add New Customer

**Test Case ID:** TC_CRM_002  
**Test Scenario:** Verify new customer can be added successfully  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Customers page | - | Customer list displays | - | - |
| 2 | Click Add Customer button | - | Add customer form appears | - | - |
| 3 | Enter customer name | Name: John Doe | Name field populated | - | - |
| 4 | Enter email | Email: john@example.com | Email field populated | - | - |
| 5 | Enter phone number | Phone: 9876543210 | Phone field populated | - | - |
| 6 | Click Save button | - | Customer added successfully | - | - |

---

## Test Case 3: Search Customer

**Test Case ID:** TC_CRM_003  
**Test Scenario:** Verify customer search functionality  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Customers page | - | Customer list displays | - | - |
| 2 | Enter search keyword | Keyword: John | Search results filtered | - | - |
| 3 | Verify search results | - | Matching customers shown | - | - |

---

## Test Case 4: Update Customer Information

**Test Case ID:** TC_CRM_004  
**Test Scenario:** Verify customer information can be updated  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Select a customer | Customer: John Doe | Customer details shown | - | - |
| 2 | Click Edit button | - | Edit form appears | - | - |
| 3 | Update phone number | Phone: 9999999999 | Phone field updated | - | - |
| 4 | Click Save button | - | Customer updated successfully | - | - |

---

## Test Case 5: Delete Customer

**Test Case ID:** TC_CRM_005  
**Test Scenario:** Verify customer can be deleted  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Select a customer | Customer: John Doe | Customer details shown | - | - |
| 2 | Click Delete button | - | Confirmation dialog appears | - | - |
| 3 | Confirm deletion | - | Customer deleted successfully | - | - |

---

## Test Case 6: Create New Deal

**Test Case ID:** TC_CRM_006  
**Test Scenario:** Verify new deal can be created  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Deals page | - | Deals list displays | - | - |
| 2 | Click Add Deal button | - | Add deal form appears | - | - |
| 3 | Enter deal name | Name: Software License | Deal name populated | - | - |
| 4 | Select customer | Customer: ABC Corp | Customer selected | - | - |
| 5 | Enter deal amount | Amount: 50000 | Amount field populated | - | - |
| 6 | Click Save button | - | Deal created successfully | - | - |

---

## Test Case 7: Email Integration

**Test Case ID:** TC_CRM_007  
**Test Scenario:** Verify email can be sent to customer  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Select a customer | Customer: ABC Corp | Customer details shown | - | - |
| 2 | Click Send Email button | - | Email compose window opens | - | - |
| 3 | Enter subject | Subject: Follow-up | Subject populated | - | - |
| 4 | Enter message body | Body: Thank you | Message populated | - | - |
| 5 | Click Send button | - | Email sent successfully | - | - |

---

## Test Case 8: Generate Sales Report

**Test Case ID:** TC_CRM_008  
**Test Scenario:** Verify sales report generation  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Reports page | - | Reports page displays | - | - |
| 2 | Select report type | Type: Sales Report | Report type selected | - | - |
| 3 | Select date range | Range: Last 30 days | Date range selected | - | - |
| 4 | Click Generate button | - | Report generated successfully | - | - |

---

## Test Case 9: User Logout

**Test Case ID:** TC_CRM_009  
**Test Scenario:** Verify user can logout successfully  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Click user profile icon | - | Profile menu displays | - | - |
| 2 | Click Logout option | - | User logged out | - | - |
| 3 | Verify redirect | - | Login page displays | - | - |

---

## Test Case 10: Invalid Login Attempt

**Test Case ID:** TC_CRM_010  
**Test Scenario:** Verify error message for invalid credentials  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Open CRM application | URL: http://crm.example.com | Login page displays | - | - |
| 2 | Enter invalid username | Username: wrong@test.com | Username entered | - | - |
| 3 | Enter invalid password | Password: wrong123 | Password entered | - | - |
| 4 | Click Login button | - | Error message displays | - | - |

---

## Summary

**Total Test Cases:** 10  
**Test Cases Passed:** -  
**Test Cases Failed:** -  
**Test Cases Blocked:** -  
**Test Cases Not Executed:** -  

**Remarks:** All test cases are ready for execution. Execution will be done in next phase.
