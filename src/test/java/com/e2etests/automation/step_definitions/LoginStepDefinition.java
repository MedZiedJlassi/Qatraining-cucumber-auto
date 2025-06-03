package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_objects.LoginPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.ScenarioContext;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinition {
	
	private LoginPage loginPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private Scenario scenario;
	
	public LoginStepDefinition() {
		this.loginPage = new LoginPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.validations = new Validations();
		this.scenario = ScenarioContext.getScenario();
	}
	
	@Given("The user is connected to the qatrainig web site")
	public void theUserIsConnectedToTheQatrainigWebSite() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
	}
	
	@When("The user enters valid username {string} into username field")
	public void theUserEntersValidIntoUsernameField(String userNameText) {
		seleniumUtils.clearField(LoginPage.username);
		seleniumUtils.writeText(LoginPage.username, userNameText);
	}
	
	@When("The user enters valid password {string} into password field")
	public void theUserEntersValidIntoPasswordField(String passwordText) {
	    seleniumUtils.clearField(LoginPage.password);
	    seleniumUtils.writeText(LoginPage.password, passwordText);
	}
	
	@When("The user clicks on Se connecter button")
	public void theUserClicksOnSeConnecterButton() {
	   seleniumUtils.click(LoginPage.seConnecterBtn);
	}
	
	@Then("The user should be logged in successfully {string}")
	public void theUserShouldBeLoggedInSuccessfully(String alertText) {
	    String actualAlertText = seleniumUtils.getAlertText();
	    Assert.assertEquals(alertText, actualAlertText);
	}
	
	/*Login_Fail*/

	@Given("The user clicks on Fonctionnalités link in the navbar menu")
	public void theUserClicksOnFonctionnalitésLinkInTheNavbarMenu() {
	    seleniumUtils.click(LoginPage.fonctionnalitesLink);
	}
	@Given("The user right clicks on Login page link in the features list")
	public void theUserRightClicksOnLoginPageLinkInTheFeaturesList() {
	    seleniumUtils.click(LoginPage.loginPageLink);
	}
	@When("The user enters valid paswword {string} into password field")
	public void theUserEntersValidPaswwordIntoPasswordField(String password) {
	    seleniumUtils.writeText(LoginPage.password, password);
	}
	@Then("An alert popup with the error message {string} should appear")
	public void anAlertPopupWithTheErrorMessageShouldAppear(String message) {
	    Assert.assertEquals(message, seleniumUtils.getAlertText());
	}

}
