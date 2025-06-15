package com.e2etests.automation.step_definitions;

import com.e2etests.automation.page_objects.DragAndDropPage;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Setup;
import com.e2etests.automation.utils.Validations;
import com.e2etests.automation.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class DragAndDropStepDefeniton {
	
	private DragAndDropPage dragAndDropPage;
	private ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private Wait wait;
	
	public DragAndDropStepDefeniton() {
		this.dragAndDropPage = new DragAndDropPage();
		this.configFileReader = new ConfigFileReader();
		this.seleniumUtils = new SeleniumUtils();
		this.validations = new Validations();
		this.wait = new Wait(Setup.getDriver());
	}
	
	
	@Given("The user clicks on drag and drop link in the feature list")
	public void theUserClicksOnDragAndDropLinkInTheFeatureList() {
	    this.seleniumUtils.click(dragAndDropPage.dragAndDropLink);
	}
	
	@Given("The user is redirected to the Drag and Drop {string}")
	public void theUserIsRedirectedToTheDragAndDrop(String string) {
	    this.validations.assertTrue(dragAndDropPage.pageTitle, string);
	}
	
	@When("The user drags the drg item {string} and drops it in the drop zone {string}")
	public void theUserDragsTheDrgItemAndDropsItInTheDropZone(String dragItem, String dropZone ) {
	    this.seleniumUtils.dragAndDrop(Setup.getDriver(), dragAndDropPage.dragItem, dragAndDropPage.dropZone);
	}
		
	@Then("The popup message is displayed {string}")
	public void thePopupMessageIsDisplayed(String string) {
	    this.validations.isElementEnabled(dragAndDropPage.successPopup);
	    this.validations.assertEquals(dragAndDropPage.successPopup, string);
	}




}
