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
    private final By addToCartCheckbox = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[1]/input");
    private final By qty = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input");
    private final By addToCartBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[2]/button[2]");
    private final By removeBtn = By.cssSelector("button.remove-btn");
    private final By updateCart = By.id("updatecart");
    public By wishlistIsEmpty = By.cssSelector("div.no-data");
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
