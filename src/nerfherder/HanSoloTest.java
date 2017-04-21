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
		
		// While the default is set to 1... Man... I already write the code for this, so I'm going to use it
		hanSoloRug.setQuantity(1);
		
		LOG.info("New Quantity: " + hanSoloRug.getQuantity());
		
		CartPage cart = hanSoloRug.clickAddToCart();

		LOG.info("Cart Size: " + cart.getCartSize());
		LOG.info("Item Name: " + cart.getItemName());
		LOG.info("Quantity: " + cart.getQuantity());
		LOG.info("SKU: " + cart.getSku());
		cart.setSku("Han Solo small/medium");
		cart = cart.clickUpdateCartBtn();
		LOG.info("SKU after change: " + cart.getSku());
		LOG.info("retail price: " + cart.getCartRetailPrice());
		LOG.info("unit price: " + cart.getCartUnitPrice());
		LOG.info("total: " + cart.getCartTotal());
		LOG.info("subtotal: " + cart.getSubtotal());
		cart.setQuantity(3);
		cart = cart.clickUpdateCartBtn();
		LOG.info("Quantity after change: " + cart.getQuantity());
		LOG.info("Total After Change: " + cart.getCartTotal());
		LOG.info("Subtotal After Change: " + cart.getSubtotal());
		
		CheckoutAddressPage checkoutAddress = cart.clickBottomCheckoutBtn();
		
		checkoutAddress.setLoginEmail("1");
		checkoutAddress.setLoginPass("2");
		
		checkoutAddress.setBillCountry("Austria");
		checkoutAddress.setBillFirstName("3");
		checkoutAddress.setBillLastName("last");
		Thread.sleep(30);
		checkoutAddress.setBillCompany("Pizza Lyfe");
		Thread.sleep(30);
		checkoutAddress.setBillAddress("addr");
		checkoutAddress.setBillAddress2("addr2");
		checkoutAddress.setBillCity("city");
		checkoutAddress.setBillState("California");
		checkoutAddress.setBillZip("92116");
		checkoutAddress.setBillPhone("1231231234");
		checkoutAddress.setBillEmail("email");
		checkoutAddress.toggleNewsletter();
		Thread.sleep(30);
		checkoutAddress.checkNewsletter();
		Thread.sleep(30);
		checkoutAddress.uncheckNewsletter();
		Thread.sleep(30);
		

		checkoutAddress.setShipFirstName("ship first");
		checkoutAddress.setShipLastName("ship last");
		checkoutAddress.setShipCompany("company");
		checkoutAddress.setShipAddress("ship addr");
		checkoutAddress.setShipAddress2("ship addr2");
		checkoutAddress.setShipCity("ship city");
		checkoutAddress.setShipState("Arizona");
		checkoutAddress.setShipZip("12345");
		checkoutAddress.setShipPhone("3213214321");
		
		
		checkoutAddress.toggleCopyBilling();
		Thread.sleep(30);
		checkoutAddress.checkCopyBilling();
		Thread.sleep(30);
		checkoutAddress.uncheckCopyBilling();
		Thread.sleep(30);

		checkoutAddress.setCreateAccountPass("passsss");
		checkoutAddress.setCreateAccountPassConfirm("Other Pass");
		checkoutAddress.setCreateAccountHint("Hint me");
		
		Thread.sleep(9999999);
		
	}
	
	
}
