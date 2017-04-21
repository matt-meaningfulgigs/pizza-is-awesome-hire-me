package nerfherder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutAddressPage extends BasePage {
	@FindBy(xpath="//*[@id='loginbox']//*[@name='un']")
	private WebElement loginEmail;
	
	@FindBy(xpath="//*[@id='loginbox']//*[@name='pass']")
	private WebElement loginPass;
	
	@FindBy(xpath="//*[@id='loginbox']//*[@name='continue_button']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(.,'Forgot your password?')]")
	private WebElement loginForgotPass;
	
	@FindBy(id="form_bill_country")
	private WebElement billCountry;
	
	@FindBy(id="form_bill_name_first")
	private WebElement billFirstName;
	
	@FindBy(id="form_bill_name_last")
	private WebElement billLastName;
	
	@FindBy(id="form_bill_company")
	private WebElement billCompany;
	
	@FindBy(id="form_bill_street_0")
	private WebElement billAddress;
	
	@FindBy(id="form_bill_street_1")
	private WebElement billAddress2;
	
	@FindBy(id="form_bill_city")
	private WebElement billCity;
	
	@FindBy(id="form_bill_state")
	private WebElement billState;
	
	@FindBy(id="form_bill_zip")
	private WebElement billZip;
	
	@FindBy(id="form_bill_phone")
	private WebElement billPhone;

	// Just checking if anyone is actually reading these. Hi!
	
	@FindBy(id="form_billing_email")
	private WebElement billEmail;
	
	@FindBy(id="form_send_newsletter")
	private WebElement joinNewsletter;
	
	@FindBy(id="copy_billing")
	private WebElement copyBilling;
	
	@FindBy(id="form_ship_country")
	private WebElement shipCountry;
	
	@FindBy(id="form_ship_name_first")
	private WebElement shipFirstName;
	
	@FindBy(id="form_ship_name_last")
	private WebElement shipLastName;
	
	@FindBy(id="form_ship_company")
	private WebElement shipCompany;
	
	@FindBy(id="form_ship_street_0")
	private WebElement shipAddress;
	
	@FindBy(id="form_ship_street_1")
	private WebElement shipAddress2;
	
	@FindBy(id="form_ship_city")
	private WebElement shipCity;
	
	@FindBy(id="form_ship_state")
	private WebElement shipState;
	
	@FindBy(id="form_ship_zip")
	private WebElement shipZip;
	
	@FindBy(id="form_ship_phone")
	private WebElement shipPhone;
	
	@FindBy(id="form_create_account_password")
	private WebElement createAccountPass;
	
	@FindBy(id="form_create_account_password_confirmation")
	private WebElement createAccountPassConfirm;
	
	@FindBy(id="form_create_account_hint")
	private WebElement createAccountHint;
	
	@FindBy(xpath="//button[contains(.,'Go to Checkout!')]")
	private WebElement checkoutBtn;
	
	public CheckoutAddressPage(WebDriver driver){
		super(driver);
	}

	public String getLoginEmail(){
		return this.loginEmail.getText();
	}
	
	public void setLoginEmail(String email){
		this.loginEmail.clear();
		this.loginEmail.sendKeys(email);
	}

	public String getloginPass(){
		return this.loginPass.getText();
	}
	
	public void setLoginPass(String pass){
		this.loginPass.clear();
		this.loginPass.sendKeys(pass);
	}

	// TODO: If I had time, I'd make a real login page
	public void clickLoginBtn(){
		this.loginBtn.click();
	}
	
	// TODO: Not this because it doesn't really matter for now
	public void clickLoginForgotPass(){
		this.loginForgotPass.click();
	}
	
	public String getBillCountry(){
		return this.billCountry.getText();
	}
	
	public void setBillCountry(String country){
		Select options = new Select(this.billCountry);
		BasePage.waitForText(driver, billCountry, country, 5);
		options.selectByVisibleText(country);
	}

	public String getBillFirstName(){
		return this.billFirstName.getText();
	}
	
	public void setBillFirstName(String first){
		this.billFirstName.clear();
		this.billFirstName.sendKeys(first);
	}

	public String getBillLastName(){
		return this.billLastName.getText();
	}
	
	public void setBillLastName(String last){
		this.billLastName.clear();
		this.billLastName.sendKeys(last);
	}

	public String getBillCompany(){
		return this.billCompany.getText();
	}
	
	public void setBillCompany(String company){
		this.billCompany.clear();
		this.billCompany.sendKeys(company);
	}

	public String getBillAddress(){
		return this.billAddress.getText();
	}
	
	public void setBillAddress(String address){
		this.billAddress.clear();
		this.billAddress.sendKeys(address);
	}

	public String getBillAddress2(){
		return this.billAddress2.getText();
	}
	
	public void setBillAddress2(String address){
		this.billAddress2.clear();
		this.billAddress2.sendKeys(address);
	}

	public String getBillCity(){
		return this.billCity.getText();
	}
	
	public void setBillCity(String city){
		this.billCity.clear();
		this.billCity.sendKeys(city);
	}

	public String getBillState(){
		return this.billState.getText();
	}
	
	public void setBillState(String state){
		Select options = new Select(this.billState);
		BasePage.waitForText(driver, billState, state, 5);
		options.selectByVisibleText(state);
	}

	public String getBillZip(){
		return this.billZip.getText();
	}
	
	public void setBillZip(String zip){
		this.billZip.clear();
		this.billZip.sendKeys(zip);
	}

	public String getBillPhone(){
		return this.billPhone.getText();
	}
	
	public void setBillPhone(String phone){
		this.billPhone.clear();
		this.billPhone.sendKeys(phone);
	}

	public String getBillEmail(){
		return this.billEmail.getText();
	}
	
	public void setBillEmail(String email){
		this.billEmail.clear();
		this.billEmail.sendKeys(email);
	}
	
	public void toggleNewsletter(){
		joinNewsletter.click();
	}
	
	public void checkNewsletter(){
		if(!joinNewsletter.isSelected()){
			joinNewsletter.click();
		}
	}
	
	public void uncheckNewsletter(){
		if(joinNewsletter.isSelected()){
			joinNewsletter.click();
		}
	}
	
	public void toggleCopyBilling(){
		copyBilling.click();
	}
	
	public void checkCopyBilling(){
		if(!copyBilling.isSelected()){
			copyBilling.click();
		}
	}
	
	public void uncheckCopyBilling(){
		if(copyBilling.isSelected()){
			copyBilling.click();
		}
	}
	
	public String getShipCountry(){
		return this.shipCountry.getText();
	}
	
	public void setShipCountry(String country){
		Select options = new Select(this.shipCountry);
		BasePage.waitForText(driver, shipCountry, country, 5);
		options.selectByVisibleText(country);
	}

	public String getShipFirstName(){
		return this.shipFirstName.getText();
	}
	
	public void setShipFirstName(String first){
		this.shipFirstName.clear();
		this.shipFirstName.sendKeys(first);
	}

	public String getShipLastName(){
		return this.shipLastName.getText();
	}
	
	public void setShipLastName(String last){
		this.shipLastName.clear();
		this.shipLastName.sendKeys(last);
	}

	public String getShipCompany(){
		return this.shipCompany.getText();
	}
	
	public void setShipCompany(String company){
		this.shipCompany.clear();
		this.shipCompany.sendKeys(company);
	}

	public String getShipAddress(){
		return this.shipAddress.getText();
	}
	
	public void setShipAddress(String address){
		this.shipAddress.clear();
		this.shipAddress.sendKeys(address);
	}

	public String getShipAddress2(){
		return this.shipAddress2.getText();
	}
	
	public void setShipAddress2(String address){
		this.shipAddress2.clear();
		this.shipAddress2.sendKeys(address);
	}

	public String getShipCity(){
		return this.shipCity.getText();
	}
	
	public void setShipCity(String city){
		this.shipCity.clear();
		this.shipCity.sendKeys(city);
	}

	public String getShipState(){
		return this.shipState.getText();
	}
	
	public void setShipState(String state){
		Select options = new Select(this.shipState);
		BasePage.waitForText(driver, shipState, state, 5);
		options.selectByVisibleText(state);
	}

	public String getShipZip(){
		return this.shipZip.getText();
	}
	
	public void setShipZip(String zip){
		this.shipZip.clear();
		this.shipZip.sendKeys(zip);
	}

	public String getShipPhone(){
		return this.shipPhone.getText();
	}
	
	public void setShipPhone(String phone){
		this.shipPhone.clear();
		this.shipPhone.sendKeys(phone);
	}

	public String getCreateAccountPass(){
		return this.createAccountPass.getText();
	}
	
	public void setCreateAccountPass(String pass){
		this.createAccountPass.clear();
		this.createAccountPass.sendKeys(pass);
	}

	public String getCreateAccountPassConfirm(){
		return this.createAccountPassConfirm.getText();
	}
	
	public void setCreateAccountPassConfirm(String pass){
		this.createAccountPassConfirm.clear();
		this.createAccountPassConfirm.sendKeys(pass);
	}

	public String getCreateAccountHint(){
		return this.createAccountHint.getText();
	}
	
	public void setCreateAccountHint(String hint){
		this.createAccountHint.clear();
		this.createAccountHint.sendKeys(hint);
	}
	
	public void clickCheckoutBtn(){
		this.checkoutBtn.click();
	}
}
