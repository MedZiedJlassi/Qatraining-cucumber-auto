package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.Setup;

public class DropdownListPage {
	
	@FindBy(how = How.XPATH, using = "//a[text()='Dropdown list']")
	public static WebElement dropDonwList;
	
	@FindBy(how = How.TAG_NAME, using = "h1")
	public static WebElement dropDownListPageTitle;

	@FindBy(how = How.ID, using = "dropdown-menu")
	public static WebElement dropdownMenu1;
	
	@FindBy(how = How.ID, using = "dropdown-menu-message")
	public static WebElement dropDownMenuMessage1;
	
	@FindBy(how = How.ID, using = "rounded-dropdown")
	public static WebElement dropdownMenu2;
	
	@FindBy(how = How.ID, using = "rounded-dropdown-message")
	public static WebElement dropDownMenuMessage2;
	
	@FindBy(how = How.ID, using ="multiselect-dropdown")
	public static WebElement dropDownMenu3;
	
	@FindBy(how = How.XPATH, using ="//input[@value='Option 1']")
	public static WebElement checkBox1;
	
	@FindBy(how = How.XPATH, using ="//input[@value='Option 2']")
	public static WebElement checkBox2;
	
	@FindBy(how = How.XPATH, using ="//input[@value='Option 3']")
	public static WebElement checkBox3;
	
	@FindBy(how = How.XPATH, using ="//input[@value='Option 4']")
	public static WebElement checkBox4;
	
	@FindBy(how = How.XPATH, using ="//input[@value='Option 5']")
	public static WebElement checkBox5;
	
	@FindBy(how = How.ID, using = "multiselect-output")
	public static WebElement dropDownMenuMessage3;
	
	public DropdownListPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
}
