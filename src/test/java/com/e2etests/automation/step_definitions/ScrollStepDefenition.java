package com.e2etests.automation.step_definitions;

import java.time.Duration;

import com.e2etests.automation.page_objects.ScrollPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SelectFromListUtils;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ScrollStepDefenition {
	
	private ScrollPage scrollPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private SelectFromListUtils selectFromListUtils;
	private Validations validation;
	private Wait wait;
	
	public ScrollStepDefenition() {
		this.scrollPage = new ScrollPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.selectFromListUtils = new SelectFromListUtils();
		this.validation = new Validations();
		this.wait = new Wait(Setup.getDriver());
	}
	

	@Given("The user clicks on scroll link in the feature list")
	public void theUserClicksOnScrollLinkInTheFeatureList() {
	   wait.forPresenceOfElement(Duration.ofSeconds(20), scrollPage.scrollLink, "Scroll");
	   this.seleniumUtils.click(scrollPage.scrollLink);
	}
	
	@When("The user accesses the scroll page {string}")
	public void theUserAccessesTheScrollPage(String string) {
	    Assert.assertEquals(string, scrollPage.pageTitle.getText());
	}
	
	@When("The user scrolls down")
	public void theUserScrollsDown() {
	    this.seleniumUtils.scrollToTheBottom();
	}
	
	@Then("The message {string} is display")
	public void theMessageIsDisplay(String string) {
		this.validation.isElementDisplayed(scrollPage.scrollMessage);
		Assert.assertEquals(string, scrollPage.scrollMessage.getText());
	}




}
