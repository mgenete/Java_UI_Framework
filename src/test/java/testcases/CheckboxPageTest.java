package testcases;

import org.testng.annotations.Test;

import pageObjects.CheckboxesPage;
import pageObjects.WelcomePage;
import utility.Init;

public class CheckboxPageTest extends Init {
	
	
	
	@Test
	public void testCheckboxPage() {
		System.out.println("testMe");
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");
		
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
		checkboxesPage.clickOnCheckBox(2, false);
		
	}

	
	@Test
	public void testToSelectAllCheckboxes() {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Checkboxes");
		
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver);
		checkboxesPage.toSelectAllCheckbox(false);
		
	}
}
