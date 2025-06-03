package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.DropdownListPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class DropdownListStepDefinition {
	
	private DropdownListPage dropdownListPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private SelectFromListUtils selectFromListUtils;
	private Validations validation;
	private Wait wait;
	
	public DropdownListStepDefinition() {
		this.dropdownListPage = new DropdownListPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.selectFromListUtils = new SelectFromListUtils();
		this.validation = new Validations();
		this.wait = new Wait(Setup.getDriver());
	}
	

	@Given("The user clicks on Dropdown list link in the features list")
	public void theUserClicksOnDropdownListLinkInTheFeaturesList() {
		wait.forPresenceOfElement(Duration.ofSeconds(20), DropdownListPage.dropDonwList, "Dropdown list");
	    this.seleniumUtils.click(DropdownListPage.dropDonwList);
	}

	@Given("The user is redirected to the {string} page")
	public void theUserIsRedirectedToThePage(String pageTitle) {
	    Assert.assertEquals(pageTitle, dropdownListPage.dropDownListPageTitle.getText());
	}
	
	@When("The user clicks on the dropdown list and select an {string} from the list")
	public void theUserClicksOnTheDropdownListAndSelectAnOptionFromTheList(String option) {
	    selectFromListUtils.selectDropDownListByVisibleText(dropdownListPage.dropdownMenu1, option);
	}

	@Then("The name of the selected option appears bellow the dropdown list {string}")
	public void theNameOfTheSelectedOptionAppearsBellowTheDropdownList(String message) {
	    Assert.assertEquals(message, dropdownListPage.dropDownMenuMessage1.getText());
	}
	
	/* Rounded drop-downlist*/
	
	@When("The user clicks on the rounded dropdown list and select an {string} from the list")
	public void theUserClicksOnTheRoundedDropdownListAndSelectAnFromTheList(String option) {
	    selectFromListUtils.selectDropDownListByVisibleText(dropdownListPage.dropdownMenu2, option);
	}
	@Then("The name of the selected option appears bellow the rounded dropdown list {string}")
	public void theNameOfTheSelectedOptionAppearsBellowTheRoundedDropdownList(String message) {
	    Assert.assertEquals(message, dropdownListPage.dropDownMenuMessage2.getText());
	}

	/* Multiselect drop-downlist*/
	

	@When("The user clicks on the dropdown list and select only one option {string} from the list")
	public void theUserClicksOnTheDropdownListAndSelectOnlyOneOptionFromTheList(String option) {
//	    selectFromListUtils.findCheckboxByLabel(option).click();
		seleniumUtils.scrollToTheBottom();
	    seleniumUtils.clickOnElementUsingActions(selectFromListUtils.findCheckboxByLabel(option));
	}
	@Then("The name of the selected option appears bellow the multiselect dropdown list {string}")
	public void theNameOfTheSelectedOptionsAppearsBellowTheMultiselectDropdownList(String message) {
		seleniumUtils.moveToTheElement(dropdownListPage.dropDownMenuMessage3);
	    Assert.assertEquals(message, dropdownListPage.dropDownMenuMessage3.getText());
	}


	@When("The user clicks on the dropdown list and select two options from the list")
	public void theUserClicksOnTheDropdownListAndSelectTwoOptionsFromTheList() {
		validation.isElementSelected(dropdownListPage.checkBox2);
	    validation.isElementSelected(dropdownListPage.checkBox4);
	    this.seleniumUtils.click(dropdownListPage.checkBox2);
	    this.seleniumUtils.click(dropdownListPage.checkBox4);
	}
	
	@Then("The name of the selected options appears bellow the dropdown list {string}")
	public void theNameOfTheSelectedOptionsAppearsBellowTheDropdownList(String message) {
	    Assert.assertEquals(message, dropdownListPage.dropDownMenuMessage3.getText());
	}


	@When("The user clicks on the dropdown multiselect list and does not select any option")
	public void theUserClicksOnTheDropdownMultiselectlistAndDoesNotSelectAnyOption() throws InterruptedException {
		seleniumUtils.scrollToTheBottom();
		selectFromListUtils.unSelectCheckboxByAttrType();
	}
	@Then("No message is displayed below the drop-down list")
	public void noMessageIsDisplayedBelowTheDropDownList() {
		seleniumUtils.scrollToTheBottom();
	    Assert.assertFalse(dropdownListPage.dropDownMenuMessage3.isDisplayed());
	}


	@When("The user clicks on the dropdown multiselect list select all options")
	public void theUserClicksOnTheDropdownMultiselectListSelectAllOptions() {
	    seleniumUtils.scrollToTheBottom();
	    selectFromListUtils.selectCheckboxByAttrType();
	}
	
	
	@Then("The name of the selected options is displayed below the drop-down list {string}")
	public void theNameOfTheSelectedOptionsIsDisplayedBelowTheDropDownList(String string) {
		seleniumUtils.scrollToTheBottom();
		Assert.assertEquals(string, dropdownListPage.dropDownMenuMessage3.getText());
	}

}
