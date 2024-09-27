@DollarToRs
Feature: Dollar to Rs price verification 

  @Google
  Scenario: Verify Dollar to Rs price is same when from Google and https://www.xe.com/
    Given I navigate to Google
    And Search for Dollar Price
    And Navigate to XE site and get the dollar price
    Then Verify dollar price is same for both sites