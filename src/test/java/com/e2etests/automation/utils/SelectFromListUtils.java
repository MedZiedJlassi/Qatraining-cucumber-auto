package com.e2etests.automation.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class is used to select value from dropdown list.
 */
public class SelectFromListUtils {

	/**
	 * This method is used to select value from dropdown list by visible text. Here
	 * we need to have two parameters locator type and string text.
	 * 
	 * @param element element to be selected
	 * @param text    The exactly displayed text of a particular option
	 */
	public void selectDropDownListByVisibleText(WebElement element, String text) {
		Select dropDownList = new Select(element);
		dropDownList.selectByVisibleText(text);
	}

	/**
	 * This method is used to select value from dropdown list by index. Here we need
	 * to have two parameters locator type and option index.
	 * 
	 * @param element element to be selected
	 * @param index   the index of the option to be selected
	 */
	public void selectDropDownListByIndex(WebElement element, int index) {
		Select dropDownList = new Select(element);
		dropDownList.selectByIndex(index);
	}

	/**
	 * This method is used to select value from dropdown list by value. Here we need
	 * to have two parameters locator type and string text.
	 * 
	 * @param element element to be selected
	 * @param value   value of the “value” attribute
	 */
	public void selectDropDownListByValue(WebElement element, String value) {
		Select dropDownList = new Select(element);
		dropDownList.selectByValue(value);
	}
	
	/*********************************************************************************************************************************/

	public WebElement findCheckboxByForAttribute(String labelText) {
		// On cherche le label qui contient le texte souhaité
		WebElement label = Setup.getDriver().findElement(By.xpath("//label[contains(text(), '" + labelText + "')]"));

		// Récupère la valeur de l'attribut 'for' du label
		String forAttribute = label.getAttribute("for");

		// Ensuite, on trouve l'input checkbox correspondant à cet 'id'
		return Setup.getDriver().findElement(By.xpath(forAttribute));
	}

	public WebElement findCheckboxByLabel(String labelText) {
		// Cherche le label contenant le texte
		WebElement label = Setup.getDriver().findElement(By.xpath("//label[contains(text(), '" + labelText + "')]"));

		// Puis trouve l'input à l'intérieur du label
		return label.findElement(By.xpath(".//input[@type='checkbox']"));
	}
	
	
	/**
	 * This method is used to unselect a checkbox from multiselect list by Attr. Here we need
	 * 
	 */	
	public void selectCheckboxByAttrType() {
		List<WebElement> checkboxes = Setup.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkbox : checkboxes) {
			if(checkbox.isSelected()) {
				checkbox.click();
			}else {
				checkbox.click();
			}
		}
	}
	
	/**
	 * This method is used to unselect a checkbox from multiselect list by Attr. Here we need
	 * 
	 */
	public void unSelectCheckboxByAttrType() {
		List<WebElement> checkboxes = Setup.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checkbox : checkboxes) {
			if(!checkbox.isSelected()) {
				continue;
			}else {
				checkbox.click();
			}
		}
	}

	public void dropdownMultiselectCheckBoxOption(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
		
		System.out.println(rows);

		for (Map<String, String> row : rows) {

			String option = row.get("Options");
			String action = row.get("Action");

			WebElement checkbox = findCheckboxByLabel(option);

			if ("Cocher".equalsIgnoreCase(action)) {
				if (!checkbox.isSelected()) {
					checkbox.click();
				}
			} else if ("Décocher".equalsIgnoreCase(action)) {
				if (checkbox.isSelected()) {
					checkbox.click();
				}
			}
		}
	}

	public Map<String, WebElement> getAllCheckboxesWithLabels() {
		Map<String, WebElement> checkboxes = new HashMap<>();

		List<WebElement> labels = Setup.getDriver().findElements(By.xpath("//label[input[@type='checkbox']]"));

		for (WebElement label : labels) {
			String labelText = label.getText().trim();
			WebElement checkbox = label.findElement(By.xpath(".//input[@type='checkbox']"));
			checkboxes.put(labelText, checkbox);
		}

		return checkboxes;
	}

	public void assertIfOptionIsSelectedInDorpdownList(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> lignes = dataTable.asMaps(String.class, String.class);

		for (Map<String, String> ligne : lignes) {
			String option = ligne.get("Option");
			String action = ligne.get("Action");

			WebElement checkbox = getAllCheckboxesWithLabels().get(option);

			boolean estCoche = checkbox.isSelected();

			if ("Cocher".equalsIgnoreCase(action)) {
				assertTrue("La case '" + option + "' devrait être cochée", estCoche);
			} else if ("Décocher".equalsIgnoreCase(action)) {
				assertFalse("La case '" + option + "' ne devrait PAS être cochée", estCoche);
			} else {
				throw new IllegalArgumentException("Action inconnue : " + action);
			}
		}
	}

	/*********************************************************************************************************************************/

	/**
	 * This method is used to find an element in a table by email. It iterates
	 * through the table rows and checks if the email is present in any column.
	 * Returns the matching WebElement if found, or null otherwise.
	 *
	 * @param table The table WebElement
	 * @param email The email to search for
	 * @return The matching WebElement if found, or null otherwise
	 */
	public WebElement findElementByElementInTable(WebElement table, String email) {
		// Get all table rows
		java.util.List<WebElement> rows = table.findElements(By.tagName("tr"));

		// Iterate through the rows
		for (WebElement row : rows) {
			// Get all columns in the current row
			java.util.List<WebElement> columns = row.findElements(By.tagName("td"));

			// Iterate through the columns
			for (WebElement column : columns) {
				// Check if the email is present in the column
				if (column.getText().equals(email)) {
					return row;
				}
			}
		}

		return null; // Email not found
	}

	// ...
}
