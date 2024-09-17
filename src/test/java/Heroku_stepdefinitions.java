package test.java;

import io.cucumber.java.en.Given;
import pages.HerokuAppPage;

public class Heroku_stepdefinitions {
//	BasePage base = new BasePage();

	HerokuAppPage hero = new HerokuAppPage();

	@Given("I navigate Heroku App")
	public void i_navigate_heroku_app() {
		hero.navigate();
	}

	@Given("Verify Drag and Drop")
	public void verify_drag_and_drop() {
		hero.dragnDrop();
	}

	@Given("Verify dropdown")
	public void verify_dropdown() {
		hero.select();
	}

}
