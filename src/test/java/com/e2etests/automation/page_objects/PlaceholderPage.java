package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class PlaceholderPage {
	
	@FindBy(how = How.XPATH, using = "//a[text()='Placeholder']")
	public static WebElement placeholderLink;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement pageTitle;
	
	@FindBy(how = How.ID, using = "modern-input")
	public static WebElement placeholderInput;

	public PlaceholderPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
	
}
