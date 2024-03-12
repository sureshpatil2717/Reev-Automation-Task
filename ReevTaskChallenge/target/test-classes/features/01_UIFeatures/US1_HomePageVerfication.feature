@UI @1
Feature: verfiy TestStation Numer 

Background:
		Given The user sets up functions
    Given The user go to the "baseURL" website

  Scenario:  Verify Homescreen 
  
 	  When The user asserts that "ChargePointInstallationForm_HeaderText" is visible
 	  Then The user asserts that "SerialNumberText" is visible
 		And The user fills the "InputSerialNumber" box as "TT 00 000"
	  When The user asserts that "AddButton" is visible
    When The user clicks the "AddButton" button
    Then The user asserts that "cancelButton" is visible
    When The user clicks the "cancelButton" button
    
  Scenario:  Verify The TestStation Functinality
    When The user fills the "InputSerialNumber" box as "TT 00 000"
  	And The user clicks the "AddButton" button
  	Then The user asserts that "VerifyTestStationNumber" is visible
  	And The user asserts that "cancelButton" is visible
  	When The user clicks the "cancelButton" button
  	Then The user asserts that VerifyTestStationNumber is not visible
  	And The user asserts that cancelButton is not visible