package nerfherder;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BaseTest {
	private static final Log LOG = LogFactory.getLog(BaseTest.class);
	protected static WebDriver driver;

	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "/Users/mattmeling/Documents/workspace/webdriver/chromedriver");
		driver = new ChromeDriver();
		LOG.info("Making a fresh, new Chrome Driver");
	}
	
	@After
	public void tearDown(){
		LOG.info("Quitting Driver");
		driver.quit();
	}
}
