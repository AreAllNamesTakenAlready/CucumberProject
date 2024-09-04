package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import support.GenericUtil;

public class HerokuAppPage extends BasePage {

	public HerokuAppPage() {
		PageFactory.initElements(driver, this);
	}

	GenericUtil util = new GenericUtil();

	@FindBy(id = "column-a")
	WebElement a;

	@FindBy(id = "column-b")
	WebElement b;

	@FindBy(id = "dropdown")
	WebElement drpDown;

	public void navigate() {
		driver.get(prop.getProperty("herourl"));
	}

	public void dragnDrop() {
		FindElementXPath("//*[text()='Drag and Drop']").click();
		dragAndDrop(a, b);
	}

	public void select() {
		FindElementXPath("//*[text()='Dropdown']").click();
		selectDropDown(this.drpDown, "Option 2");
		staticWait(4000);
	}

}
