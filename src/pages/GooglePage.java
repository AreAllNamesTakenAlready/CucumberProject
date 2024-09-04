package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage {

	public GooglePage() {
		PageFactory.initElements(driver, this);
	}

	final String googleURL = "https://www.google.com/";

	@FindBy(css = "[title='Search']")
	WebElement googleSearch;

	@FindBy(css = "[data-attrid='Converter'] div div")
	WebElement inrPriceGoogle;

	@FindBy(css = "[class='dURPMd'] > div > div:nth-child(2) span > a")
	WebElement xeLink;

	@FindBy(css = "main > div div > p:nth-child(2)")
	WebElement inrPriceXE;

	public void googleNavigate() {
		driver.get(googleURL);
	}

	public void searchGoogle(String searchData) {
		googleSearch.sendKeys(searchData);
		googleSearch.sendKeys(Keys.ENTER);
	}

	public String getINRPriceGoogle() {
		String rate = inrPriceGoogle.getAttribute("data-exchange-rate").split("\\.")[0];
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
