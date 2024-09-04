package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import steps.Hooks;
import support.GenericUtil;

public class BasePage extends GenericUtil {
	WebDriver driver;
	Properties prop;

	public BasePage() {
		prop = Hooks.prop;
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}
}
