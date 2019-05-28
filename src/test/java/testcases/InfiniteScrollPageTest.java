package testcases;

import org.testng.annotations.Test;

import pageObjects.InfiniteScrollPage;
import pageObjects.WelcomePage;
import utility.Init;

public class InfiniteScrollPageTest extends Init {

	@Test
	public void testFrame() {

		WelcomePage welcomePage = new WelcomePage(driver);
		InfiniteScrollPage infiniteScrollPage = new InfiniteScrollPage(driver);

		welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader().clickOnLink("Large & Deep DOM");
		
		infiniteScrollPage.scrollWithinParticularElement();
		//Thread.sleep(5000);
        infiniteScrollPage.scrollVerticalPage();
        infiniteScrollPage.scrollHorizontallyPage();
	}

}
