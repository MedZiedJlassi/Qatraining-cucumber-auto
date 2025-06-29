package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class CopyPastePage {
	
	@FindBy(how = How.XPATH, using = "//a[text()='Copy Paste']")
	public static WebElement copyPasteLink;
	
	@FindBy(how = How.TAG_NAME , using = "h1")
	public static WebElement pageTitle;
	
	@FindBy(how = How.ID, using = "copy-field")
	public static WebElement copyField;
	
	@FindBy(how = How.ID, using = "paste-area")
	public static WebElement pasteArea;
	
	public CopyPastePage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

}
