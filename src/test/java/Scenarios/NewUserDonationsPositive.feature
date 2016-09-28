Feature: New user makes a donation

  Scenario: user can successfully go through a donation process

    Given I open the JG demo page
    When I fill in valid information on Message and Amount page
    And I identify myself with a new email address and password
    And I enter valid card details
    And I enter valid billing address
    Then I land on the review page and I am ready to make the donation