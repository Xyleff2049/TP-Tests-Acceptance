Feature: Pub

  Background: A pub
    Given Mr Pignon and Mr Leblanc go to Le Juste which is a cocktail pub
    Given There's only 10 seats in the pub

  Scenario: First story
    When There's 9 persons in the pub already
    Then They are denied entry

  Scenario: Second story
    When There's 8 persons in the pub already
    Then They sit
    Then Another person can't get in
    When They each order a cocktail
    When Mr Leblanc pays the whole
    Then Mr Pignon is happy

  Scenario: Third story
    When There's 3 persons in the pub already
    Then They sit
    When They each order a cocktail
    When They pay separately
    When They each order a cocktail
    When Mr Leblanc pays the whole
    Then Mr Pignon is sad
