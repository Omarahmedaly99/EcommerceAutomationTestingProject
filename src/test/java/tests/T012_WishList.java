package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.P06_ProductDetails;
import pages.P05_Search;
import pages.P09_WishList;

public class T012_WishList extends TestBase
{
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    P09_WishList wishListObject;
    HomePage homeObject;
    String productName = "Apple MacBook Pro 13-inch";
    @Test(priority = 1)
    public void UserCanSearchForProduct()
    {
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        searchObject.productSearch(productName);
        searchObject.OpenProductDetailsPage();
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(productName));
    }
    @Test(priority = 2)
    public void UserCanAddToWishList()
    {
        detailsObject = new P06_ProductDetails(driver);
        detailsObject.clickAddProductToWishList();
        wishListObject = new P09_WishList(driver);
        wishListObject.addProductToCartFromWishList();
    }
    @Test(priority = 3)
    public void UserCanSearchForProductAgain()
    {
        homeObject = new HomePage(driver);
        homeObject.clickLogo();
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        searchObject.productSearch(productName);
        searchObject.OpenProductDetailsPage();
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(productName));
    }
    @Test(priority = 4)
    public void UserCanRemoveToWishList()
    {
        detailsObject = new P06_ProductDetails(driver);
        detailsObject.clickAddProductToWishList();
        wishListObject = new P09_WishList(driver);
        Assert.assertTrue(driver.findElement(wishListObject.wishlistHeader).isDisplayed());
        Assert.assertTrue(driver.findElement(wishListObject.productCell).getText().contains(productName));
        wishListObject.removeProductFromWishList();
        Assert.assertTrue(driver.findElement(wishListObject.wishlistIsEmpty).getText().contains("The wishlist is empty!"));
    }
}
