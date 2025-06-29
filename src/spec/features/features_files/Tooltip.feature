@tooltip
Feature: Title of your feature
  I want to use this template for my feature file
  
  Background:
  	Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu

  @tooltipClassic
  Scenario: Displaying a classic tooltip
  	And The user clicks on Tooltip link in the list of features
  	And The user is redirected to Tooltip page "Tooltip"
    When The user hovers over the tooltip element
    Then A tooltip is displayed with the text "Ceci est un tooltip classique"