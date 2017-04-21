package nerfherder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	private static final Log LOG = LogFactory.getLog(BasePage.class);

	public static void goToUrl(WebDriver driver2, String url) {
		LOG.info("getting URL: " + url);
		driver2.get(url);
	}

	public static void waitForText(WebDriver driver, WebElement element, String text, long timeOutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		LOG.info("Tick, tock, tick, tock");
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToUrl(String url) {
		LOG.info("getting URL: " + url);
		this.driver.get(url);
	}
}
