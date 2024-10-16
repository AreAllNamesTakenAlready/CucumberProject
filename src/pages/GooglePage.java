package pages;

import java.util.logging.Logger;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.ExplicitWaits;
import support.ScreenShotManager;

public class GooglePage extends BasePage {

	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	ScreenShotManager screen = new ScreenShotManager(driver);
	ExplicitWaits wait = new ExplicitWaits(driver);

	final String googleURL = "https://www.google.com/";

	@FindBy(css = "[title='Search']")
	WebElement googleSearch;

	@FindBy(css = "[data-attrid='Converter'] div div")
	WebElement inrPriceGoogle;

	@FindBy(css = "[class='dURPMd'] > div > div:nth-child(2) span > a")
	WebElement xeLink;

	@FindBy(css = "main > div div > p:nth-child(2)")
	WebElement inrPriceXE;

	@FindBy(css = "someTest")
	WebElement testToFailure;

	public void googleNavigate() {
		driver.get(googleURL);
	}

	public void searchGoogle(String searchData) {
		Logger logger = Logger.getLogger("hi, info logged");

		//////////////// your code above this
		googleSearch.sendKeys(searchData);
		googleSearch.sendKeys(Keys.ENTER);
		// wait.untilDisplayed(testToFailure, 5);
		screen.takeFullPageScreenshot("Google_Search_Page");
	}

	public String getINRPriceGoogle() {
		String rate = inrPriceGoogle.getAttribute("data-exchange-rate").split("\\.")[0];
		// screen.takeElementScreenshot(inrPriceGoogle);
		return rate;
	}

	public void xeNavigate() {
		xeLink.click();
	}

	public String getINRPriceXE() {
		String rate = inrPriceXE.getText().split("\\.")[0];
		return rate;
	}

}
