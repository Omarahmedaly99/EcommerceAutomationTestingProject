package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class P011_ShoppingCart extends PageBase
{
    public P011_ShoppingCart(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By continueShopping = By.xpath("//*[@id=\"shopping-cart-form\"]/div[2]/div[1]/button[2]");
    private final By estimateShipping = By.id("open-estimate-shipping-popup");
    private final By removeProductFromCart = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]/button");
    private final By giftWrapping = By.id("checkout_attribute_1");
    private final By quantityUp = By.cssSelector("div.quantity.up");
    private final By quantityDown = By.cssSelector("div.quantity.down");
    private final By countrySelect = By.id("CountryId");
    private final By zipPostalCode = By.id("ZipPostalCode");
    private final By ground = By.xpath("//*[@id=\"estimate-shipping-popup\"]/div[4]/div[2]/div[1]/div[2]");
    private final By clickApply = By.xpath("//*[@id=\"estimate-shipping-popup\"]/div[5]/button");
    public By productNameFromCart = By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a");
    public By yourShoppingCartIsEmptyMsg = By.cssSelector("div.no-data");
    private final By termsOfService = By.id("termsofservice");
    private final By clickCheckout = By.id("checkout");
    public void quantityUpOrDownAndChangeGiftWrapping()
    {
        clickButton(quantityUp);
        waitForElementWithLocatorToBeVisible(driver,quantityDown);
        clickButton(quantityDown);
        waitForElementWithLocatorToBeVisible(driver,giftWrapping);
        select = new Select(driver.findElement(giftWrapping));
        select.selectByVisibleText("Yes [+$10.00]");
    }
    public void clickContinueShopping()
    {
        waitForElementWithLocatorToBeVisible(driver,continueShopping);
        clickButton(continueShopping);
    }
    public void removeProduct()
    {
        clickButton(removeProductFromCart);
    }
    public void clickEstimateShipping(String zip)
    {
        waitForElementWithLocatorToBeVisible(driver,estimateShipping);
        clickButton(estimateShipping);
        waitForElementWithLocatorToBeVisible(driver,countrySelect);
        select = new Select(driver.findElement(countrySelect));
        select.selectByVisibleText("Egypt");
        waitForElementWithLocatorToBeVisible(driver,zipPostalCode);
        clickButton(zipPostalCode);
        setTextElementText(zipPostalCode,zip);
        waitForElementWithLocatorToBeVisible(driver,ground);
        clickButton(ground);
        waitForElementWithLocatorToBeVisible(driver,clickApply);
        clickButton(clickApply);
    }
    public void clickTermsOfServiceAndCheckout()
    {
        waitForElementWithLocatorToBeVisible(driver,termsOfService);
        clickButton(termsOfService);
        waitForElementWithLocatorToBeVisible(driver,clickCheckout);
        clickButton(clickCheckout);
    }
}
