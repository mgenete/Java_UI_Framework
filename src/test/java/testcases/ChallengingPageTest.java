package testcases;

import org.testng.annotations.Test;

import pageObjects.ChallengingDomPage;
import pageObjects.WelcomePage;
import utility.Init;

public class ChallengingPageTest extends Init{
	
	
	
	
	@Test
	public void testChallengingPage() {
		
		WelcomePage welcomePage = new WelcomePage(driver);
		welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Challenging DOM");
		
		ChallengingDomPage challengingDomPage = new ChallengingDomPage(driver);
		challengingDomPage.verifyChallengingDomPageHeader();
		challengingDomPage.getAllButtonText();
		challengingDomPage.clickOnFirstButton();
		
		System.out.println(challengingDomPage.getColumnIndex("Sit"));
		System.out.println(challengingDomPage.getCellText(3, "Sit"));
		
	}

}
