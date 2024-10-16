package support;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverManager {
	private WebDriver driver;
	private ChromeOptions options;
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
			options = new ChromeOptions();
			options.addArguments("start-maximized");
			if (ReadProperties.get("headless").equals("true")) {
				options.addArguments("--headless=new");
			}
			// Handling timeouts using manage()
			// driver.manage().timeouts().scriptTimeout(Timeouts.SCRIPT_TIMEOUT);
			// driver.manage().timeouts().pageLoadTimeout(Timeouts.PAGELOAD_TIMEOUT);
			// driver.manage().timeouts().implicitlyWait(Timeouts.IMPLICIT_WAIT_TIMEOUT);

			// Handling Timeouts using ChromeOptions
			options.setScriptTimeout(Timeouts.SCRIPT_TIMEOUT);
			options.setPageLoadTimeout(Timeouts.PAGELOAD_TIMEOUT);
			options.setImplicitWaitTimeout(Timeouts.IMPLICIT_WAIT_TIMEOUT);

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();

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
