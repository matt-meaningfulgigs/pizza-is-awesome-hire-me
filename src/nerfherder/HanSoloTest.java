package nerfherder;

import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import nerfherder.BaseTest;
import nerfherder.LootPage;

public class HanSoloTest extends BaseTest{
	private static final Log LOG = LogFactory.getLog(HanSoloTest.class); 
	
	@Test
	public void testUpDog() throws Exception {
		LootPage hanSoloRug = new LootPage(driver, "19fe");
		LOG.info("Product Name: " + hanSoloRug.getItemName());

		// Make sure that name game is on point
		assertEquals(hanSoloRug.getItemName(), "Han Solo in Carbonite Rug");
		// What if he doesn't survive? He's worth a lot to me
		assertTrue(hanSoloRug.getPrice().contains("$49.99 - $69.99"));
		// With that free Jabba pin, this bad boy may go out of stock
		assertTrue(hanSoloRug.isInStock());
		
		// The item seems totes cool, brah, so let's pick an option. THE BIG ONE
		hanSoloRug.setSku("Han Solo large/x-large $69.99");
		
		// While the default is set to 1... Man... I already write the code for this, so I'm going to use it
		hanSoloRug.setQuantity(1);
		
		CartPage cart = hanSoloRug.clickAddToCart();
		LOG.info(cart);
		
		Thread.sleep(99999);
	}
	
	
}
