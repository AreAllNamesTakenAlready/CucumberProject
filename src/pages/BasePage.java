package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import support.GenericUtil;
import test.java.Hooks;

// used for common driver instance across all pages
// can be used for sharing page objects
public class BasePage extends GenericUtil {
	WebDriver driver;
	Properties prop;

	public BasePage() {
		prop = Hooks.prop;
		this.driver = Hooks.driver;
		PageFactory.initElements(driver, this);
	}
}
