package nerfherder;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	protected static WebDriver driver;
	private static final Log LOG = LogFactory.getLog(BaseTest.class);

	@Before
	public void setUp() {
		// the path to the Chrome Driver needs to be set for the machine!
		System.setProperty("webdriver.chrome.driver", "/Users/mattmeling/Documents/workspace/webdriver/chromedriver");
		driver = new ChromeDriver();
		LOG.info("Making a fresh, new Chrome Driver");
	}

	@After
	public void tearDown() {
		LOG.info("Quitting Driver");
		driver.quit();
	}
	
	public HashMap<String, String> generatePerson(){
		HashMap<String, String> newPerson = new HashMap<String, String>();
		newPerson.put("first", "Matthew");
		newPerson.put("last", "Meling");
		newPerson.put("company", "Granbury, hopefully");
		newPerson.put("address", "123 Fake St");
		newPerson.put("city", "San Diego");
		newPerson.put("state", "California");
		newPerson.put("zip", "92116");
		newPerson.put("country", "United States");
		newPerson.put("phone", "6198135347");
		newPerson.put("email", "mattmeling@gmail.com");
		return newPerson;
	}
	
	public HashMap<String, String> generateCreditCard(){
		HashMap<String, String> newCard = new HashMap<String, String>();
		newCard.put("number", "4111111111111111");
		newCard.put("expMonth", "12");
		newCard.put("expYear", "20");
		newCard.put("cvc", "123");
		return newCard;
	}
}
