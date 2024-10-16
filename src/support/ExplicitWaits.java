package support;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaits {
	private WebDriver driver;

	public ExplicitWaits(WebDriver driver) {
		this.driver = driver;
	}

	// Implicit and explicit waits should not be used together as they can give
	// ambiguous results
	public WebElement untilDisplayed(WebElement element, int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.of(0, ChronoUnit.SECONDS));
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(d -> element.isDisplayed());
			return element;

		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT_TIMEOUT);
			throw e;
		}

	}

	public WebElement untilVisible(WebElement element, int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.of(0, ChronoUnit.SECONDS));
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.visibilityOf(element));
			return element;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT_TIMEOUT);
			throw e;
		}

	}

	public WebElement untilClickable(WebElement element, int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.of(0, ChronoUnit.SECONDS));
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT_TIMEOUT);
			throw e;
		}

	}

	public WebElement fluentWait(WebElement element, int seconds, int pollingDuration) {
		try {
			driver.manage().timeouts().implicitlyWait(Duration.of(0, ChronoUnit.SECONDS));

			Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(seconds))
					.pollingEvery(Timeouts.FLUENT_WAIT_POLLING_DURATION).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.visibilityOf(element));
			return element;
		} catch (Exception e) {
			driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT_TIMEOUT);
			throw e;
		}

	}

}
