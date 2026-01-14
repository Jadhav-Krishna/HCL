# Manual Test Case Report
# Healthcare System

## Test Case Report
**Project Name:** Healthcare Management System  
**Prepared By:** Junior Developer  
**Date:** January 15, 2026  

---

## Test Case 1: Patient Registration

**Test Case ID:** TC_HCS_001  
**Test Scenario:** Verify new patient can be registered  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to registration page | - | Registration form displays | - | - |
| 2 | Enter patient name | Name: Priya Sharma | Name entered | - | - |
| 3 | Enter age | Age: 35 | Age entered | - | - |
| 4 | Select gender | Gender: Female | Gender selected | - | - |
| 5 | Enter contact number | Phone: 9876543210 | Phone entered | - | - |
| 6 | Enter address | Address: Mumbai | Address entered | - | - |
| 7 | Click Register | - | Patient registered successfully | - | - |

---

## Test Case 2: Doctor Login

**Test Case ID:** TC_HCS_002  
**Test Scenario:** Verify doctor can login to system  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to login page | - | Login page displays | - | - |
| 2 | Enter doctor ID | ID: DOC001 | Doctor ID entered | - | - |
| 3 | Enter password | Password: Doc@123 | Password entered | - | - |
| 4 | Click Login | - | Doctor dashboard displayed | - | - |

---

## Test Case 3: Book Appointment

**Test Case ID:** TC_HCS_003  
**Test Scenario:** Verify appointment can be booked  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Patient login | - | Patient dashboard shown | - | - |
| 2 | Click Book Appointment | - | Appointment form appears | - | - |
| 3 | Select department | Department: Cardiology | Department selected | - | - |
| 4 | Select doctor | Doctor: Dr. Amit | Doctor selected | - | - |
| 5 | Select date | Date: 25-01-2026 | Date selected | - | - |
| 6 | Select time slot | Time: 10:00 AM | Time selected | - | - |
| 7 | Click Book | - | Appointment booked successfully | - | - |

---

## Test Case 4: View Appointment History

**Test Case ID:** TC_HCS_004  
**Test Scenario:** Verify appointment history can be viewed  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Patient login | - | Dashboard displayed | - | - |
| 2 | Click My Appointments | - | Appointment list shown | - | - |
| 3 | Verify appointments | - | All appointments displayed | - | - |

---

## Test Case 5: Cancel Appointment

**Test Case ID:** TC_HCS_005  
**Test Scenario:** Verify appointment can be cancelled  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to My Appointments | - | Appointment list displayed | - | - |
| 2 | Select an appointment | Appointment: APT001 | Appointment selected | - | - |
| 3 | Click Cancel | - | Confirmation dialog appears | - | - |
| 4 | Confirm cancellation | - | Appointment cancelled | - | - |

---

## Test Case 6: Add Medical Records

**Test Case ID:** TC_HCS_006  
**Test Scenario:** Verify doctor can add medical records  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Doctor login | - | Doctor dashboard shown | - | - |
| 2 | Select patient | Patient: Priya Sharma | Patient selected | - | - |
| 3 | Click Add Records | - | Medical record form appears | - | - |
| 4 | Enter diagnosis | Diagnosis: Hypertension | Diagnosis entered | - | - |
| 5 | Enter prescription | Medicine: Amlodipine 5mg | Prescription entered | - | - |
| 6 | Click Save | - | Record saved successfully | - | - |

---

## Test Case 7: View Patient Medical History

**Test Case ID:** TC_HCS_007  
**Test Scenario:** Verify patient medical history can be viewed  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Doctor login | - | Dashboard displayed | - | - |
| 2 | Search patient | Patient ID: PAT001 | Patient found | - | - |
| 3 | Click View History | - | Medical history displayed | - | - |
| 4 | Verify records | - | All past records shown | - | - |

---

## Test Case 8: Generate Bill

**Test Case ID:** TC_HCS_008  
**Test Scenario:** Verify bill can be generated  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Billing | - | Billing page displays | - | - |
| 2 | Select patient | Patient: Priya Sharma | Patient selected | - | - |
| 3 | Add consultation fee | Fee: 500 | Fee added | - | - |
| 4 | Add medicine charges | Charges: 300 | Charges added | - | - |
| 5 | Click Generate Bill | - | Bill generated | - | - |
| 6 | Verify total amount | Amount: 800 | Total calculated correctly | - | - |

---

## Test Case 9: Search Doctor by Specialization

**Test Case ID:** TC_HCS_009  
**Test Scenario:** Verify doctors can be searched by specialization  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to Find Doctor | - | Search page displays | - | - |
| 2 | Select specialization | Specialization: Cardiology | Specialization selected | - | - |
| 3 | Click Search | - | Matching doctors displayed | - | - |
| 4 | Verify results | - | Only cardiologists shown | - | - |

---

## Test Case 10: Download Prescription

**Test Case ID:** TC_HCS_010  
**Test Scenario:** Verify prescription can be downloaded  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Patient login | - | Dashboard displayed | - | - |
| 2 | Navigate to My Records | - | Medical records shown | - | - |
| 3 | Select a record | Record: REC001 | Record selected | - | - |
| 4 | Click Download Prescription | - | PDF prescription downloaded | - | - |

---

## Summary

**Total Test Cases:** 10  
**Test Cases Passed:** -  
**Test Cases Failed:** -  
**Test Cases Blocked:** -  
**Test Cases Not Executed:** -  

**Remarks:** Healthcare system test cases documented. Ready for test execution.
