package com.e2etests.automation.step_definitions;

import org.junit.Assert;
import com.e2etests.automation.page_objects.ClickActionsPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClickActionsStepDefinition {
	
	private ClickActionsPage clickActionsPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	
	public ClickActionsStepDefinition() {
		this.clickActionsPage = new ClickActionsPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
	}

	
	@Given("The user clicks on Double Click link in the features list")
	public void theUserClicksOnDoubleClickLinkInTheFeaturesList() {
	    seleniumUtils.click(ClickActionsPage.doubleClickLink);
	    String pageTitleTxt = "DOUBLE CLICK";
	    Assert.assertEquals(pageTitleTxt, clickActionsPage.doubleClickPageTitle.getText());
	}
	
	@When("User double clicks on Double-cliquez ici button")
	public void userDoubleClicksOnDoubleCliquezIciButton() {
	    seleniumUtils.doubleclickOnElementUsingActionsWebElement(ClickActionsPage.doubleClickBtn);
	}
	
	@Then("A confirmation message appears {string}")
	public void aConfirmationMessageAppears(String confirmMessageTxt) {
//		String confirmMessageTxt = "Double clic détecté avec succès !";
	    Assert.assertEquals(confirmMessageTxt, ClickActionsPage.successMessage.getText());
	}

/*Right Click*/

	@Given("User right clicks on Right Click link in the features list")
	public void userRightClicksOnRightClickLinkInTheFeaturesList() {
	    seleniumUtils.click(ClickActionsPage.rightClickLink);
	}
	
	@Given("User is redirected to {string} page")
	public void userIsRedirectedToPage(String rightClickPageTitle) {
	    Assert.assertEquals(rightClickPageTitle, ClickActionsPage.rightClickPageTitle.getText());
	}
	
	@When("User right clicks on Cliquez-droit ici button")
	public void userRightClicksOnDoubleCliquezButton() {
	    seleniumUtils.rightClickOnElementUsingActions(ClickActionsPage.rightClickBtn);
	}




}
