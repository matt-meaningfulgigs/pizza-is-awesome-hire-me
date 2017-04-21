package nerfherder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CartPage extends BasePage {
	private static final Log LOG = LogFactory.getLog(CartPage.class); 
	private String baseUrl = "http://www.thinkgeek.com/brain/loot.cgi";
	
	@FindBy(className="topnav_cart_count")
	private WebElement cartCount;

	@FindBy(xpath="//*[contains(@class,'loot-header')]//a[contains(.,'Checkout')]")
	private WebElement topCheckoutBtn;
	
	//There would be more rows with multiple items, so these wouldn't work in that case
	@FindBy(name="0_del")
	private WebElement cartDeleteCheckbox;
	
	@FindBy(className="cart-line-name")
	private WebElement cartItemName;

	@FindBy(name="0_qty")
	private WebElement cartQuantity;

	@FindBy(name="0_sku")
	private WebElement cartSku;
	
	@FindBy(xpath="//*[@class='cart-table-row ']//td[contains(.,'$')][1]")
	private WebElement cartRetailPrice;

	@FindBy(xpath="//*[@class='cart-table-row ']//td[contains(.,'$')][2]")
	private WebElement cartUnitPrice;

	@FindBy(xpath="//*[@class='cart-table-row ']//td[contains(.,'$')][3]")
	private WebElement cartTotal;

	@FindBy(xpath="//*[@value='Update Cart']")
	private WebElement updateCartBtn;
	
	@FindBy(className="cart-subtotal-amount")
	private WebElement subTotal;

	@FindBy(xpath="//*[contains(@class,'cart-nav')]//a[contains(.,'Continue')]")
	private WebElement continueShoppingBtn;
	
	@FindBy(xpath="//*[contains(@class,'cart-nav')]//a[contains(.,'Checkout')]")
	private WebElement bottomCheckoutBtn;
	
	@FindBy(xpath="//*[@name='us_zip")
	private WebElement shippingZip;
	
	@FindBy(xpath="//*[@name='country']")
	private WebElement shippingCountry;
	
	@FindBy(xpath="//input[@value='Get estimate']")
	private WebElement getEstimateBtn;
	
	public CartPage(WebDriver driver){
		super(driver);
	}
	
	public void goToCart(){
		LOG.info("CONSUME - OBEY AND CONFORM - WATCH T.V.");
		goToUrl(baseUrl);
	}
	
	public boolean isCartEmpty(){
		if(cartCount.getText().contains("No Loot")){
			return true;
		}
		return false;
	}
	
	public int getCartSize(){
		if(isCartEmpty()){
			return 0;
		}
		// This is ugly. I'm sorry :'''''(
		return Integer.parseInt(cartCount.getText().replaceAll("[^0-9]", ""));
	}
	
	public CheckoutAddressPage clickTopCheckoutBtn(){
		topCheckoutBtn.click();
		return new CheckoutAddressPage(driver);
	}
	
	public void toggleFirstDelBtn(){
		// This, check, and uncheck are so we can do whatever our hearts desire
		// I LOVE FREEDOM! AMERICA!
		cartDeleteCheckbox.click();
	}
	
	public void checkFirstDelBtn(){
		if(!cartDeleteCheckbox.isSelected()){
			cartDeleteCheckbox.click();
		}
	}
	
	public void uncheckFirstDelBtn(){
		if(cartDeleteCheckbox.isSelected()){
			cartDeleteCheckbox.click();
		}
	}
	
	public String getItemName(){
		return this.cartItemName.getText();
	}
	
	public int getQuantity(){
		// I just like ints is all
		return Integer.parseInt(cartQuantity.getText());
	}
	
	public void setQuantity(int quantity){
		// Ints, ints, they are good for your heart!
		this.cartQuantity.clear();
		this.cartQuantity.sendKeys(String.valueOf(quantity));
	}
	
	public String getSku(){
		return cartSku.getText();
	}
	
	public void setSku(String sku){
		Select options = new Select(this.cartSku);
		options.selectByVisibleText(sku);
	}
	
	public String getCartRetailPrice(){
		return this.cartRetailPrice.getText();
	}
	
	public String getCartUnitPrice(){
		return this.cartUnitPrice.getText();
	}
	
	public String getCartTotal(){
		return this.cartTotal.getText();
	}
	
	public CartPage clickUpdateCartBtn(){
		updateCartBtn.click();
		return new CartPage(driver);
	}
	
	public String getSubtotal(){
		return this.subTotal.getText();
	}
	
	public void clickContinueShoppingBtn(){
		// I didn't get a chance to make a page for the item list pages
		// So this is all you get
		continueShoppingBtn.click();
	}
	
	public CheckoutAddressPage clickBottomCheckoutBtn(){
		bottomCheckoutBtn.click();
		return new CheckoutAddressPage(driver);
	}
	
	public int getShippingZip(){
		// I just like ints is all
		return Integer.parseInt(shippingZip.getText());
	}
	
	public void setShippingZip(int zip){
		// Ints, ints, they are good for your heart!
		this.shippingZip.clear();
		this.shippingZip.sendKeys(String.valueOf(zip));
	}
	
	public String getShippingCountry(){
		return shippingCountry.getText();
	}
	
	public void setShippingCountry(String country){
		Select options = new Select(this.shippingCountry);
		options.selectByVisibleText(country);
	}
	
	public CartPage clickGetEstimateBtn(){
		getEstimateBtn.click();
		return new CartPage(driver);
	}
}
