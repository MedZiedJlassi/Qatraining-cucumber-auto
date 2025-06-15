package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class DragAndDropPage {
	
	@FindBy(how = How.XPATH, using = "//a[text() = 'Drag and Drop']")
	public static WebElement dragAndDropLink;

	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement pageTitle;
	
	@FindBy(how = How.ID, using = "drag-item")
	public static WebElement dragItem;
	
	@FindBy(how = How.ID, using = "drop-zone")
	public static WebElement dropZone;
	
	@FindBy(how = How.ID, using = "success-popup")
	public static WebElement successPopup;
	
	public DragAndDropPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
}
