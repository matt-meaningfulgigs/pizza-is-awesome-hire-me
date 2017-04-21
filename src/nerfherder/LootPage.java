package nerfherder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.Select;

public class LootPage extends BasePage{
	private String baseUrl = "https://www.thinkgeek.com/product/";
		
	@FindBy(xpath="//h1[@itemprop='name']")
	private WebElement itemName;

	@FindBy(xpath="//h3[@itemprop='price']")
	private WebElement price;
	
	@FindBy(xpath="//p[@class='availability']")
	private WebElement available;
	
	private WebElement sku;
	private WebElement quantity;
	
	@FindBy(id="submitcart")
	private WebElement addToCartBtn;
	
	@FindBy(id="wish-list-add")
	private WebElement addToWishListBtn;

	public LootPage(WebDriver driver){
		super(driver);
	}
	
	public LootPage(WebDriver driver, String prodId){
		super(driver);
		BasePage.goToUrl(driver, baseUrl+prodId);
	}

	// Redo
	public boolean onLootPage(){
		return this.itemName.isDisplayed();
	}
	
	public String getItemName(){
		// TODO: Select SKU
		return this.itemName.getText();
	}
	
	public String getPrice(){
		// TODO: Select SKU
		return this.price.getText();
	}
	
	public boolean isInStock(){
		if(available.getText().contains("In stock")){
			return true;
		}
		return false;
	}
	
	public String getSku(){
		return this.sku.getText();
	}
	
	public void setSku(String sku){
		Select options = new Select(this.sku);
		options.selectByVisibleText(sku);
	}
	
	public int getQuantity(){
		// FYI, I used an int for quantity because I felt it looked better
		// Ints my jam!
		return Integer.parseInt(this.quantity.getText());
	}
	
	public void setQuantity(int quantity){
		// I spy with my little eye, a variable type that starts with Int!
		this.quantity.clear();
		this.quantity.sendKeys(String.valueOf(quantity));
	}
	
	public CartPage clickAddToCart(){
		addToCartBtn.click();
		return new CartPage(driver);
	}
}
