package com.e2etests.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.Setup;

public class LoginPage {
	
	@FindBy(how = How.XPATH, using = "//a[text()='Fonctionnalités']")
	public static WebElement fonctionnalitesLink;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Login Page']")
	public static WebElement loginPageLink;
	
	@FindBy(how = How.ID, using = "username")
	public static WebElement username;
	
	@FindBy(how = How.ID, using = "password")
	public static WebElement password;
	
	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Se connecter']" )
	public static WebElement seConnecterBtn;
	
	public LoginPage() {
		PageFactory.initElements(Setup.getDriver(), this);
	}
}
