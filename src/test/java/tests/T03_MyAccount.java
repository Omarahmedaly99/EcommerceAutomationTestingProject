package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import pages.P01_Registration;

public class T03_MyAccount extends TestBase{
    P01_Registration registerObject;
    HomePage homeObject;
    P02_Login loginObject;
    P03_MyAccount myAccountObject;
    String firstName ="Omar";
    String lastName = "Ahmed";
    String email = "omar3@gmail.com";
    String companyName = "nopCommerce";
    String oldPassword = "123456";
    String confirmOldPassword = "123456";
    String newPassword = "12345678";
    String confirmPassword = "12345678";
    String city = "Cairo";
    String address1 = "th10";
    String address2 ="32";
    String zip = "12345";
    String pNumber = "01234566989";
    String fNumber = "54664";

    @BeforeClass()
    public void UserRegisterSuccessfully()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
        registerObject.UserRegistration(firstName,lastName,email,companyName,oldPassword,confirmOldPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText().contains("Your registration completed"));
    }
    @BeforeMethod
    public void OpenHomePage()
    {
        homeObject = new HomePage(driver);
    }
    @Test (priority = 2)
    public void UserRegisterCanChangePassword()
    {
        homeObject.openMyAccount();
        myAccountObject = new P03_MyAccount(driver);
        myAccountObject.openChangePassword();
        myAccountObject.ChangePassword(oldPassword,newPassword, confirmPassword);
       Assert.assertTrue(driver.findElement(myAccountObject.passwordWasChanged).getText().contains("Password was changed"));
    }
    @Test(priority = 3)
    public void addNewAddress()
    {
        myAccountObject = new P03_MyAccount(driver);
        myAccountObject.addAddresses(firstName,lastName,email,companyName,city,address1,address2,zip,pNumber,fNumber);
    }
    @Test (priority = 4)
    public void RegisteredUserCanLogout()
    {
        myAccountObject = new P03_MyAccount(driver);
        homeObject.clickLogout();
    }
    @Test (priority = 5)
    public void UserRegisteredCanLogin()
    {
        homeObject.openLoginPage();
        loginObject = new P02_Login(driver);
        loginObject.UserLogin(email,newPassword);
        Assert.assertTrue(driver.findElement(homeObject.logoutLink).getText().contains("Log out"));
    }
    @Test (priority = 6)
    public void UserLogout()
    {
        homeObject.clickLogout();
    }


}
