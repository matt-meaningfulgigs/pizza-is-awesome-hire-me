package nerfherder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
	private static final Log LOG = LogFactory.getLog(PaymentPage.class);

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

	@FindBy(className = "ajax_sub_total_right")
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

	@FindBy(className = "ajax_ship_address")
	private WebElement orderBtn;

	@FindBy(xpath = "//*[@class='items-summary-header']/p")
	private WebElement orderId;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentCc;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentCcCvc;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentCcExp;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentCcNum;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymentPayPal;

	@FindBy(className = "ajax_ship_address")
	private WebElement paymenyCcBillingAddress;

	@FindBy(className = "ajax_ship_address")
	private WebElement processing;

	@FindBy(id = "form_promo_cert_code")
	private WebElement promoCode;

	@FindBy(id = "form_promo_submit_button")
	private WebElement promoCodeBtn;

	@FindBy(id = "form_svs_pin")
	private WebElement promoCodePin;

	@FindBy(id = "form_svs_pin_checkbox")
	private WebElement promoCodePinCheckbox;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewAddress;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewCancelBtn;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewCloseBtn;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewPlaceOrderBtn;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewShipping;

	@FindBy(className = "ajax_ship_address")
	private WebElement reviewTotal;

	@FindBy(className = "ajax_ship_address")
	private WebElement shippingAddress;

	@FindBy(id = "shipping_method_USEXPEDITED")
	private WebElement shippingExpedited;

	@FindBy(id = "shipping_method_USNEXTDAY")
	private WebElement shippingExpress;

	@FindBy(id = "shipping_method_USSTANDARD")
	private WebElement shippingStandard;

	@FindBy(id = "fancybox-close")
	private WebElement transactionCloseBtn;

	@FindBy(id = "fancybox-inner")
	private WebElement transactionMessage;

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForLineItem(String item){
		BasePage.waitForText(driver, cartLineItem, item, 15);
	}

	public WebElement getCartLineItem() {
		return this.cartLineItem;
	}

	public WebElement getCartLineQuantity() {
		return this.cartLineQuantity;
	}

	public WebElement getCartLineTotal() {
		return this.cartLineTotal;
	}

	public WebElement getCartSalesTax() {
		return this.cartSalesTax;
	}

	public WebElement getCartShipping() {
		return this.cartShipping;
	}

	public WebElement getCartSubtotal() {
		return this.cartSubtotal;
	}

	public WebElement getCartTotal() {
		return this.cartTotal;
	}

	public WebElement getEmailReceipt() {
		return this.emailReceipt;
	}

	public WebElement getGiftMessage() {
		return this.giftMessage;
	}

	public WebElement getGiftMessageBody() {
		return this.giftMessageBody;
	}

	public WebElement getGiftMessageSaveBtn() {
		return this.giftMessageSaveBtn;
	}

	public WebElement getOrderBtn() {
		return this.orderBtn;
	}

	public WebElement getOrderId() {
		return this.orderId;
	}

	public WebElement getPaymentCc() {
		return this.paymentCc;
	}

	public WebElement getPaymentCcCvc() {
		return this.paymentCcCvc;
	}

	public WebElement getPaymentCcExp() {
		return this.paymentCcExp;
	}

	public WebElement getPaymentCcNum() {
		return this.paymentCcNum;
	}

	public WebElement getPaymentPayPal() {
		return this.paymentPayPal;
	}

	public WebElement getPaymenyCcBillingAddress() {
		return this.paymenyCcBillingAddress;
	}

	public WebElement getProcessing() {
		return this.processing;
	}

	public WebElement getPromoCode() {
		return this.promoCode;
	}

	public WebElement getPromoCodeBtn() {
		return this.promoCodeBtn;
	}

	public WebElement getPromoCodePin() {
		return this.promoCodePin;
	}

	public WebElement getPromoCodePinCheckbox() {
		return this.promoCodePinCheckbox;
	}

	public WebElement getReviewAddress() {
		return this.reviewAddress;
	}

	public WebElement getReviewCancelBtn() {
		return this.reviewCancelBtn;
	}

	public WebElement getReviewCloseBtn() {
		return this.reviewCloseBtn;
	}

	public WebElement getReviewPlaceOrderBtn() {
		return this.reviewPlaceOrderBtn;
	}

	public WebElement getReviewShipping() {
		return this.reviewShipping;
	}

	public WebElement getReviewTotal() {
		return this.reviewTotal;
	}

	public WebElement getShippingAddress() {
		return this.shippingAddress;
	}

	public WebElement getShippingExpedited() {
		return this.shippingExpedited;
	}

	public WebElement getShippingExpress() {
		return this.shippingExpress;
	}

	public WebElement getShippingStandard() {
		return this.shippingStandard;
	}

	public WebElement getTransactionMessage() {
		return this.transactionMessage;
	}

	public void setCartLineItem(WebElement cartLineItem) {
		this.cartLineItem = cartLineItem;
	}

	public void setCartLineQuantity(WebElement cartLineQuantity) {
		this.cartLineQuantity = cartLineQuantity;
	}

	public void setCartLineTotal(WebElement cartLineTotal) {
		this.cartLineTotal = cartLineTotal;
	}

	public void setCartSalesTax(WebElement cartSalesTax) {
		this.cartSalesTax = cartSalesTax;
	}

	public void setCartShipping(WebElement cartShipping) {
		this.cartShipping = cartShipping;
	}

	public void setCartSubtotal(WebElement cartSubtotal) {
		this.cartSubtotal = cartSubtotal;
	}

	public void setCartTotal(WebElement cartTotal) {
		this.cartTotal = cartTotal;
	}

	public void setEmailReceipt(WebElement emailReceipt) {
		this.emailReceipt = emailReceipt;
	}

	public void setGiftMessage(WebElement giftMessage) {
		this.giftMessage = giftMessage;
	}

	public void setGiftMessageBody(WebElement giftMessageBody) {
		this.giftMessageBody = giftMessageBody;
	}

	public void setGiftMessageSaveBtn(WebElement giftMessageSaveBtn) {
		this.giftMessageSaveBtn = giftMessageSaveBtn;
	}

	public void setOrderBtn(WebElement orderBtn) {
		this.orderBtn = orderBtn;
	}

	public void setOrderId(WebElement orderId) {
		this.orderId = orderId;
	}

	public void setPaymentCc(WebElement paymentCc) {
		this.paymentCc = paymentCc;
	}

	public void setPaymentCcCvc(WebElement paymentCcCvc) {
		this.paymentCcCvc = paymentCcCvc;
	}

	public void setPaymentCcExp(WebElement paymentCcExp) {
		this.paymentCcExp = paymentCcExp;
	}

	public void setPaymentCcNum(WebElement paymentCcNum) {
		this.paymentCcNum = paymentCcNum;
	}

	public void setPaymentPayPal(WebElement paymentPayPal) {
		this.paymentPayPal = paymentPayPal;
	}

	public void setPaymenyCcBillingAddress(WebElement paymenyCcBillingAddress) {
		this.paymenyCcBillingAddress = paymenyCcBillingAddress;
	}

	public void setProcessing(WebElement processing) {
		this.processing = processing;
	}

	public void setPromoCode(WebElement promoCode) {
		this.promoCode = promoCode;
	}

	public void setPromoCodeBtn(WebElement promoCodeBtn) {
		this.promoCodeBtn = promoCodeBtn;
	}

	public void setPromoCodePin(WebElement promoCodePin) {
		this.promoCodePin = promoCodePin;
	}

	public void setPromoCodePinCheckbox(WebElement promoCodePinCheckbox) {
		this.promoCodePinCheckbox = promoCodePinCheckbox;
	}

	public void setReviewAddress(WebElement reviewAddress) {
		this.reviewAddress = reviewAddress;
	}

	public void setReviewCancelBtn(WebElement reviewCancelBtn) {
		this.reviewCancelBtn = reviewCancelBtn;
	}

	public void setReviewCloseBtn(WebElement reviewCloseBtn) {
		this.reviewCloseBtn = reviewCloseBtn;
	}

	public void setReviewPlaceOrderBtn(WebElement reviewPlaceOrderBtn) {
		this.reviewPlaceOrderBtn = reviewPlaceOrderBtn;
	}

	public void setReviewShipping(WebElement reviewShipping) {
		this.reviewShipping = reviewShipping;
	}

	public void setReviewTotal(WebElement reviewTotal) {
		this.reviewTotal = reviewTotal;
	}

	public void setShippingAddress(WebElement shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void setShippingExpedited(WebElement shippingExpedited) {
		this.shippingExpedited = shippingExpedited;
	}

	public void setShippingExpress(WebElement shippingExpress) {
		this.shippingExpress = shippingExpress;
	}

	public void setShippingStandard(WebElement shippingStandard) {
		this.shippingStandard = shippingStandard;
	}

	public void setTransactionCloseBtn(WebElement reviewCloseBtn) {
		this.reviewCloseBtn = reviewCloseBtn;
	}

	public void setTransactionMessage(WebElement transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
}
