package support;

import java.io.File;
import java.util.Random;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotManager {
	private WebDriver driver;

	public ScreenShotManager(WebDriver driver) {
		this.driver = driver;
	}

	public void takeFullPageScreenshot(String name) {
		try {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("screenshots/" + name + "FullPageScreenshot.png"));
		} catch (Exception e) {
			System.out.println("Screenshot failed");
		}
	}

	public byte[] screenshotForReport() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		return src;
	}

	public void takeElementScreenshot(WebElement element) {
		try {
			Random random = new Random();
			random.nextInt();
			File src = element.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("screenshots/" + random.nextInt() + "ElementScreenshot.png"));
		} catch (Exception e) {
			System.out.println("Screenshot failed");
		}
	}
}
