package nerfherder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class HanSoloTest extends BaseTest {
	private static final Log LOG = LogFactory.getLog(HanSoloTest.class);

	@Test
	public void testUpDog() throws Exception {
		final LootPage hanSoloRug = new LootPage(driver, "19fe");
		// variables
		HashMap<String, String> person = generatePerson();
		HashMap<String, String> card = generateCreditCard();
		
		// Make sure that name game is on point
		LOG.info("Product Name: " + hanSoloRug.getItemName());
		assertEquals(hanSoloRug.getItemName(), "Han Solo in Carbonite Rug");
		// What if he doesn't survive? He's worth a lot to me
		LOG.info("Product Price(s): " + hanSoloRug.getPrice());
		assertTrue(hanSoloRug.getPrice().contains("$49.99 - $69.99"));
		// With that free Jabba pin, this bad boy may go out of stock
		LOG.info("Is Han in Stock?: " + hanSoloRug.isInStock());
		assertTrue(hanSoloRug.isInStock());

		// The item seems totes cool, brah, so let's pick an option. THE BIG ONE
		hanSoloRug.setSku("Han Solo large/x-large $69.99");
		LOG.info("New SKU Selection: " + hanSoloRug.getSku());

		// While the default is set to 1... Man... I already write the code for
		// this, so I'm going to use it
		hanSoloRug.setQuantity(1);

		LOG.info("Clicking Add to Cart button");
		CartPage cart = hanSoloRug.clickAddToCart();

		assertEquals(cart.getCartSize(), 1);
		assertEquals(cart.getItemName(), "Han Solo in Carbonite Rug");
		assertEquals(cart.getQuantity(), 1);
		assertEquals(cart.getCartRetailPrice(), "$69.99");
		assertEquals(cart.getCartUnitPrice(), "$69.99");
		assertEquals(cart.getCartTotal(), "$69.99");
		assertEquals(cart.getSubtotal(), "$69.99");
		
		LOG.info("Updating SKU and Quantity");
		cart.setSku("Han Solo small/medium");
		cart.setQuantity(3);
		cart = cart.clickUpdateCartBtn();

		assertEquals(cart.getQuantity(), 3);
		assertEquals(cart.getCartRetailPrice(), "$49.99");
		assertEquals(cart.getCartUnitPrice(), "$49.99");
		assertEquals(cart.getCartTotal(), "$149.97");
		assertEquals(cart.getSubtotal(), "$149.97");

		LOG.info("Clicking Checkout button");
		final CheckoutAddressPage checkoutAddress = cart.clickBottomCheckoutBtn();

		LOG.info("Filling Billing info");
		checkoutAddress.fillBillingInfo(person);
		LOG.info("No one likes newsletters!");
		checkoutAddress.uncheckNewsletter();
		LOG.info("Copy Billing info to Shipping");
		checkoutAddress.checkCopyBilling();

		LOG.info("Clicking Checkout button");
		PaymentPage pay = checkoutAddress.clickCheckoutBtn();
		pay.waitForLineItem("Han Solo small/medium");
		LOG.info("-----WAITING DONE-----");
		
		Thread.sleep(999999);
	}

}
