@login
Feature: Validate the working of Login functionality
  Verifies that users can log in with valid credentials and are blocked from logging in with invalid ones, 
  ensuring proper redirection and error handling.

  Background: 
    Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu
    And The user right clicks on Login page link in the features list

  @login_success
  Scenario: User should be able to log in with valid credentials
    When The user enters valid username "Zied" into username field
    And The user enters valid password "Welcome@2025" into password field
    And The user clicks on Se connecter button
    Then The user should be logged in successfully "Connexion réussie !"

  @loginWithAnEmptyInput
  Scenario Outline: Login with an empty input (Username or password)
    When The user enters valid username <username> into username field
    And The user enters valid paswword <password> into password field
    And The user clicks on Se connecter button
    Then An alert popup with the error message <message> should appear

    Examples: 
      | username | password       | message                             |
      | "Zied"   | ""             | "Veuillez remplir tous les champs." |
      | ""       | "Welcome@2025" | "Veuillez remplir tous les champs." |
      | ""       | ""             | "Veuillez remplir tous les champs." |
