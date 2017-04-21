package nerfherder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {
	private static final Log LOG = LogFactory.getLog(CartPage.class);
	private final String baseUrl = "http://www.thinkgeek.com/brain/loot.cgi";

	@FindBy(xpath = "//*[contains(@class,'cart-nav')]//a[contains(.,'Checkout')]")
	private WebElement bottomCheckoutBtn;

	@FindBy(className = "topnav_cart_count")
	private WebElement cartCount;

	// There would be more rows with multiple items, so these wouldn't work in
	// that case
	@FindBy(name = "0_del")
	private WebElement cartDeleteCheckbox;

	@FindBy(className = "cart-line-name")
	private WebElement cartItemName;

	@FindBy(name = "0_qty")
	private WebElement cartQuantity;

	@FindBy(xpath = "//*[@class='cart-table-row ']//td[contains(.,'$')][1]")
	private WebElement cartRetailPrice;

	@FindBy(name = "0_sku")
	private WebElement cartSku;

	@FindBy(xpath = "//*[@class='cart-table-row ']//td[contains(.,'$')][3]")
	private WebElement cartTotal;

	@FindBy(xpath = "//*[@class='cart-table-row ']//td[contains(.,'$')][2]")
	private WebElement cartUnitPrice;

	@FindBy(xpath = "//*[contains(@class,'cart-nav')]//a[contains(.,'Continue')]")
	private WebElement continueShoppingBtn;

	@FindBy(xpath = "//input[@value='Get estimate']")
	private WebElement getEstimateBtn;

	@FindBy(xpath = "//*[@name='country']")
	private WebElement shippingCountry;

	@FindBy(xpath = "//*[@name='us_zip")
	private WebElement shippingZip;

	@FindBy(className = "cart-subtotal-amount")
	private WebElement subTotal;

	@FindBy(xpath = "//*[contains(@class,'loot-header')]//a[contains(.,'Checkout')]")
	private WebElement topCheckoutBtn;

	@FindBy(xpath = "//*[@value='Update Cart']")
	private WebElement updateCartBtn;

	public CartPage(WebDriver driver) {
		super(driver);
	}

	public void checkFirstDelBtn() {
		if (!this.cartDeleteCheckbox.isSelected()) {
			this.cartDeleteCheckbox.click();
		}
	}

	public CheckoutAddressPage clickBottomCheckoutBtn() {
		this.bottomCheckoutBtn.click();
		return new CheckoutAddressPage(this.driver);
	}

	public void clickContinueShoppingBtn() {
		// I didn't get a chance to make a page for the item list pages
		// So this is all you get
		this.continueShoppingBtn.click();
	}

	public CartPage clickGetEstimateBtn() {
		this.getEstimateBtn.click();
		return new CartPage(this.driver);
	}

	public CheckoutAddressPage clickTopCheckoutBtn() {
		this.topCheckoutBtn.click();
		return new CheckoutAddressPage(this.driver);
	}

	public CartPage clickUpdateCartBtn() {
		this.updateCartBtn.click();
		return new CartPage(this.driver);
	}

	public String getCartRetailPrice() {
		return this.cartRetailPrice.getText();
	}

	public int getCartSize() {
		if (this.isCartEmpty()) {
			return 0;
		}
		// This is ugly. I'm sorry :'''''(
		return Integer.parseInt(this.cartCount.getText().replaceAll("[^0-9]", ""));
	}

	public String getCartTotal() {
		return this.cartTotal.getText();
	}

	public String getCartUnitPrice() {
		return this.cartUnitPrice.getText();
	}

	public String getItemName() {
		return this.cartItemName.getText();
	}

	public int getQuantity() {
		// I just like ints is all
		return Integer.parseInt(this.cartQuantity.getAttribute("value"));
	}

	public String getShippingCountry() {
		return this.shippingCountry.getText();
	}

	public int getShippingZip() {
		// I just like ints is all
		return Integer.parseInt(this.shippingZip.getText());
	}

	public String getSku() {
		return this.cartSku.getText();
	}

	public String getSubtotal() {
		return this.subTotal.getText();
	}

	public void goToCart() {
		LOG.info("CONSUME - OBEY AND CONFORM - WATCH T.V.");
		this.goToUrl(this.baseUrl);
	}

	public boolean isCartEmpty() {
		if (this.cartCount.getText().contains("No Loot")) {
			return true;
		}
		return false;
	}

	public void setQuantity(int quantity) {
		// Ints, ints, they are good for your heart!
		this.cartQuantity.clear();
		this.cartQuantity.sendKeys(String.valueOf(quantity));
	}

	public void setShippingCountry(String country) {
		final Select options = new Select(this.shippingCountry);
		options.selectByVisibleText(country);
	}

	public void setShippingZip(int zip) {
		// Ints, ints, they are good for your heart!
		this.shippingZip.clear();
		this.shippingZip.sendKeys(String.valueOf(zip));
	}

	public void setSku(String sku) {
		final Select options = new Select(this.cartSku);
		options.selectByVisibleText(sku);
	}

	public void toggleFirstDelBtn() {
		// This, check, and uncheck are so we can do whatever our hearts desire
		// I LOVE FREEDOM! AMERICA!
		this.cartDeleteCheckbox.click();
	}

	public void uncheckFirstDelBtn() {
		if (this.cartDeleteCheckbox.isSelected()) {
			this.cartDeleteCheckbox.click();
		}
	}
}
