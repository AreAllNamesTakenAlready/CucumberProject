package support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import steps.Hooks;

public class GenericUtil {
	WebDriver driver;

	public GenericUtil() {
		driver = Hooks.driver;
	}

	// used to drag element a to b
	public void dragAndDrop(WebElement a, WebElement b) {
		Actions act = new Actions(driver);
		act.dragAndDrop(b, a).build().perform();
	}

	// find element by css
	public WebElement FindElementCss(String css) {
		return driver.findElement(By.cssSelector(css));
	}

	public WebElement FindElementXPath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public void selectDropDown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
	}

	protected void staticWait(long a) {
		try {
			Thread.sleep(a);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	enum SELECT {
		ByText, ByID, ByValue
	}
}
