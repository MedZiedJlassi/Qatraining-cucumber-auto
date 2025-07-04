package com.e2etests.automation.utils;

import org.junit.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.Scenario;

/**
 * This class is used to perform various kinds of validations in the test cases.
 */
public class Validations extends BasePage {

	/** testCaseStatus the status of the test case. */
	boolean testCaseStatus = true;

	/** test status. */
	boolean testStatus;

	/** test screenshot dir. */
	private String testScreenshotDir;

	private WebDriver driver;

	/**
	 * Instanciation de assertions.
	 */
	public Validations() {
		super();
		this.driver = Setup.getDriver();
	}

	/**
	 * method verify element is present.
	 */
	public void assertEquals(WebElement element, String text) {
		String text1 = element.getText();
		Assert.assertEquals(text1, text);

	}

	public void assertTrue(WebElement element, String text) {
		String text1 = element.getText();
		Assert.assertTrue(text1.contains(text));

	}

	/**
	 * method verify whether element is present on screen.
	 *
	 * @param targetElement element to be present
	 * @return true if element is present else throws exception
	 */
	public Boolean isElementPresent(By targetElement) {
		return Setup.getDriver().findElements(targetElement).size() > 0;
	}

	/**
	 * methode Checks if is element displayed.
	 *
	 * @param element element web
	 * @return boolean
	 */
	public Boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	/**
	 * methode Checks if is element selected
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementSelected(WebElement element) {
		return element.isSelected();
	}

	/**
	 * methode Checks if is element enabled.
	 *
	 * @param element
	 * @return boolean
	 */
	public Boolean isElementEnabled(WebElement element) {
		return element.isEnabled();
	}

	/**
	 * method verify whether element is not present on screen.
	 *
	 * @param targetElement element not to be present
	 * @return true if element is not present else throws exception
	 */
	public Boolean isElementNotPresent(By targetElement) {
		return Setup.getDriver().findElements(targetElement).size() == 0;
	}

	/**
	 * method to take screenshot.
	 *
	 * @return path where screenshot has been saved
	 */
	public String screenShot() {
		String screenshotPath = "screenshot"
				+ new SimpleDateFormat("MM-dd-yyyy-HH-mm-ss", Locale.FRANCE).format(new GregorianCalendar().getTime())
				+ ".png";

		log.info(screenshotPath);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(testScreenshotDir + screenshotPath));
		} catch (IOException e) {
			log.info("Exception: ", e);
			screenshotPath = "";
		}
		return screenshotPath;
	}
	
	/**
	 * method to check Alert text and take screenshot
	 * 
	 */
	public void verifyAlertText(String expectedText) {
		
		Scenario scenario = ScenarioContext.getScenario();
	    try {
	        Alert alert = Setup.getDriver().switchTo().alert();
	        String actualText = alert.getText();

	        if (!actualText.equals(expectedText)) {
	            // Capture l’écran (du contexte général, pas de l'alerte directement)
	            byte[] screenshot = ((TakesScreenshot) Setup.getDriver()).getScreenshotAs(OutputType.BYTES);
	            scenario.attach(screenshot, "image/png", "Alerte texte incorrect : " + actualText);
	        }

//	        alert.accept(); // ou alert.dismiss() selon ton besoin

	    } catch (NoAlertPresentException e) {
	    	scenario.attach("Aucune alerte présente.".getBytes(), "text/plain", "Erreur");
	    } catch (Exception e) {
	    	scenario.attach(("Erreur inattendue : " + e.getMessage()).getBytes(), "text/plain", "Exception");
	    }
	}
	
	/**
	 * method Verif PDF text file.
	 *
	 * @param text
	 * @param pdfPath
	 * @return true, si c'est vrai
	 * @throws IOException Signal qu'une execption de type I/O s'est produite.
	 */
	public boolean verifyTextInFile(String text, String pdfPath) throws IOException {

		boolean exist = false;
		File file = new File(pdfPath);
		FileInputStream fis = new FileInputStream(file);
		PDFParser parser = new PDFParser(fis);

		parser.parse();

		COSDocument cosDoc = parser.getDocument();
		PDDocument pdDoc = new PDDocument(cosDoc);
		PDFTextStripper strip = new PDFTextStripper();
		String data = strip.getText(pdDoc);

		exist = data.contains(text);

		cosDoc.close();
		pdDoc.close();

		log.info("Text Found on the pdf File...");
		return exist;

	}

	/**
	 * methode Column contains value.
	 *
	 * @param pathToFile
	 * @param columnIndex
	 * @param targetValue
	 * @return true, si c'est vrai
	 * @throws IOException Signal qu'une execption de type I/O s'est produite.
	 */
	public boolean columnContainsValue(String pathToFile, int columnIndex, String targetValue) throws IOException {

		Reader in = new FileReader(pathToFile);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);

		for (CSVRecord record : records) {
			String rowValue = record.get(columnIndex);
			if (targetValue.equals(rowValue))
				return true;
		}
		return false;
	}

	/**
	 * methode Check field is empty.
	 * 
	 * @param elementAttr
	 */
	public void checkFieldIsEmpty(WebElement elementAttr) {
		WebElement inputText = elementAttr;
		String text = inputText.getAttribute("value");

		if (text.isEmpty()) {
			log.info("input box is empty");
		}
	}
	
	public void checkUrlChange(String url) {
		String actualUrl = Setup.getDriver().getCurrentUrl();
		if (actualUrl.equals(url)) {
			log.info("The page did not change");
		} else {
			log.info("The page has changed");
		}
		log.info("Actual URL is : " + actualUrl);

	}
	
    /**
    * Assert command for checking the url in selenium webdriver
    * @param string URL
    */
   public void checkChangedURL(String expectedURL)
   {
   	String URL = driver.getCurrentUrl();
   	Assert.assertEquals(URL, expectedURL);
   }

}
