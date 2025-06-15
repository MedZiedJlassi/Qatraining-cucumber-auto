@scroll
Feature: Handling scrolling function
  Check that scrolling function works correctly
  
  Background: 
  	Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu
    

  @scroll-down
  Scenario: user scrolls down
  	And The user clicks on scroll link in the feature list
    And The user accesses the scroll page "Scroll"
    When The user scrolls down
    Then The message "Vous avez effectué un scroll en bas de page !" is display