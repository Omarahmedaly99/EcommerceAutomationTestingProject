package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P06_ProductDetails;
import pages.P05_Search;
import pages.P011_ShoppingCart;

public class T013_ShoppingCart extends TestBase
{
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    P011_ShoppingCart cartObject;
    String productName = "Apple MacBook Pro 13-inch";
    String zip = "123456";
    @BeforeMethod
    public void f()
    {
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        cartObject = new P011_ShoppingCart(driver);
        searchObject.SearchUsingAutoSuggest("MacBook");
        detailsObject.clickAddProductToCart();
        cartObject.quantityUpOrDownAndChangeGiftWrapping();
        Assert.assertTrue(driver.findElement(cartObject.productNameFromCart).getText().contains(productName));
    }
    @Test(priority = 1)
    public void UserCanEstimateShipping()
    {
        cartObject.clickEstimateShipping(zip);
        cartObject.clickContinueShopping();
    }
    @Test(priority = 2)
    public void UserCanRemoveProductFromCart()
    {
        cartObject.removeProduct();
        Assert.assertTrue(driver.findElement(cartObject.yourShoppingCartIsEmptyMsg).isDisplayed());
    }
}
