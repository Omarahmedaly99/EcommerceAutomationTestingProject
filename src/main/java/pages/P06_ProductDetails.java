package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P06_ProductDetails extends PageBase
{
    public P06_ProductDetails(WebDriver driver)
    {
        this.driver = driver;
    }
    public By productNameBreadCrumb = By.cssSelector("strong.current-item");
    public By emailAFriend = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[9]/div[3]/button");
    public By productPriceLabel = By.id("price-value-4");
    public By AddYourReview = By.linkText("Add your review");
    private final By addWishListBtn = By.id("add-to-wishlist-button-4");
    private final By clickWishList = By.linkText("wishlist");
    private final By addToCompareBtn = By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[8]/div[2]/button");
    private final By clickProductCompare = By.xpath("//*[@id=\"bar-notification\"]/div/p/a");
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By clickShoppingCart = By.linkText("shopping cart");
    public void clickEmailAFriend()
    {
        clickButton(emailAFriend);
    }
    public void clickAddReview()
    {
        clickButton(AddYourReview);
    }
    public void clickAddProductToWishList()
    {
        clickButton(addWishListBtn);
        clickButton(clickWishList);
    }
    public void clickAddProductToCompareList(){
        clickButton(addToCompareBtn);
        clickButton(clickProductCompare);
    }
    public void clickAddProductToCart()
    {
        clickButton(addToCartBtn);
        clickButton(clickShoppingCart);
    }
}
