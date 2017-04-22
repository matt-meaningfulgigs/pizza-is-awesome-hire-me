package nerfherder;

import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
	@FindBy(xpath = "//*[@class='container_cart_line']//*[@class='ajax_cart_line_item_name']")
	private WebElement cartLineItem;

	@FindBy(xpath = "//*[@class='container_cart_line']//*[@class='ajax_cart_line_quantity']")
	private WebElement cartLineQuantity;

	@FindBy(xpath = "//*[@class='container_cart_line']//*[@class='ajax_cart_line_total']")
	private WebElement cartLineTotal;

	@FindBy(className = "ajax_sales_tax")
	private WebElement cartSalesTax;

	@FindBy(xpath = "//*[@id='order_summary_shipping']//*[@class='ajax_shipping']")
	private WebElement cartShipping;

	@FindBy(xpath = "//*[contains(@class,'ajax_sub_total')]")
	private WebElement cartSubtotal;

	@FindBy(xpath = "//*[@id='order_summary_total']//*[@class='ajax_total']")
	private WebElement cartTotal;

	@FindBy(className = "ajax_ship_address")
	private WebElement emailReceipt;

	@FindBy(id = "form_has_gift_message")
	private WebElement giftMessage;

	@FindBy(id = "ajax_gift_message_edit")
	private WebElement giftMessageBody;

	@FindBy(id = "form_gift_message_submit")
	private WebElement giftMessageSaveBtn;

	@FindBy(xpath = "//*[contains(@class,'confirm_payment')]")
	private WebElement orderBtn;

	@FindBy(xpath = "//*[@class='items-summary-header']/p")
	private WebElement orderId;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentCc;

	@FindBy(id = "form_pay_validation_new")
	private WebElement paymentCcCvc;

	@FindBy(id = "form_pay_expiration_month")
	private WebElement paymentCcExpMonth;

	@FindBy(id = "form_pay_expiration_year")
	private WebElement paymentCcExpYear;

	@FindBy(id = "form_pay_number")
	private WebElement paymentCcNum;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentPayPal;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymenyCcBillingAddress;

	private WebElement processing;

	@FindBy(id = "form_promo_cert_code")
	private WebElement promoCode;

	@FindBy(id = "form_promo_submit_button")
	private WebElement promoCodeBtn;

	@FindBy(id = "form_svs_pin")
	private WebElement promoCodePin;

	@FindBy(id = "form_svs_pin_checkbox")
	private WebElement promoCodePinCheckbox;

	@FindBy(id = "confirm_box_display_address")
	private WebElement reviewAddress;

	@FindBy(id = "form_cancel_order")
	private WebElement reviewCancelBtn;

	@FindBy(id = "fancybox-close")
	private WebElement reviewCloseBtn;

	@FindBy(id = "form_place_final_order")
	private WebElement reviewPlaceOrderBtn;

	@FindBy(xpath = "//*[@class='confirm-summary']//*[@class='ajax_shipping_method_name']")
	private WebElement reviewShipping;

	@FindBy(id = "verify_total")
	private WebElement reviewTotal;

	@FindBy(className = "ajax_ship_address")
	private WebElement shippingAddress;

	@FindBy(xpath = "//label[@for='shipping_method_USEXPEDITED']")
	private WebElement shippingExpedited;

	@FindBy(xpath = "//label[@for='shipping_method_USNEXTDAY']")
	private WebElement shippingExpress;

	@FindBy(xpath = "//label[@for='shipping_method_USSTANDARD']")
	private WebElement shippingStandard;
	
	@FindBy(xpath = "//div[@id='warpspeed-wrapper' and @class='is-loading']")
	private WebElement spinner;

	@FindBy(id = "fancybox-close")
	private WebElement transactionCloseBtn;

	@FindBy(id = "fancybox-inner")
	private WebElement transactionMessage;
	

	public PaymentPage(WebDriver driver) {
		super(driver);
	}

	public void fillCardInfo(HashMap<String, String> card) {
		this.setPaymentCcNum(card.get("number"));
		this.setPaymentCcExpMonth(card.get("expMonth"));
		this.setPaymentCcExpYear(card.get("expYear"));
		this.setPaymentCcCvc(card.get("cvc"));
	}

	public void clickGiftMessage() {
		this.giftMessage.click();
	}

	public void clickGiftMessageSaveBtn() {
		this.giftMessageSaveBtn.click();
	}

	public void clickOrderBtn() {
		this.orderBtn.click();
	}

	public void clickPaymentCc() {
		this.paymentCc.click();
	}

	public void clickPaymentPayPal() {
		this.paymentPayPal.click();
	}

	public void clickPromoCodeBtn() {
		this.promoCodeBtn.click();
	}

	public void clickPromoCodePinCheckbox() {
		this.promoCodePinCheckbox.click();
	}

	public void clickReviewCancelBtn() {
		this.reviewCancelBtn.click();
	}

	public void clickReviewCloseBtn() {
		this.reviewCloseBtn.click();
	}

	public void clickReviewPlaceOrderBtn() {
		this.reviewPlaceOrderBtn.click();
	}

	public void clickShippingExpedited() {
		this.shippingExpedited.click();
		BasePage.waitForElementPresent(driver, By.xpath("//div[@class='is-loading']"), 15);
		BasePage.waitForElementNotVisible(driver, By.xpath("//div[@class='is-loading']"), 15);
	}

	public void clickShippingExpress() {
		this.shippingExpress.click();
		BasePage.waitForElementPresent(driver, By.xpath("//div[@class='is-loading']"), 15);
		BasePage.waitForElementNotVisible(driver, By.xpath("//div[@class='is-loading']"), 15);
	}

	public void clickShippingStandard() {
		this.shippingStandard.click();
		BasePage.waitForElementPresent(driver, By.xpath("//div[@class='is-loading']"), 15);
		BasePage.waitForElementNotVisible(driver, By.xpath("//div[@class='is-loading']"), 15);
	}

	public void clickTransactionCloseBtn() {
		this.reviewCloseBtn.click();
	}

	public String getCartLineItem() {
		return this.cartLineItem.getText();
	}

	public String getCartLineQuantity() {
		return this.cartLineQuantity.getText();
	}

	public String getCartLineTotal() {
		return this.cartLineTotal.getText();
	}

	public String getCartSalesTax() {
		return this.cartSalesTax.getText();
	}

	public String getCartShipping() {
		return this.cartShipping.getText();
	}

	public String getCartSubtotal() {
		return this.cartSubtotal.getText();
	}

	public String getCartTotal() {
		return this.cartTotal.getText();
	}

	public String getEmailReceipt() {
		return this.emailReceipt.getText();
	}

	public String getGiftMessage() {
		return this.giftMessage.getText();
	}

	public String getGiftMessageBody() {
		return this.giftMessageBody.getText();
	}

	public String getOrderId() {
		return this.orderId.getText();
	}

	public String getPaymentCcCvc() {
		return this.paymentCcCvc.getText();
	}

	public String getPaymentCcExpMonth() {
		return this.paymentCcExpMonth.getText();
	}

	public String getPaymentCcExpYear() {
		return this.paymentCcExpYear.getText();
	}

	public String getPaymentCcNum() {
		return this.paymentCcNum.getText();
	}

	public String getPaymenyCcBillingAddress() {
		return this.paymenyCcBillingAddress.getText();
	}

	public void waitForProcessing() {
		BasePage.waitForElementPresent(driver, By.id("processing"), 15);
		BasePage.waitForElementNotVisible(driver, By.id("processing"), 15);
	}

	public void waitForTransactionMessage() {
		BasePage.waitForElementVisible(driver, transactionMessage, 15);
	}

	public String getPromoCode() {
		return this.promoCode.getText();
	}

	public String getPromoCodePin() {
		return this.promoCodePin.getText();
	}

	public String getReviewAddress() {
		return this.reviewAddress.getText();
	}

	public String getReviewShipping() {
		return this.reviewShipping.getText();
	}

	public String getReviewTotal() {
		return this.reviewTotal.getText();
	}

	public String getShippingAddress() {
		return this.shippingAddress.getText();
	}

	public String getTransactionMessage() {
		return this.transactionMessage.getText();
	}

	public void setGiftMessageBody(String message) {
		this.giftMessageBody.clear();
		this.giftMessageBody.sendKeys(message);
	}

	public void setPaymentCcCvc(String cvc) {
		this.paymentCcCvc.clear();
		this.paymentCcCvc.sendKeys(cvc);
	}

	public void setPaymentCcExpMonth(String month) {
		this.paymentCcExpMonth.clear();
		this.paymentCcExpMonth.sendKeys(month);
	}

	public void setPaymentCcExpYear(String year) {
		this.paymentCcExpYear.clear();
		this.paymentCcExpYear.sendKeys(year);
	}

	public void setPaymentCcNum(String number) {
		this.paymentCcNum.clear();
		this.paymentCcNum.sendKeys(number);
	}

	public void setPromoCode(String code) {
		this.promoCode.clear();
		this.promoCode.sendKeys(code);
	}

	public void setPromoCodePin(String pin) {
		this.promoCodePin.clear();
		this.promoCodePin.sendKeys(pin);
	}

	public void waitForLineItem(String item) {
		BasePage.waitForText(this.driver, this.cartLineItem, item, 15);
	}
}
