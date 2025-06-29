package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class TooltipPage {

	@FindBy(how = How.XPATH, using = "//a[text()='Tooltip']")
	public static WebElement tooltipLink;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement titlePage;
	
	@FindBy(how = How.CLASS_NAME, using = "tooltip-classic")
	public static WebElement classicTooltip;
	
	@FindBy(how = How.CLASS_NAME, using = "tooltip-float")
	public static WebElement floatTooltip;
	
	@FindBy(how = How.CLASS_NAME, using = "tooltip-triangle")
	public static WebElement triangelTooltip;
	
	@FindBy(how = How.CLASS_NAME, using = "tooltip-border")
	public static WebElement borderTooltip;
	
	public TooltipPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}

}
