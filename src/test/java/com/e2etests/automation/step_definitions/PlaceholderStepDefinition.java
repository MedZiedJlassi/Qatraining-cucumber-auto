 	package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.PlaceholderPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceholderStepDefinition {
	
	private PlaceholderPage placeholderPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private Wait wait;
	
	public PlaceholderStepDefinition() {
		this.placeholderPage = new PlaceholderPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
	}
	

	@Given("The user clicks on Placeholder link in the feature list")
	public void theUserClicksOnPlaceholderLinkInTheFeatureList() {
	    this.seleniumUtils.click(placeholderPage.placeholderLink);
	}
	
	@Given("The user is redirected to placeholder page {string}")
	public void theUserIsRedirectedToPlaceholderPage(String string) {
	    this.validations.assertEquals(placeholderPage.pageTitle, string);
	}
	
	@When("The user selects the input and retrieves the placeholder text")
	public void theUserSelectsTheInputAndRetrievesThePlaceholderText() {
	    this.placeholderPage.placeholderInput.getAttribute("placeholder");
	    Assert.assertFalse(placeholderPage.placeholderInput.getAttribute("placeholder").isBlank());
	}
	
	@Then("The retieved text must be equal to {string}")
	public void theRetievedTextMustBeEqualTo(String string) {
		Assert.assertEquals(placeholderPage.placeholderInput.getAttribute("placeholder"), string);
	}
	
	
	
}
