package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.P06_ProductDetails;
import pages.P07_ProductReview;
import pages.P05_Search;
import pages.P01_Registration;

public class T09_Review extends TestBase
{
    HomePage homeObject;
    P01_Registration registerObject;
    P06_ProductDetails detailsObject;
    P07_ProductReview reviewObject;
    P05_Search searchObject;
    String productName = "Apple MacBook Pro 13-inch";
    String firstName = "Omar";
    String lastName = "Ahmed";
    String email = "omar9@gmail.com";
    String companyName = "nopCommerce";
    String password = "123456";
    String confirmPassword = "123456";
    String reviewTitle = "ProductType";
    String reviewText = "Good";
    @Test (priority=1)
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,confirmPassword);
    }
    @Test(priority = 2)
    public void UserCanSearchWithAutoSuggest()
    {
        searchObject = new P05_Search(driver);
        searchObject.SearchUsingAutoSuggest("MacBook");
        detailsObject = new P06_ProductDetails(driver);
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(productName));
    }
    @Test(priority = 3)
    public void UserCanAddProductReview()
    {
        detailsObject.clickAddReview();
        reviewObject = new P07_ProductReview(driver);
        reviewObject.AddProductReview(reviewTitle,reviewText);
        Assert.assertTrue(driver.findElement(reviewObject.reviewNotification).getText().contains("Product review is successfully added."));
    }
    @Test(priority = 4)
    public void Logout()
    {
        homeObject.clickLogout();
    }
}
