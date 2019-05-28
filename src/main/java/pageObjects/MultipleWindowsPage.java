package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Services;

public class MultipleWindowsPage extends Services{
	
	
	private final static String HEADING = "Opening a new window";
	private String xpathHeading = "//h3";
	private String xpathLink = "//a[text()='Click Here']";
	

	public MultipleWindowsPage(WebDriver driver) {
		super(driver);
	}
	
	public void verifyMultipleWindowsPageHeader() {
		waitForElement(xpathHeading);
		WebElement header = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = header.getText();
		assertEquals(actualHeading, HEADING,  "Actual heading '" + actualHeading + "' should be same as expected '" + HEADING + "'.");
	}
	
	
	public void clickOnLink() {
		assertAndClick(xpathLink);
	}
	
	public void getTextOnNewWindow() throws InterruptedException {
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> it = windowhandles.iterator();
		while(it.hasNext()) {
			String win = it.next();
			
			driver.switchTo().window(win);
			Thread.sleep(2000);
			if(driver.getTitle().equals("New Window")) {
				assertTrue(getWebElement("//h3").isDisplayed());
			}
		}
		
		windowhandles = driver.getWindowHandles();
		it = windowhandles.iterator();
		while(it.hasNext()) {
			String win = it.next();
			
			driver.switchTo().window(win);
			Thread.sleep(2000);
			if(driver.getTitle().equals("The Internet")) {
				assertTrue(getWebElement("//h3").isDisplayed());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
