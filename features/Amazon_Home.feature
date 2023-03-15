Feature: Amazon Home Page Scenario

  @P1
  Scenario: Amazon Shopping Cart
    Given I am on Amazon Home Page
    When I click on Cart Link
    Then I navigate to Shopping Cart Page

  @P2 @setCookies @Test
  Scenario: Validate any Product
    Given  I am on Amazon Home Page
    When I search for 'iphone 11'
    Then I validate at least 100 search items present

  @P30
  Scenario: Advanced Search on Item
    Given I am on Amazon Home Page
    When I advanced Search an item
      | keyword   | exclude     | min | max |
      | iphone 11 | refurbished | 300 | 900 |

  @P300 @setCookies
  Scenario Outline: Search Products Validation
    Given I am on Amazon Home Page
    When I click on "<link>"
    Then I navigated to "<url>" and "<title>" is shown
    Examples:
      | link             | url                                                                                            | title    |
      | Today's Deals    | https://www.amazon.com/gp/goldbox?ref_=nav_cs_gb                                               | Today    |
      | Customer Service | https://www.amazon.com/gp/help/customer/display.html?nodeId=508510&ref_=nav_cs_customerservice | Customer |

