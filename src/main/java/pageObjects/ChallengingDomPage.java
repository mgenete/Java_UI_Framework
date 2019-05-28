package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.Services;

public class ChallengingDomPage extends Services{
	
	final static String HEADING = "Challenging DOM";
	String xpathHeading = "//h3";
    String xpathButtons = "//div[@class='large-2 columns']/a";
    String xpathButtonsViaContains = "//div[contains(@class,'large-2')]/a";
    String xpathButtonsViaStartsWith = "//div[starts-with(@class,'large-2')]/a";
    String xpathTable = "//div[contains(@class,'large-10')]";
    String xpathTableHeader = xpathTable + "/table//th";
    String xpathTableCell = xpathTable + "//tbody//tr[**row**]/td[**col**]";
	

	public ChallengingDomPage(WebDriver driver) {
		super(driver);
	}

	
	public void verifyChallengingDomPageHeader() {
		WebElement header = driver.findElement(By.xpath(xpathHeading));
		String actualHeading = header.getText();
		assertEquals(actualHeading, HEADING);
		
	}
	
	public void getAllButtonText() {
		waitForElement(xpathButtonsViaContains);
		List<WebElement> listBtns = driver.findElements(By.xpath(xpathButtonsViaContains));
		
		for(int i=0; i < listBtns.size(); i++) {
			System.out.println(listBtns.get(i).getText());
		}
	}
	
	
	public void clickOnFirstButton() {
		String xpath = xpathButtons + "[1]";
		assertAndClick(xpath);
	}
	
	public int getColumnIndex(String columnName) {
		waitForElement(xpathTableHeader);
		List<WebElement> listCols = driver.findElements(By.xpath(xpathTableHeader));
		
		int index = 0;
		for(WebElement col : listCols){
			String actualCol = col.getText();
			index++;
			if(actualCol.equals(columnName)) {
				
				return index;
			}
		}
		assertTrue(false, "Given colun name " + columnName + " is not present.");
		return index;
	}
	
	public String getCellText(int row, String columnName) {
		int col = getColumnIndex(columnName);
		
		String xpath = xpathTableCell.replace("**row**", row + "").replace("**col**", col + "");
		waitForElement(xpath);
		return driver.findElement(By.xpath(xpath)).getText();
	}
	

}
