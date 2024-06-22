package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P012_Checkout extends PageBase
{
    public P012_Checkout(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By BillingNewAddressCountryId = By.id("BillingNewAddress_CountryId");
    private final By BillingNewAddressCity = By.id("BillingNewAddress_City");
    private final By BillingNewAddressAddress1 = By.id("BillingNewAddress_Address1");
    private final By BillingNewAddressAddress2 = By.id("BillingNewAddress_Address2");
    private final By BillingNewAddressZipPostalCode = By.id("BillingNewAddress_ZipPostalCode");
    private final By BillingNewAddressPhoneNumber = By.id("BillingNewAddress_PhoneNumber");
    private final By BillingNewAddressFaxNumber = By.id("BillingNewAddress_FaxNumber");
    private final By continueBtnBillingAddress = By.xpath("//button[@class=\"button-1 new-address-next-step-button\"]");
    private final By continueBtnShippingMethod = By.xpath("//button[@class=\"button-1 shipping-method-next-step-button\"]");
    private final By moneyOrder = By.id("paymentmethod_0");
    private final By creditCard = By.id("paymentmethod_1");
    private final By continuePaymentMethod =  By.xpath("//button[@class=\"button-1 payment-method-next-step-button\"]");
    private final By continuePaymentInformationMoneyOrder = By.xpath("//button[@class=\"button-1 payment-info-next-step-button\"]");
    private final By creditCardType = By.id("CreditCardType");
    private final By cardholderName = By.id("CardholderName");
    private final By cardNumber = By.id("CardNumber");
    private final By expireMonth = By.id("ExpireMonth");
    private final By expireYear = By.id("ExpireYear");
    private final By cardCode = By.id("CardCode");
    private final By confirmOrder = By.xpath("//button[@class=\"button-1 confirm-order-next-step-button\"]");
    private final By clickHereForOrderDetails = By.linkText("Click here for order details.");
    private final By print = By.linkText("Print");
    private final By PDF = By.linkText("PDF Invoice");
    private final By reOrder = By.xpath("//button[@class=\"button-1 re-order-button\"]");
    public void billingAddress()
    {
        waitForElementWithLocatorToBeVisible(driver,BillingNewAddressCountryId);
        select = new Select(driver.findElement(BillingNewAddressCountryId));
        select.selectByVisibleText("Egypt");
        setTextElementText(BillingNewAddressCity,"Cairo");
        setTextElementText(BillingNewAddressAddress1,"El Shorouk City");
        setTextElementText(BillingNewAddressAddress2,"100th Street");
        setTextElementText(BillingNewAddressZipPostalCode,"112233");
        setTextElementText(BillingNewAddressPhoneNumber,"+20111111111");
        setTextElementText(BillingNewAddressFaxNumber,"0222222");
        clickButton(continueBtnBillingAddress);
    }
    public void shippingAddress()
    {
        waitForElementWithLocatorToBeVisible(driver,continueBtnShippingMethod);
        clickButton(continueBtnShippingMethod);
    }
    public void paymentMoneyOrder()
    {
        waitForElementWithLocatorToBeVisible(driver,moneyOrder);
        clickButton(moneyOrder);
        waitForElementWithLocatorToBeVisible(driver,continuePaymentMethod);
        clickButton(continuePaymentMethod);
        waitForElementWithLocatorToBeVisible(driver,continuePaymentInformationMoneyOrder);
        clickButton(continuePaymentInformationMoneyOrder);
        waitForElementWithLocatorToBeVisible(driver,confirmOrder);
        clickButton(confirmOrder);
        waitForElementWithLocatorToBeVisible(driver,clickHereForOrderDetails);
        clickButton(clickHereForOrderDetails);
        waitForElementWithLocatorToBeVisible(driver,print);
        clickButton(print);
        waitForElementWithLocatorToBeVisible(driver,PDF);
        clickButton(PDF);
        waitForElementWithLocatorToBeVisible(driver,reOrder);
        clickButton(reOrder);
    }
    public void anotherPaymentMethod()
    {
        waitForElementWithLocatorToBeVisible(driver,continueBtnBillingAddress);
        clickButton(continueBtnBillingAddress);
    }
    public void paymentCreditCard()
    {
        waitForElementWithLocatorToBeVisible(driver,creditCard);
        clickButton(creditCard);
        waitForElementWithLocatorToBeVisible(driver,continuePaymentMethod);
        clickButton(continuePaymentMethod);
        waitForElementWithLocatorToBeVisible(driver,creditCardType);
        select = new Select(driver.findElement(creditCardType) );
        select.selectByVisibleText("Master card");
        setTextElementText(cardholderName,"Omar Ahmed");
        setTextElementText(cardNumber,"5454123425872569");
        select = new Select(driver.findElement(expireMonth));
        select.selectByVisibleText("02");
        waitForElementWithLocatorToBeVisible(driver,expireYear);
        select = new Select(driver.findElement(expireYear));
        select.selectByVisibleText("2026");
        waitForElementWithLocatorToBeVisible(driver,cardCode);
        setTextElementText(cardCode,"123");
    }
}
