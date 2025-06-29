package com.e2etests.automation.step_definitions;

import java.time.Duration;

import com.e2etests.automation.page_objects.CopyPastePage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CopyPasteStepDefenition {
	
	private CopyPastePage copyPastePage;
	private ConfigFileReader configFileReder;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private Wait wait;
	
	public CopyPasteStepDefenition() {
		this.configFileReder = new ConfigFileReader();
		this.copyPastePage = new CopyPastePage();
		this.seleniumUtils = new SeleniumUtils();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
		
	}
	
	@Given("The user clicks on cpoy paste link in the feature list")
	public void theUserClicksOnCpoyPasteLinkInTheFeatureList() {
		this.wait.forPresenceOfElement(Duration.ofSeconds(20), copyPastePage.copyPasteLink, "Copy Paste");
	    this.seleniumUtils.click(copyPastePage.copyPasteLink);
	}
	
	@Given("The user is redirected to Copy and Paste page {string}")
	public void theUserIsRedirectedToCopyAndPastePage(String string) {
	    this.validations.assertEquals(copyPastePage.pageTitle, string);
	}

	@When("The user clicks in Texte à copier field")
	public void theUserClicksInTexteÀCopierField() {
	    this.seleniumUtils.click(copyPastePage.copyField);
	}
	
	@When("the user writes text {string}")
	public void theUserWritesText(String string) {
	    this.seleniumUtils.writeText(copyPastePage.copyField, string);
	}
	
	@When("The user selects all the text in the Texte à copier field and copies it")
	public void theUserSelectsAllTheTextInTheTexteÀCopierFieldAndCopiesIt() {
	    this.seleniumUtils.copyText(copyPastePage.copyField);
	}
	
	@When("The user clicks in paste area and paste the text")
	public void theUserClicksInPasteAreaAndPasteTheText() {
	    this.seleniumUtils.click(copyPastePage.pasteArea);
	    this.seleniumUtils.pasteText(copyPastePage.pasteArea);
	}
	
	@Then("A popup is displayed with a confirmation message {string}")
	public void aPopupIsDisplayedWithAConfirmationMessage(String string) {
	    
	}

}
