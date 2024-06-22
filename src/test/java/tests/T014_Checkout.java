package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import pages.P012_Checkout;
import pages.P06_ProductDetails;
import pages.P05_Search;
import pages.P011_ShoppingCart;
import pages.P01_Registration;

public class T014_Checkout extends TestBase
{
    HomePage homeObject;
    P01_Registration registerObject;
    P05_Search searchObject;
    P06_ProductDetails detailsObject;
    P011_ShoppingCart cartObject;
    P012_Checkout checkoutObject;
    String firstName ="Omar";
    String lastName = "Ahmed";
    String email = "omarx14@gmail.com";
    String companyName = "NopCommerce";
    String password = "123456";
    String confirmPassword = "123456";
    String productName = "Apple MacBook Pro 13-inch";
    @BeforeClass
    public void UserCanRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText().contains("Your registration completed"));
    }
    @Test(priority = 1)
    public void UserCanAddToCart()
    {
        searchObject = new P05_Search(driver);
        detailsObject = new P06_ProductDetails(driver);
        cartObject = new P011_ShoppingCart(driver);
        searchObject.SearchUsingAutoSuggest("MacBook");
        detailsObject.clickAddProductToCart();
        Assert.assertTrue(driver.findElement(cartObject.productNameFromCart).getText().contains(productName));
    }
    @Test(priority = 2)
    public void UserCanProductCheckoutPaymentMoneyOrder()
    {
        cartObject = new P011_ShoppingCart(driver);
        cartObject.clickTermsOfServiceAndCheckout();
        checkoutObject = new P012_Checkout(driver);
        checkoutObject.billingAddress();
        checkoutObject.shippingAddress();
        checkoutObject.paymentMoneyOrder();


    }
    @Test(priority = 3)
    public void UserCanProductCheckoutPaymentCreditCard()
    {
        cartObject = new P011_ShoppingCart(driver);
        cartObject.clickTermsOfServiceAndCheckout();
        checkoutObject = new P012_Checkout(driver);
        checkoutObject.anotherPaymentMethod();
        checkoutObject.shippingAddress();
        checkoutObject.paymentCreditCard();
    }
}
