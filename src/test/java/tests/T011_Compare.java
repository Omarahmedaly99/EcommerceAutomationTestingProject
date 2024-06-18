package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P010_Compare;
import pages.P06_ProductDetails;
import pages.P05_Search;

public class T011_Compare extends TestBase
{
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    P010_Compare compareObject;
    String firstProductName = "Lenovo Thinkpad X1 Carbon Laptop";
    String secondProductName = "Asus N551JK-XO076H Laptop";
    @Test(priority = 1)
    public void UserCanCompareProducts()
    {
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        compareObject = new P010_Compare(driver);

        searchObject.SearchUsingAutoSuggest("Lenovo");
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(firstProductName));
        detailsObject.clickAddProductToCompareList();

        searchObject.SearchUsingAutoSuggest("Asus");
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(secondProductName));
        detailsObject.clickAddProductToCompareList();

        driver.navigate().to("https://demo.nopcommerce.com"+"/compareproducts");
        Assert.assertTrue(driver.findElement(compareObject.firstProduct).isDisplayed());
        Assert.assertTrue(driver.findElement(compareObject.secondProduct).isDisplayed());
        compareObject.compareProducts();
    }
    @Test(priority = 2)
    public void UserCanClearCompare()
    {
        compareObject = new P010_Compare(driver);
        compareObject.clearCompareList();
        Assert.assertTrue(driver.findElement(compareObject.YouHaveNoItemsToCompare).isDisplayed());
    }
}
