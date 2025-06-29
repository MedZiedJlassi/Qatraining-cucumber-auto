package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.TooltipPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TooltipStepDefinition {
	
	private TooltipPage tooltipPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private Wait wait;


	public TooltipStepDefinition() {
		this.tooltipPage = new TooltipPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
	}

	@Given("The user clicks on Tooltip link in the list of features")
	public void theUserClicksOnTooltipLinkInTheListOfFeatures() {
	    this.seleniumUtils.click(tooltipPage.tooltipLink);
	}
	
	@Given("The user is redirected to Tooltip page {string}")
	public void theUserIsRedirectedToTooltipPage(String string) {
	    this.validations.assertEquals(tooltipPage.titlePage, string);
	}
	
	@When("The user hovers over the tooltip element")
	public void theUserHoversOverTheTooltipElement() {
	    this.seleniumUtils.mouseHover(tooltipPage.classicTooltip);
	}
	
	@Then("A tooltip is displayed with the text {string}")
	public void aTooltipIsDisplayedWithTheText(String string) {
	    Assert.assertEquals(tooltipPage.classicTooltip.getAttribute("data-tooltip"), string);
	}

}
