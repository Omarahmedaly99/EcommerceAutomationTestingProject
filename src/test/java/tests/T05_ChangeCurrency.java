package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P06_ProductDetails;
import pages.P05_Search;

public class T05_ChangeCurrency extends TestBase
{
    HomePage homeObject;
    P06_ProductDetails detailsObject;
    P05_Search searchObject;
    String productName = "Apple MacBook Pro 13-inch";
    @Test(priority = 1)
    public void UserCanChangeCurrency()
    {
        homeObject = new HomePage(driver);
        homeObject.changeCurrency();
    }
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest()
    {
        searchObject = new P05_Search(driver);
        searchObject.SearchUsingAutoSuggest("MacBook");
        detailsObject = new P06_ProductDetails(driver);
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(productName));
        Assert.assertTrue(driver.findElement(detailsObject.productPriceLabel).getText().contains("€"));
        System.out.println(driver.findElement(detailsObject.productPriceLabel).getText());

    }

}
