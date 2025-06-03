@ClickActions
Feature: Validate the working of Click actions
  Check that click actions can be performed correctly
  
  Background: 
		Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu

  @DoubleClick
  Scenario: User performe a double click
  	And The user clicks on Double Click link in the features list
    When User double clicks on Double-cliquez ici button
    Then A confirmation message appears "Double clic détecté avec succès !"

  @RightClick
  Scenario: User performe a right click
    And User is redirected to "Right Click" page
    When User right clicks on Cliquez-droit ici button
    Then A confirmation message appears "Clic droit détecté avec succès !"
