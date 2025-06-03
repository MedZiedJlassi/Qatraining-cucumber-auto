#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@DropdownList
Feature: handling drop-down lists
  	Check that drop-down list works correctly

  Background: 
    Given The user is connected to the qatrainig web site
    And The user clicks on Fonctionnalités link in the navbar menu
    And The user clicks on Dropdown list link in the features list
    And The user is redirected to the "DROPDOWN LIST" page

  @ClassicDropdownList @checkbox @single @fonctionnel
  Scenario Outline: User selects an option from the classic dropdown list
    When The user clicks on the dropdown list and select an <Option> from the list
    Then The name of the selected option appears bellow the dropdown list <message>

    Examples: 
      | Option     | message                            |
      | "Option 1" | "Vous avez sélectionné : Option 1" |
      | "Option 2" | "Vous avez sélectionné : Option 2" |
      | "Option 3" | "Vous avez sélectionné : Option 3" |

  @RoundedDropdownList @checkbox @single @fonctionnel
  Scenario Outline: User selects only one option from the rounded dropdown list
    When The user clicks on the rounded dropdown list and select an <Option> from the list
    Then The name of the selected option appears bellow the rounded dropdown list <message>

    Examples: 
      | Option     | message                            |
      | "Option A" | "Vous avez sélectionné : Option A" |
      | "Option B" | "Vous avez sélectionné : Option B" |
      | "Option C" | "Vous avez sélectionné : Option C" |

  @DropdownMultiselect @checkbox @single @fonctionnel
  Scenario Outline: User selects only one option from the dropdown multiselect list
    When The user clicks on the dropdown list and select only one option <Option> from the list
    Then The name of the selected option appears bellow the multiselect dropdown list <message>

    Examples: 
      | Option     | message                            |
      | "Option 1" | "Vous avez sélectionné : Option 1" |
      | "Option 2" | "Vous avez sélectionné : Option 2" |
      | "Option 3" | "Vous avez sélectionné : Option 3" |
      | "Option 4" | "Vous avez sélectionné : Option 4" |
      | "Option 5" | "Vous avez sélectionné : Option 5" |

  @DropdownMultiselect @checkbox @multiple @fonctionnel
  Scenario: User selects multiple options from the dropdown list
    When The user clicks on the dropdown list and select two options from the list
    Then The name of the selected options appears bellow the dropdown list "Vous avez sélectionné : Option 2, Option 4"

  @DropdownMultiselect @checkbox @empty @boundary
  Scenario: User does not select any option from the dropdown list
    When The user clicks on the dropdown multiselect list and does not select any option
    Then No message is displayed below the drop-down list

  @DropdownMultiselect @checkbox @all @boundary
  Scenario: User select all options from the dropdown list
    When The user clicks on the dropdown multiselect list select all options
    Then The name of the selected options is displayed below the drop-down list "Vous avez sélectionné : Option 1, Option 2, Option 3, Option 4, Option 5"
