# Manual Test Case Report
# Travel Booking Platform

## Test Case Report
**Project Name:** Travel Booking Platform  
**Prepared By:** Junior Developer  
**Date:** January 15, 2026  

---

## Test Case 1: User Registration

**Test Case ID:** TC_TRV_001  
**Test Scenario:** Verify new user can register successfully  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to registration page | - | Registration form displays | - | - |
| 2 | Enter full name | Name: Raj Kumar | Name field populated | - | - |
| 3 | Enter email address | Email: raj@gmail.com | Email field populated | - | - |
| 4 | Enter password | Password: Pass@123 | Password field populated | - | - |
| 5 | Click Register button | - | Registration successful | - | - |

---

## Test Case 2: Flight Search

**Test Case ID:** TC_TRV_002  
**Test Scenario:** Verify flight search functionality  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to flight search | - | Search form displays | - | - |
| 2 | Enter from city | From: Delhi | From city selected | - | - |
| 3 | Enter to city | To: Mumbai | To city selected | - | - |
| 4 | Select departure date | Date: 20-02-2026 | Date selected | - | - |
| 5 | Click Search button | - | Flight results displayed | - | - |

---

## Test Case 3: Hotel Booking

**Test Case ID:** TC_TRV_003  
**Test Scenario:** Verify hotel can be booked  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to hotels section | - | Hotel search page displays | - | - |
| 2 | Enter destination | City: Goa | Destination selected | - | - |
| 3 | Select check-in date | Date: 15-03-2026 | Check-in date selected | - | - |
| 4 | Select check-out date | Date: 20-03-2026 | Check-out date selected | - | - |
| 5 | Click Search Hotels | - | Hotel list displayed | - | - |
| 6 | Select a hotel | Hotel: Beach Resort | Hotel selected | - | - |
| 7 | Click Book Now | - | Booking confirmation shown | - | - |

---

## Test Case 4: Add Traveller Details

**Test Case ID:** TC_TRV_004  
**Test Scenario:** Verify traveller details can be added  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Select a flight | Flight: AI-101 | Flight selected | - | - |
| 2 | Click Continue | - | Traveller details form shown | - | - |
| 3 | Enter passenger name | Name: Amit Singh | Name entered | - | - |
| 4 | Enter age | Age: 30 | Age entered | - | - |
| 5 | Select gender | Gender: Male | Gender selected | - | - |
| 6 | Click Continue | - | Payment page displayed | - | - |

---

## Test Case 5: Payment Processing

**Test Case ID:** TC_TRV_005  
**Test Scenario:** Verify payment can be processed  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | On payment page | - | Payment options displayed | - | - |
| 2 | Select payment method | Method: Credit Card | Method selected | - | - |
| 3 | Enter card number | Card: 4111111111111111 | Card number entered | - | - |
| 4 | Enter CVV | CVV: 123 | CVV entered | - | - |
| 5 | Click Pay Now | - | Payment successful | - | - |

---

## Test Case 6: View Booking History

**Test Case ID:** TC_TRV_006  
**Test Scenario:** Verify booking history can be viewed  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Login to account | - | Dashboard displayed | - | - |
| 2 | Click My Bookings | - | Booking history shown | - | - |
| 3 | Verify bookings list | - | All bookings displayed | - | - |

---

## Test Case 7: Cancel Booking

**Test Case ID:** TC_TRV_007  
**Test Scenario:** Verify booking can be cancelled  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to My Bookings | - | Booking list displayed | - | - |
| 2 | Select a booking | Booking: BK12345 | Booking details shown | - | - |
| 3 | Click Cancel button | - | Cancellation dialog appears | - | - |
| 4 | Confirm cancellation | - | Booking cancelled successfully | - | - |

---

## Test Case 8: Apply Promo Code

**Test Case ID:** TC_TRV_008  
**Test Scenario:** Verify promo code can be applied  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | On payment page | - | Payment summary displayed | - | - |
| 2 | Enter promo code | Code: SAVE20 | Promo code entered | - | - |
| 3 | Click Apply | - | Discount applied | - | - |
| 4 | Verify total amount | - | Amount reduced by discount | - | - |

---

## Test Case 9: Filter Search Results

**Test Case ID:** TC_TRV_009  
**Test Scenario:** Verify search results can be filtered  
**Priority:** Medium  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Search for flights | From: Delhi, To: Mumbai | Flight results shown | - | - |
| 2 | Apply price filter | Range: 3000-5000 | Results filtered by price | - | - |
| 3 | Apply airline filter | Airline: IndiGo | Results filtered by airline | - | - |
| 4 | Verify filtered results | - | Only matching flights shown | - | - |

---

## Test Case 10: Download Ticket

**Test Case ID:** TC_TRV_010  
**Test Scenario:** Verify ticket can be downloaded  
**Priority:** High  

| Step | Test Steps | Test Data | Expected Result | Actual Result | Status |
|------|-----------|-----------|-----------------|---------------|---------|
| 1 | Navigate to My Bookings | - | Booking list displayed | - | - |
| 2 | Select confirmed booking | Booking: BK12345 | Booking details shown | - | - |
| 3 | Click Download Ticket | - | PDF ticket downloaded | - | - |

---

## Summary

**Total Test Cases:** 10  
**Test Cases Passed:** -  
**Test Cases Failed:** -  
**Test Cases Blocked:** -  
**Test Cases Not Executed:** -  

**Remarks:** Test cases created for Travel Booking Platform. Ready for execution.
