package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import pages.P06_ProductDetails;
import pages.P05_Search;
import pages.P01_Registration;

public class T010_EmailFriend extends TestBase
{
    HomePage homeObject ;
    P01_Registration registerObject ;
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    P08_EmailFriend emailFriendObject;
    String producrtName = "Apple MacBook Pro 13-inch";
    String firstName ="Omar";
    String lastName = "Ahmed";
    String email = "omar10@gmail.com";
    String companyName = "npCommerce";
    String companyFriendName = "nopCommerce2";
    String password = "123456";
    String confirmPassword = "123456";
    String emailFriend = "test10@gmail.com";
    String personalMessage ="Hello Friend, What do you think of this product?";


    @Test(priority = 1)
    public void UserCanRegisterSuccessfullyForMe()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName,lastName,email,companyFriendName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText().contains("Your registration completed"));
    }
    @Test(priority = 2)
    public void UserLogout()
    {
        homeObject = new HomePage(driver);
        homeObject.clickLogout();
    }
    @Test(priority = 3)
    public void UserCanRegisterSuccessfullyForFriend() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName, lastName, emailFriend,companyName, password, confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText().contains("Your registration completed"));
    }
    @Test(priority = 4)
    public void UserCanSearchForProduct()
    {
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        searchObject.productSearch(producrtName);
        searchObject.OpenProductDetailsPage();
        Assert.assertTrue(driver.findElement(detailsObject.productNameBreadCrumb).getText().contains(producrtName));
    }
    @Test(priority = 5)
    public void EmailAFriend()
    {
        detailsObject = new P06_ProductDetails(driver);
        detailsObject.clickEmailAFriend();
        emailFriendObject = new P08_EmailFriend(driver);
        emailFriendObject.UserSendProductAFriend(emailFriend,personalMessage);
        Assert.assertTrue(driver.findElement(emailFriendObject.resultMessage).getText().contains("Your message has been sent."));

    }
    @Test(priority = 6)
    public void UserLogoutFinal()
    {
        homeObject = new HomePage(driver);
        homeObject.clickLogout();
        }
}
