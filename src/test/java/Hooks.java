package test.java;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import support.DriverManager;
import support.ReadProperties;

public class Hooks {

	public static Properties prop;
	public static WebDriver driver;
	public static DriverManager driverManager;

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

	@After
	public void afterScenario() {
		driverManager.quitDriver();
	}

	@AfterAll
	public static void tearDown() {
		// driver.quit();
	}
}
