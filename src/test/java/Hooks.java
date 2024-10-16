package test.java;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import support.DriverManager;
import support.ReadProperties;
import support.ScreenShotManager;

public class Hooks {

	public static Properties prop;
	public static WebDriver driver;
	public static DriverManager driverManager;
	public ScreenShotManager screen;

	@BeforeAll
	public static void setup() throws IOException {
		System.out.println("Before All");
		prop = ReadProperties.readPropertiesFile();

		System.out.println("Before Scenario");
	}

	@Before
	public void beforeScenario() {
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		driverManager = new DriverManager();
		driver = driverManager.getDriver();
	}

	@After(order = 1)
	public void ScreenShotOnFailure(Scenario scenario) {
		System.out.println("After Scenario - 1");
		if (scenario.isFailed()) {
			screen = new ScreenShotManager(driver);
			scenario.attach(screen.screenshotForReport(), "image/png", "screenshot");
			scenario.log("");
		}
	}

	@After(order = 0)
	public void afterScenario() {
		System.out.println("After Scenario - 0");
		driverManager.quitDriver();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("After All");
		// driver.quit();
	}
}
