package testcases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.WelcomePage;
import utility.Init;

public class LoginPageTest extends Init{
	
	
	@Test
    public void testLogin() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
                .clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLogin("tomsmith", "SuperSecretPassword!");
    }

    @Test
    public void testLoginWithInvalidUser() {

        WelcomePage welcomePage = new WelcomePage(driver);
        welcomePage.verifyWelcomePageTitle().verifyWelcomePageHeader()
                .clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginPageHeader();
        loginPage.verifyLoginWithInvalidUser("abc", "abc");
    }

}
