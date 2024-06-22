package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P09_WishList extends PageBase
{
    public P09_WishList(WebDriver driver)
    {
        this.driver = driver;
    }
    public By productCell = By.cssSelector("td.product");
    public By wishlistHeader = By.cssSelector("h1");
    private final By addToCartCheckbox = By.xpath("//input[@name=\"addtocart\"]");
    private final By qty = By.xpath("//input[@class=\"qty-input\"]");
    private final By addToCartBtn = By.xpath("//button[@class=\"button-2 wishlist-add-to-cart-button\"]");
    private final By removeBtn = By.xpath("//button[@class=\"remove-btn\"]");
    private final By updateCart = By.id("updatecart");
    public By wishlistIsEmpty = By.xpath("//div[@class=\"no-data\"]");
    public void removeProductFromWishList()
    {
        waitForElementWithLocatorToBeVisible(driver,removeBtn);
        clickButton(removeBtn);
    }
    public void addProductToCartFromWishList()
    {
        waitForElementWithLocatorToBeVisible(driver,addToCartCheckbox);
        clickButton(addToCartCheckbox);
        waitForElementWithLocatorToBeVisible(driver,qty);
        clearDataFromInputField(qty);
        waitForElementWithLocatorToBeVisible(driver,qty);
        setTextElementText(qty,"3");
        waitForElementWithLocatorToBeVisible(driver,updateCart);
        clickButton(updateCart);
        waitForElementWithLocatorToBeVisible(driver,addToCartCheckbox);
        clickButton(addToCartCheckbox);
        waitForElementWithLocatorToBeVisible(driver,addToCartBtn);
        clickButton(addToCartBtn);
    }

}
