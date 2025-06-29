@placeholder
Feature: Title of your feature
  I want to use this template for my feature file
  
  Background:
  	Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu

  @tests-placeholder
  Scenario: Retrieve placeholder text from input field
  	And The user clicks on Placeholder link in the feature list
  	And The user is redirected to placeholder page "Placeholder"
    When The user selects the input and retrieves the placeholder text
    Then The retieved text must be equal to "Votre texte ici..."
