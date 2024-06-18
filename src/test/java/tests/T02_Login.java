package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.P02_Login;
import pages.P01_Registration;

public class T02_Login extends TestBase
{
    HomePage homeObject ;
    P01_Registration registerObject;
    P02_Login loginObject ;
    String firstName = "Omar";
    String lastName = "Ahmed";
    String email = "omar2@gmail.com";
    String companyName = "nopCommerce";
    String password = "123456";
    String confirmPassword = "123456";
    @BeforeClass
    public void UserCanRegisterSuccessfully() {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText()
                .contains("Your registration completed"));
        homeObject.clickLogout();
    }
    @BeforeMethod
    public void OpenLogin()
    {
        homeObject = new HomePage(driver);
        homeObject.openLoginPage();
        loginObject = new P02_Login(driver);
    }
    @Test(priority = 1)
    public void LoginValid()
    {
        loginObject.UserLogin(email,password);
        homeObject.clickLogout();
        Assert.assertTrue(driver.findElement(homeObject.myAccountLink).getText()
                .contains("My account"));
    }
    @Test(priority = 2)
    public void LoginEmpty()
    {
        loginObject.UserLogin("","");
        Assert.assertTrue(driver.findElement(homeObject.emptyEmail).getText()
                .contains("Please enter your email"));
    }
    @Test(priority = 3)
    public void EmailInValidAndPasswordValid()
    {
        loginObject.UserLogin("omar.com",password);
        Assert.assertTrue(driver.findElement(homeObject.emailError).getText()
                .contains("Please enter a valid email address."));
    }
    @Test(priority = 4)
    public void EmailValidAndPasswordInValid()
    {
        loginObject.UserLogin(email,"....@45");
        Assert.assertTrue(driver.findElement(homeObject.passwordError).getText()
                .contains("Login was unsuccessful."));
    }
    @Test(priority = 5)
    public void LoginWithoutEnteringEmail()
    {
        loginObject.UserLogin("",password);
        Assert.assertTrue(driver.findElement(homeObject.emptyEmail).getText()
                .contains("Please enter your email"));
    }
    @Test(priority = 6)
    public void LoginWithoutEnteringPassword()
    {
        loginObject.UserLogin(email,"");
        Assert.assertTrue(driver.findElement(homeObject.passwordError).getText()
                .contains("Login was unsuccessful."));
    }
}
