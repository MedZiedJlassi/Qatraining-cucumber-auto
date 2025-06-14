@scroll
Feature: Handling scrolling function
  Check that scrolling function works correctly
  
  Background: 
  	Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu
    And The user clicks on scroll link in the feature list

  @scroll-down
  Scenario: user scrolls down
    When The user accesses the scroll page "Scroll"
    And The user scrolls down
    Then The message "Vous avez effectué un scroll en bas de page !" is display