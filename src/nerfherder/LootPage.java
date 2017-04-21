package nerfherder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;

public class LootPage extends BasePage {
	@FindBy(id = "submitcart")
	private WebElement addToCartBtn;

	@FindBy(id = "wish-list-add")
	private WebElement addToWishListBtn;

	@FindBy(xpath = "//p[@class='availability']")
	private WebElement available;

	private final String baseUrl = "https://www.thinkgeek.com/product/";

	@FindBy(xpath = "//h1[@itemprop='name']")
	private WebElement itemName;
	@FindBy(xpath = "//h3[@itemprop='price']")
	private WebElement price;

	private WebElement quantity;

	private WebElement sku;

	public LootPage(WebDriver driver) {
		super(driver);
	}

	public LootPage(WebDriver driver, String prodId) {
		super(driver);
		BasePage.goToUrl(driver, this.baseUrl + prodId);
	}

	public CartPage clickAddToCart() {
		this.addToCartBtn.click();
		return new CartPage(this.driver);
	}

	public String getItemName() {
		// TODO: Select SKU
		return this.itemName.getText();
	}

	public String getPrice() {
		// TODO: Select SKU
		return this.price.getText();
	}

	public int getQuantity() {
		// FYI, I used an int for quantity because I felt it looked better
		// Ints my jam!
		return Integer.parseInt(this.quantity.getAttribute("value"));
	}

	public String getSku() {
		return this.sku.getText();
	}

	public boolean isInStock() {
		if (this.available.getText().contains("In stock")) {
			return true;
		}
		return false;
	}

	// Redo
	public boolean onLootPage() {
		return this.itemName.isDisplayed();
	}

	public void setQuantity(int quantity) {
		// I spy with my little eye, a variable type that starts with Int!
		this.quantity.clear();
		this.quantity.sendKeys(String.valueOf(quantity));
	}

	public void setSku(String sku) {
		final Select options = new Select(this.sku);
		options.selectByVisibleText(sku);
	}
}
