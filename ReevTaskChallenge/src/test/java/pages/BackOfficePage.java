package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BackOfficePage {
    public BackOfficePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    
    @FindBy(xpath = "//input[@name=\"input-serial-number\"]")
    public WebElement InputSerialNumber;
  
    @FindBy(xpath = "//*[text()='Add']")
    public WebElement AddButton;
    
    @FindBy(xpath = "//*[text()='X']")
    public WebElement cancelButton;

    @FindBy(xpath = "//*[@class='list-text']")
    public WebElement VerifyTestStationNumber;
    
    @FindBy(xpath = "//*[@class=\"title\"]")
    public WebElement ChargePointInstallationForm_HeaderText;
    
    @FindBy(xpath = "//*[@for=\"input-serial-number\"]")
    public WebElement SerialNumberText;
    
  
    
  

    
















}