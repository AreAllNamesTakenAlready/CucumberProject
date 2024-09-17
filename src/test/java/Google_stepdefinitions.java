package test.java;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.GooglePage;

public class Google_stepdefinitions {

	GooglePage page = new GooglePage();
	String dollarG;
	String dollarXE;

	@Given("I navigate to Google")
	public void i_navigate_to_google() {
		page.googleNavigate();
	}

	@Given("Search for Dollar Price")
	public void search_for_dollar_price() {
		page.searchGoogle("dollar to rupees");
		dollarG = page.getINRPriceGoogle();
	}

	@Given("Navigate to XE site and get the dollar price")
	public void navigate_to_xe_site_and_get_the_dollar_price() throws InterruptedException {
		page.xeNavigate();
		Thread.sleep(1000);
		dollarXE = page.getINRPriceXE();
	}

	@Then("Verify dollar price is same for both site")
	public void verify_dollar_price_is_same_for_both_site() {
		Assert.assertEquals(dollarG, dollarXE);
	}

}
