package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {
	
	WebDriver driver;
	final static String TITLE = "The Internet";
	final static String HEADING = "Welcome to the-internet";
	String xpathHeading = "//h1";
	String xpathLink = "//ul/li/a[text()='**link**']";
	  
	public WelcomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WelcomePage verifyWelcomePageTitle() {
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, TITLE, "Actual title " + actualTitle + " shall be same as expected " + TITLE);
		return this;
	}

	
	public WelcomePage verifyWelcomePageHeader() {
		WebElement header = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = header.getText();
		assertEquals(actualHeading, HEADING, "Actual heading '" + actualHeading + "' shall be same as expected '" + HEADING + "'.");
		return this;
	}
	
	
	public void clickOnLinkViaLinkText(String link) {
		driver.findElement(By.partialLinkText(link)).click();
	}
	
	
	public Object clickOnLink(String link) {
        xpathLink = xpathLink.replace("**link**", link);
        driver.findElement(By.xpath(xpathLink)).click();
        return this;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
