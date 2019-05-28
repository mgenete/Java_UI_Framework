package pageObjects;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage {
	
	final static String HEADING = "Checkboxes";
    WebDriver driver;
    String xpathHeading = "//h3";
    String xpathCheckbox = "//form[@id='checkboxes']/input[**index**]";
    String xpathCheckboxes = "//form[@id='checkboxes']/input";

    
    public CheckboxesPage(WebDriver driver) {
    	this.driver=driver;
    }
    
    
    public CheckboxesPage clickOnCheckBox(int index) {
    	String xpath = xpathCheckbox.replace("**index**", index + "");
    	driver.findElement(By.xpath(xpath)).click();
    	return this;
    }
    
    
    public void clickOnCheckBox(int index, boolean toSelect) {
    	String xpath = xpathCheckbox.replace("**index**", index + "");
    	WebElement checkBox = driver.findElement(By.xpath(xpath));
    	
    	changeStatus(checkBox, toSelect);
    }
    
    
    private void changeStatus(WebElement checkboxEle, boolean toSelect) {
    	if(toSelect) {
    		if(!checkboxEle.isSelected())
    			checkboxEle.click();
    		assertTrue(checkboxEle.isSelected(), "Check box is not selected.");
    	} else {
    		if(checkboxEle.isSelected())
    			checkboxEle.click();
    		assertFalse(checkboxEle.isSelected(), "Check box is selected");
    	}
    }
    
    public void toSelectAllCheckbox(boolean toSelect) {
    	List<WebElement> checkboxeEles = driver.findElements(By.xpath(xpathCheckboxes));

        for (WebElement ch : checkboxeEles) {
            changeStatus(ch, toSelect);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
