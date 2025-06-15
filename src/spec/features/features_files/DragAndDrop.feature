Feature: handling drag and drop function
  check that drag and drop function works correctly
  
  Background:
  	Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu

  @DragAndDrop
  Scenario: The user drags an element and drops it into another element
  	And The user clicks on drag and drop link in the feature list
  	And The user is redirected to the Drag and Drop "Drag and Drop"
    When The user drags the drg item "Faites glisser" and drops it in the drop zone "Déposez ici"
    Then The popup message is displayed "Déposé avec succès !"
