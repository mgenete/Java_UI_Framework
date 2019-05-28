package testcases;

import org.testng.annotations.Test;

import pageObjects.AlertPage;
import pageObjects.WelcomePage;
import utility.Init;

public class AlertPageTest extends Init{
	
	
	@Test(groups = {"smoke", "regression"})
	public void testClickForJSAlert() {
		
		WelcomePage wlecomePage = new WelcomePage(driver);
		wlecomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");
		
		AlertPage alertPage = new AlertPage(driver);
		alertPage.verifyAlertPageHeader();
		alertPage.clickOnButton("Click for JS Alert");
		alertPage.accept();
		
	}
	
	
	@Test(groups = {"regression"})
	public void testClickForJSConfirm() {
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("JavaScript Alerts");
		
		AlertPage alertPage = new AlertPage(driver);
		alertPage.verifyAlertPageHeader();
		alertPage.clickOnButton("Click for JS Confirm");
		alertPage.cancel();
	}

}
