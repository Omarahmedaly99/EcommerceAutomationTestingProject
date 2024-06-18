package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P06_ProductDetails;
import pages.P05_Search;

public class T08_SearchUsingAutoSuggest extends TestBase
{
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    String productName = "Apple MacBook Pro 13-inch";
    @Test
    public void UserCanSearchWithAutoSuggest()
    {
        searchObject = new P05_Search(driver);
        searchObject.SearchUsingAutoSuggest("MacBook");
        detailsObject = new P06_ProductDetails(driver);
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(productName));

    }
}
