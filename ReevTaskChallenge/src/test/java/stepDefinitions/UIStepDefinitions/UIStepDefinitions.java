package stepDefinitions.UIStepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.Select;
import pages.AllPages;

import utilities.ConfigReader;
import utilities.Driver;

import java.awt.*;

import java.util.HashMap;


import static utilities.Driver.getDriver;
import static utilities.JSUtils.clickElementByJS;
import static utilities.JSUtils.moveToElementJS;
import static utilities.ReusableMethods.*;

public class UIStepDefinitions {

	Actions actions = new Actions(getDriver());
	AllPages pages = new AllPages();
	Select DDM;
	Robot r;
	String baseUrl;
	String baseUrl1;
	String bookingID;

	{
		try {
			r = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
	}

	HashMap<String, WebElement> buttons = new HashMap<>();
	HashMap<String, WebElement> DDMs = new HashMap<>();
	HashMap<String, WebElement> checkboxes = new HashMap<>();
	HashMap<String, WebElement> boxes = new HashMap<>();
	HashMap<String, WebElement> objects = new HashMap<>();

	public void createButtonsMap() {
		buttons.put("AddButton", pages.backOfficePage().AddButton);
		buttons.put("cancelButton", pages.backOfficePage().cancelButton);

	}

	public void createBoxesMap() {

		boxes.put("InputSerialNumber", pages.backOfficePage().InputSerialNumber);

	}

	public void createObjectsMap() {

		objects.put("AddButton", pages.backOfficePage().AddButton);
		objects.put("cancelButton", pages.backOfficePage().cancelButton);
		objects.put("ChargePointInstallationForm_HeaderText",
				pages.backOfficePage().ChargePointInstallationForm_HeaderText);
		objects.put("SerialNumberText", pages.backOfficePage().SerialNumberText);
		objects.put("VerifyTestStationNumber", pages.backOfficePage().VerifyTestStationNumber);

	}

	@And("The user clicks the {string} button")
	public void theUserClicksTheButton(String button) {

		try {
			waitFor(1);
			buttons.get(button).click();
			waitFor(1);
		} catch (Exception NoSuchElementException) {
			Assert.fail("Button " + button + " cannot be found.");
		}

	}

	@And("The user clicks the {string} button with JS")
	public void theUserClicksTheButtonWithJS(String button) {

		try {
			waitFor(1);
			moveToElementJS(buttons.get(button));
			waitFor(1);
			clickElementByJS(buttons.get(button));
			waitFor(1);
		} catch (Exception NoSuchElementException) {
			Assert.fail("Button " + button + " cannot be found.");
		}

	}

	@Then("The user asserts that {string} is visible")
	public void theUserAssertsThatIsVisible(String object) {
		waitFor(2);
		try {
			waitForVisibility(objects.get(object), 1);
			Assert.assertTrue("Assertion failed !", objects.get(object).isDisplayed());

		} catch (Exception NoSuchElementException) {
			Assert.fail(object + " cannot be found.");
		}
	}

	protected String locatePath(String path) {
		baseUrl = ConfigReader.getProperty("baseURL");
		return !path.startsWith("http") ? String.format("%1$s%2$s", baseUrl, path) : path;
	}

	@Given("The user go to the {string} website")
	public void theUserGoToTheWebsite(String path) {
		baseUrl = ConfigReader.getProperty(path);
		System.out.println(baseUrl);
		goToURL(baseUrl);

	}


	@Given("The user sets up functions")
	public void theUserSetsUpFunctions() {
		createButtonsMap();
		createBoxesMap();
		createObjectsMap();
	}

	@Then("The user selects {string} on {string}")
	public void theUserSelectsOn(String searchedItem, String DDMName) {
		waitFor(1);
		try {
			DDM = new Select(DDMs.get(DDMName));
			DDM.selectByVisibleText(searchedItem);

		} catch (Exception NoSuchElementException) {
			Assert.fail(DDMName + " cannot be found.");
		}
	}

	@Then("The user fills the {string} box as {string}")
	public void theUserFillsTheBoxAs(String boxName, String value) {
		waitFor(1);
		try {
			boxes.get(boxName).sendKeys(value);

		} catch (Exception NoSuchElementException) {
			Assert.fail(boxName + " cannot be found.");
		}

	}

	@Then("The user clears the {string} box")
	public void theUserClearsTheBox(String boxName) {

		waitFor(1);
		try {
			boxes.get(boxName).click();
			actions.keyDown(Keys.COMMAND).perform();
			actions.sendKeys("a").perform();
			actions.keyUp(Keys.COMMAND).perform();
			actions.sendKeys(Keys.CLEAR).perform();

		} catch (Exception NoSuchElementException) {
			Assert.fail(boxName + " cannot be found.");
		}
	}

	@Then("The user waits for {string} seconds")
	public void theUserWaitsForSeconds(String seconds) {
		waitFor(Integer.parseInt(seconds));
	}

	@Then("The user asserts that VerifyTestStationNumber is not visible")
	public void the_user_asserts_that_verify_test_station_number_is_not_visible() {
		try {
			if (Driver.getDriver().findElements(By.xpath("//*[@class='list-text']")).size() == 0) {
				System.out.println("Elemnt is not present ");
			}
		} catch (Exception NoSuchElementException) {
			Assert.fail(" Elemnt can be found.");
		}
	}

	@Then("The user asserts that cancelButton is not visible")
	public void the_user_asserts_that_cancel_button_is_not_visible() {
		try {
			if (Driver.getDriver().findElements(By.xpath("//*[text()='X']")).size() == 0) {
				System.out.println("Elemnt is not present ");
			}
		} catch (Exception NoSuchElementException) {
			Assert.fail(" Elemnt can be found.");
		}
	}

}