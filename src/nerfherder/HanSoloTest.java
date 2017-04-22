package nerfherder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.junit.Test;

public class HanSoloTest extends BaseTest {
	@Test
	public void testUpDog() throws Exception {
		// variables
		final HashMap<String, String> person = this.generatePerson();
		final HashMap<String, String> card = this.generateCreditCard();

		// Create product page object
		final LootPage hanSoloRug = new LootPage(driver, "19fe");

		// Make sure that name game is on point
		assertEquals(hanSoloRug.getItemName(), "Han Solo in Carbonite Rug");
		// What if he doesn't survive? He's worth a lot to me
		assertTrue(hanSoloRug.getPrice().contains("$49.99 - $69.99"));
		// With that free Jabba pin, this bad boy may go out of stock
		assertTrue(hanSoloRug.isInStock());

		// The item seems totes cool, brah, so let's pick an option. THE BIG ONE
		hanSoloRug.setSku("Han Solo large/x-large $69.99");

		// While the default is set to 1... Man... I already write the code for
		// this, so I'm going to use it
		hanSoloRug.setQuantity(1);

		// Now we has gotst to buy it. Clicking button
		CartPage cart = hanSoloRug.clickAddToCart();

		// Assert stuff.
		assertEquals(cart.getCartSize(), 1);
		assertEquals(cart.getItemName(), "Han Solo in Carbonite Rug");
		assertEquals(cart.getQuantity(), 1);
		assertEquals(cart.getCartRetailPrice(), "$69.99");
		assertEquals(cart.getCartUnitPrice(), "$69.99");
		assertEquals(cart.getCartTotal(), "$69.99");
		assertEquals(cart.getSubtotal(), "$69.99");

		// The XL is too XL. Swap to medium, and get 3 to build some Han Solo
		// depth
		cart.setSku("Han Solo small/medium");
		cart.setQuantity(3);
		cart = cart.clickUpdateCartBtn();

		// Assert things are updated correctly
		assertEquals(cart.getQuantity(), 3);
		assertEquals(cart.getCartRetailPrice(), "$49.99");
		assertEquals(cart.getCartUnitPrice(), "$49.99");
		assertEquals(cart.getCartTotal(), "$149.97");
		assertEquals(cart.getSubtotal(), "$149.97");

		// Check it, check it, check it out, check it out. My jokes are horrible
		final CheckoutAddressPage checkoutAddress = cart.clickBottomCheckoutBtn();

		// Fill in the billing/ shipping info so someone pays for something and
		// it goes somewhere
		checkoutAddress.fillBillingInfo(person);
		checkoutAddress.uncheckNewsletter();
		checkoutAddress.checkCopyBilling();

		// Another checkout button... These things are like roaches
		final PaymentPage pay = checkoutAddress.clickCheckoutBtn();

		// Just waiting for the page to load
		pay.waitForLineItem("Han Solo small/medium");

		// Let's make sure we have the right stuff
		assertEquals(pay.getCartLineItem(), "Han Solo in Carbonite Rug - Han Solo small/medium");
		assertEquals(pay.getCartLineQuantity(), "3");
		assertEquals(pay.getCartLineTotal(), "$149.97");
		assertEquals(pay.getCartSubtotal(), "$149.97");
		assertEquals(pay.getCartShipping(), "$35.95");
		assertEquals(pay.getCartSalesTax(), "11.62");
		// Like how I got 187 here? I'm from the STREETS
		assertEquals(pay.getCartTotal(), "191.59");

		// Change shipping method because the company is paying for it with
		// their fake credit card
		pay.clickShippingExpress();

		// Baller money right here
		assertEquals(pay.getCartShipping(), "$54.95");
		assertEquals(pay.getCartTotal(), "216.54");

		// Assert shipping address is as expected
		assertTrue(pay.getShippingAddress().contains(person.get("name")));
		assertTrue(pay.getShippingAddress().contains(person.get("address")));
		assertTrue(pay.getShippingAddress().contains(person.get("city")));
		assertTrue(pay.getShippingAddress().contains(person.get("shortState")));
		assertTrue(pay.getShippingAddress().contains(person.get("zip")));
		assertTrue(pay.getShippingAddress().contains(person.get("country")));

		// Fill credit card info. No funny jokes. This is pretty standard. Why
		// are you still reading this?
		pay.fillCardInfo(card);

		// You think this is the final buy button? HA!
		pay.clickOrderBtn();

		// Assert pre-buy dialog because they REALLY want to be sure you want it
		assertTrue(pay.getReviewAddress().contains(person.get("name")));
		assertTrue(pay.getReviewAddress().contains(person.get("address")));
		assertTrue(pay.getReviewAddress().contains(person.get("city")));
		assertTrue(pay.getReviewAddress().contains(person.get("shortState")));
		assertTrue(pay.getReviewAddress().contains(person.get("zip")));
		assertTrue(pay.getReviewAddress().contains(person.get("country")));

		assertEquals(pay.getReviewTotal(), "216.54");

		// Finally... FINALLY
		pay.clickReviewPlaceOrderBtn();

		// Wait for failure message
		pay.waitForProcessing();
		pay.waitForTransactionMessage();

		// Assert it's a fail, which it is
		assertEquals(pay.getTransactionMessage(), "Transaction was declined by processor");

		// The End
	}

}
