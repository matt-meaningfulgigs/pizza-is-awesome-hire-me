package nerfherder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BasePage {
	private static final Log LOG = LogFactory.getLog(BasePage.class); 
	protected WebDriver driver;
	
	public BasePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void goToUrl(String url) {
		LOG.info("getting URL: " + url);
		this.driver.get(url);
	}

	public static void goToUrl(WebDriver driver2, String url) {
		LOG.info("getting URL: " + url);
		driver2.get(url);
	}
}
