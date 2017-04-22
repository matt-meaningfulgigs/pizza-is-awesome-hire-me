package nerfherder;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutAddressPage extends BasePage {
	@FindBy(id = "form_bill_street_0")

	private WebElement billAddress;

	@FindBy(id = "form_bill_street_1")
	private WebElement billAddress2;

	@FindBy(id = "form_bill_city")
	private WebElement billCity;

	@FindBy(id = "form_bill_company")
	private WebElement billCompany;

	@FindBy(id = "form_bill_country")
	private WebElement billCountry;

	@FindBy(id = "form_billing_email")
	private WebElement billEmail;

	@FindBy(id = "form_bill_name_first")
	private WebElement billFirstName;

	@FindBy(id = "form_bill_name_last")
	private WebElement billLastName;

	@FindBy(id = "form_bill_phone")
	private WebElement billPhone;

	@FindBy(id = "form_bill_state")
	private WebElement billState;

	@FindBy(id = "form_bill_zip")
	private WebElement billZip;

	@FindBy(xpath = "//button[contains(.,'Go to Checkout!')]")
	private WebElement checkoutBtn;

	@FindBy(id = "copy_billing")
	private WebElement copyBilling;

	@FindBy(id = "form_create_account_hint")
	private WebElement createAccountHint;

	// Just checking if anyone is actually reading these. Hi!

	@FindBy(id = "form_create_account_password")
	private WebElement createAccountPass;

	@FindBy(id = "form_create_account_password_confirmation")
	private WebElement createAccountPassConfirm;

	@FindBy(id = "form_send_newsletter")
	private WebElement joinNewsletter;

	@FindBy(xpath = "//*[@id='loginbox']//*[@name='continue_button']")
	private WebElement loginBtn;

	@FindBy(xpath = "//*[@id='loginbox']//*[@name='un']")
	private WebElement loginEmail;

	@FindBy(xpath = "//a[contains(.,'Forgot your password?')]")
	private WebElement loginForgotPass;

	@FindBy(xpath = "//*[@id='loginbox']//*[@name='pass']")
	private WebElement loginPass;

	@FindBy(id = "form_ship_street_0")
	private WebElement shipAddress;

	@FindBy(id = "form_ship_street_1")
	private WebElement shipAddress2;

	@FindBy(id = "form_ship_city")
	private WebElement shipCity;

	@FindBy(id = "form_ship_company")
	private WebElement shipCompany;

	@FindBy(id = "form_ship_country")
	private WebElement shipCountry;

	@FindBy(id = "form_ship_name_first")
	private WebElement shipFirstName;

	@FindBy(id = "form_ship_name_last")
	private WebElement shipLastName;

	@FindBy(id = "form_ship_phone")
	private WebElement shipPhone;

	@FindBy(id = "form_ship_state")
	private WebElement shipState;

	@FindBy(id = "form_ship_zip")
	private WebElement shipZip;

	public CheckoutAddressPage(WebDriver driver) {
		super(driver);
	}

	public void checkCopyBilling() {
		if (!this.copyBilling.isSelected()) {
			this.copyBilling.click();
		}
	}

	public void checkNewsletter() {
		if (!this.joinNewsletter.isSelected()) {
			this.joinNewsletter.click();
		}
	}

	public PaymentPage clickCheckoutBtn() {
		this.checkoutBtn.click();
		return new PaymentPage(this.driver);
	}

	// TODO: If I had time, I'd make a real login page
	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// TODO: Not this because it doesn't really matter for now
	public void clickLoginForgotPass() {
		this.loginForgotPass.click();
	}

	public void fillBillingInfo(HashMap<String, String> person) {
		this.setBillCountry(person.get("country"));
		this.setBillFirstName(person.get("first"));
		this.setBillLastName(person.get("last"));
		this.setBillCompany(person.get("company"));
		this.setBillAddress(person.get("address"));
		this.setBillCity(person.get("city"));
		this.setBillState(person.get("state"));
		this.setBillZip(person.get("zip"));
		this.setBillPhone(person.get("phone"));
		this.setBillEmail(person.get("email"));
	}

	public String getBillAddress() {
		return this.billAddress.getText();
	}

	public String getBillAddress2() {
		return this.billAddress2.getText();
	}

	public String getBillCity() {
		return this.billCity.getText();
	}

	public String getBillCompany() {
		return this.billCompany.getText();
	}

	public String getBillCountry() {
		return this.billCountry.getText();
	}

	public String getBillEmail() {
		return this.billEmail.getText();
	}

	public String getBillFirstName() {
		return this.billFirstName.getText();
	}

	public String getBillLastName() {
		return this.billLastName.getText();
	}

	public String getBillPhone() {
		return this.billPhone.getText();
	}

	public String getBillState() {
		return this.billState.getText();
	}

	public String getBillZip() {
		return this.billZip.getText();
	}

	public String getCreateAccountHint() {
		return this.createAccountHint.getText();
	}

	public String getCreateAccountPass() {
		return this.createAccountPass.getText();
	}

	public String getCreateAccountPassConfirm() {
		return this.createAccountPassConfirm.getText();
	}

	public String getLoginEmail() {
		return this.loginEmail.getText();
	}

	public String getloginPass() {
		return this.loginPass.getText();
	}

	public String getShipAddress() {
		return this.shipAddress.getText();
	}

	public String getShipAddress2() {
		return this.shipAddress2.getText();
	}

	public String getShipCity() {
		return this.shipCity.getText();
	}

	public String getShipCompany() {
		return this.shipCompany.getText();
	}

	public String getShipCountry() {
		return this.shipCountry.getText();
	}

	public String getShipFirstName() {
		return this.shipFirstName.getText();
	}

	public String getShipLastName() {
		return this.shipLastName.getText();
	}

	public String getShipPhone() {
		return this.shipPhone.getText();
	}

	public String getShipState() {
		return this.shipState.getText();
	}

	public String getShipZip() {
		return this.shipZip.getText();
	}

	public void setBillAddress(String address) {
		this.billAddress.clear();
		this.billAddress.sendKeys(address);
	}

	public void setBillAddress2(String address) {
		this.billAddress2.clear();
		this.billAddress2.sendKeys(address);
	}

	public void setBillCity(String city) {
		this.billCity.clear();
		this.billCity.sendKeys(city);
	}

	public void setBillCompany(String company) {
		this.billCompany.clear();
		this.billCompany.sendKeys(company);
	}

	public void setBillCountry(String country) {
		final Select options = new Select(this.billCountry);
		BasePage.waitForText(this.driver, this.billCountry, country, 5);
		options.selectByVisibleText(country);
	}

	public void setBillEmail(String email) {
		this.billEmail.clear();
		this.billEmail.sendKeys(email);
	}

	public void setBillFirstName(String first) {
		this.billFirstName.clear();
		this.billFirstName.sendKeys(first);
	}

	public void setBillLastName(String last) {
		this.billLastName.clear();
		this.billLastName.sendKeys(last);
	}

	public void setBillPhone(String phone) {
		this.billPhone.clear();
		this.billPhone.sendKeys(phone);
	}

	public void setBillState(String state) {
		final Select options = new Select(this.billState);
		BasePage.waitForText(this.driver, this.billState, state, 5);
		options.selectByVisibleText(state);
	}

	public void setBillZip(String zip) {
		this.billZip.clear();
		this.billZip.sendKeys(zip);
	}

	public void setCreateAccountHint(String hint) {
		this.createAccountHint.clear();
		this.createAccountHint.sendKeys(hint);
	}

	public void setCreateAccountPass(String pass) {
		this.createAccountPass.clear();
		this.createAccountPass.sendKeys(pass);
	}

	public void setCreateAccountPassConfirm(String pass) {
		this.createAccountPassConfirm.clear();
		this.createAccountPassConfirm.sendKeys(pass);
	}

	public void setLoginEmail(String email) {
		this.loginEmail.clear();
		this.loginEmail.sendKeys(email);
	}

	public void setLoginPass(String pass) {
		this.loginPass.clear();
		this.loginPass.sendKeys(pass);
	}

	public void setShipAddress(String address) {
		this.shipAddress.clear();
		this.shipAddress.sendKeys(address);
	}

	public void setShipAddress2(String address) {
		this.shipAddress2.clear();
		this.shipAddress2.sendKeys(address);
	}

	public void setShipCity(String city) {
		this.shipCity.clear();
		this.shipCity.sendKeys(city);
	}

	public void setShipCompany(String company) {
		this.shipCompany.clear();
		this.shipCompany.sendKeys(company);
	}

	public void setShipCountry(String country) {
		final Select options = new Select(this.shipCountry);
		BasePage.waitForText(this.driver, this.shipCountry, country, 5);
		options.selectByVisibleText(country);
	}

	public void setShipFirstName(String first) {
		this.shipFirstName.clear();
		this.shipFirstName.sendKeys(first);
	}

	public void setShipLastName(String last) {
		this.shipLastName.clear();
		this.shipLastName.sendKeys(last);
	}

	public void setShipPhone(String phone) {
		this.shipPhone.clear();
		this.shipPhone.sendKeys(phone);
	}

	public void setShipState(String state) {
		final Select options = new Select(this.shipState);
		BasePage.waitForText(this.driver, this.shipState, state, 5);
		options.selectByVisibleText(state);
	}

	public void setShipZip(String zip) {
		this.shipZip.clear();
		this.shipZip.sendKeys(zip);
	}

	public void toggleCopyBilling() {
		this.copyBilling.click();
	}

	public void toggleNewsletter() {
		this.joinNewsletter.click();
	}

	public void uncheckCopyBilling() {
		if (this.copyBilling.isSelected()) {
			this.copyBilling.click();
		}
	}

	public void uncheckNewsletter() {
		if (this.joinNewsletter.isSelected()) {
			this.joinNewsletter.click();
		}
	}
}
