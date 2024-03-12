package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Driver;


public class HomePage {
	
	 public HomePage() {
	        PageFactory.initElements(Driver.getDriver(), this);
	    }
	 
	 
	 
	    @FindBy(xpath = "//*[@name='input-serial-number']")
	    public WebElement InputSerialNumber;
	  
	    @FindBy(xpath = "//*[text()='Add']")
	    public WebElement AddButton;
	    
	    @FindBy(xpath = "//*[text()='X']")
	    public WebElement XButton;

	    @FindBy(xpath = "//*[@class='list-text']")
	    public WebElement VerifyText;

	    
}
