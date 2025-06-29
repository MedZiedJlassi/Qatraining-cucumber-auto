@tag
Feature: Validate the working ok copy paste action
  Check that copy paste actions can be performed correctly
  
  Background: 
		Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu

  @copyAndPaste
  Scenario: The user copies and pastes text
    And The user clicks on cpoy paste link in the feature list
    And The user is redirected to Copy and Paste page "COPY AND PASTE"
    When The user clicks in Texte à copier field
    And the user writes text "Hello test"
    And The user selects all the text in the Texte à copier field and copies it
    And The user clicks in paste area and paste the text
    Then A popup is displayed with a confirmation message "Texte copié dans le presse-papier !"
