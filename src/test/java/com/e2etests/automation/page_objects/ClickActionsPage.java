package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class ClickActionsPage {
	
	/*Double Click*/
	
	@FindBy(how = How.XPATH, using = "//a[text()='Fonctionnalités']")
	public static WebElement fonctionnalitesLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Double Click']")
	public static WebElement doubleClickLink;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement doubleClickPageTitle;
	
	@FindBy(how = How.ID, using = "double-click-btn")
	public static WebElement doubleClickBtn;
	
	@FindBy(how = How.ID, using = "success-message")
	public static WebElement successMessage;
	
	/*Right Click*/
	
	@FindBy(how = How.XPATH, using = "//a[text()='Right Click']")
	public static WebElement rightClickLink;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement rightClickPageTitle;
	
	@FindBy(how = How.ID, using = "right-click-button")
	public static WebElement rightClickBtn;
	
	public ClickActionsPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

}
