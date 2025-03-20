Feature: User Registration Feature

Background: 
		Given: User is on login Page

  Scenario: User click on Register link
    Given User is on login page
    When User clicks on Register link
    Then User is navigated to Register page


  Scenario Outline: Registration scenario with different set of data
    Given User is on login page
    When User clicks on Register link
    And user fills the form from given sheetname "<SheetName>" and rownumber <RowNumber>
    Then it shows a successful message "Your message has been successfully sent to our team."

    Examples: 
      | SheetName | RowNumber |
      | Registration | 0 |
      | Registration | 1 |
      | Registration | 2 |
      | Registration | 3 |
