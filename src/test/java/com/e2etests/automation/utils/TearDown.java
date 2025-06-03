package com.e2etests.automation.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class TearDown {
	
	/**
	 * This method is used to close browser. This method is called after the
	 * invocation of each test method in given class.
	 *
	 * @After Methods annotated with @After execute after every scenario.
	 */
	
	@After
//	public void quitDriver(Scenario scenario) {
//		if(scenario.isFailed()) {
//			final byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", "screenshot");
//			Allure.addAttachment("Failed Setp", new ByteArrayInputStream(screenshot));
//		}
	public void quitDriver(Scenario scenario) {
	    WebDriver driver = Setup.getDriver();

	    if (scenario.isFailed()) {
	        try {
	            // 🛑 1. Vérifier s’il y a une alerte ouverte
	            try {
	                Alert alert = driver.switchTo().alert();
	                String alertText = alert.getText();

	                // 💬 Ajouter le texte de l'alerte dans le rapport
	                scenario.attach(("Texte de l'alerte : " + alertText).getBytes(), "text/plain", "Texte Alerte");

	                // 📸 Prendre le screenshot AVANT de fermer l’alerte
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "Alerte visible à l'écran");

	                // ✔️ Fermer l’alerte après la capture
	                alert.accept(); // ou .dismiss() selon ton cas

	            } catch (NoAlertPresentException e) {
	                // 🤷 Pas d’alerte → capture normale
	                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	                scenario.attach(screenshot, "image/png", "Screenshot");
	            }

	        } catch (Exception e) {
	            scenario.attach(("Erreur lors de la capture : " + e.getMessage()).getBytes(),
	                    "text/plain", "Erreur capture screenshot");
	        }
	    }
		
		Setup.getDriver().quit();
		
		Setup.LOGGER.info("Scenario : "+scenario.getName()+" finished.status "+scenario.getStatus());
	}

}