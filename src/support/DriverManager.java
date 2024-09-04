package support;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	Properties prop;

	public DriverManager() {
		driverType = ReadProperties.getBrowser();
	}

	private WebDriver createDriver() {
		driver = createLocalDriver();
		return driver;
	}

	// private WebDriver createRemoteDriver() {
	// throw new RuntimeException("RemoteWebDriver is not yet implemented");
	// }

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, ReadProperties.get("driverpath"));
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		default:
			break;
		}

		return driver;
	}

	public void closeDriver() {
		if (driver != null)
			driver.close();
	}

	public void quitDriver() {
		if (driver != null)
			driver.quit();
	}
}
