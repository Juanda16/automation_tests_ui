#Author Juan Arismendy
#Language: en

Feature: Loan Simulator

  Scenario Outline: Calculate the monthly payment of a loan
    Given I am in the loan simulator page
    When I enter the loan amount <loan_amount>
    And I choose the number of payments <number_of_payments>
    Then I can see the monthly payment higher than <monthly_payment>

    Examples:
      | loan_amount | number_of_payments | monthly_payment |
      |     1000000 | "36 meses"         |           10000 |
      |     1000000 | "48 meses"         |           10000 |
      |     1000000 | "60 meses"         |           10000 |
      |     1000000 | "72 meses"         |           10000 |

  Scenario Outline: Calculate the monthly payment of a loan with a value lower than 400000
    Given I am in the loan simulator page
    When I enter the loan amount <loan_amount>
    And I choose the number of payments <number_of_payments>
    Then I can see the minimun ammount required error message

    Examples:
      | loan_amount | number_of_payments |
      |           1 | "36 meses"         |
      |      200000 | "60 meses"         |
      |      300000 | "72 meses"         |

  Scenario Outline: Calculate the monthly payment of a loan with a value higher than 400000 using a model
    Given I am in the loan simulator page
    When I enter the loan model <loan_amount> and <number_of_payments>
    Then I can see the monthly payment higher than <monthly_payment>

    Examples:
      | loan_amount | number_of_payments | monthly_payment |
      |      500000 | "36 meses"         |           10000 |
      |      600000 | "48 meses"         |           10000 |
      |      700000 | "60 meses"         |           10000 |
      |      800000 | "72 meses"         |           10000 |
