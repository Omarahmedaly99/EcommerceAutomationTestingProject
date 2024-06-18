package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.P01_Registration;

public class T01_Registration extends TestBase
{
    HomePage homeObject ;
    String firstName ="Omar";
    String lastName = "Ahmed";
    String email = "omar1@gmail.com";
    String companyName = "nopCommerce";
    String password = "123456";
    String confirmPassword = "123456";
    String invalidEmail = "omar009.com";
    String newEmail = "test1@gmail.com";
    String confirmPasswordDifference = "Omar$";
    P01_Registration registerObject ;
    @BeforeMethod
    public void OpenWelcomePage()
    {
        homeObject = new HomePage(driver);
        homeObject.openRegistrationPage();
        registerObject = new P01_Registration(driver);
    }
    @Test (priority = 1)
    public void UserCanRegisterSuccessfully()
    {
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.successMessage).getText()
                .contains("Your registration completed"));
        homeObject.clickLogout();
    }

    @Test (priority = 2)
    public void EmailAlreadyExists()
    {
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.alreadyExists).getText()
                .contains("The specified email already exists"));
    }
    @Test (priority = 3)
    public void InvalidEmail()
    {
        registerObject.UserRegistration(firstName,lastName,invalidEmail,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.InvalidEmail).getText()
                .contains("Please enter a valid email address."));
    }
    @Test (priority = 4)
    public void ConfirmPasswordDifference()
    {
        registerObject.UserRegistration(firstName,lastName,newEmail,companyName,password,confirmPasswordDifference);
        Assert.assertTrue(driver.findElement(registerObject.confirmPasswordDifference).getText()
                .contains("The password and confirmation password do not match."));
    }
    @Test (priority = 5)
    public void RegisterAnAccountUsingEmptyFields()
    {
        registerObject.UserRegistration("","","","","","");
        Assert.assertTrue(driver.findElement(registerObject.emailError).getText()
                .contains("Email is required."));
    }
    @Test (priority = 6)
    public void RegisterWithoutEnteringFirstName()
    {
        registerObject.UserRegistration("",lastName,email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.firstNameError).getText()
                .contains("First name is required."));
    }
    @Test (priority = 7)
    public void RegisterWithoutEnteringLastName()
    {
        registerObject.UserRegistration(firstName,"",email,companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.lastNameError).getText()
                .contains("Last name is required."));
    }
    @Test (priority = 8)
    public void RegisterWithoutEnteringEmail()
    {
        registerObject.UserRegistration(firstName,lastName,"",companyName,password,confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.emailError).getText()
                .contains("Email is required."));
    }
    @Test (priority = 9)
    public void RegisterWithoutEnteringPassword()
    {
        registerObject.UserRegistration(firstName,lastName,email,companyName,"",confirmPassword);
        Assert.assertTrue(driver.findElement(registerObject.confirmPasswordError).getText()
                .contains("The password and confirmation password do not match."));
    }
    @Test (priority = 10)
    public void RegisterWithoutEnteringConfirmPassword()
    {
        registerObject.UserRegistration(firstName,lastName,email,companyName,password,"");
        Assert.assertTrue(driver.findElement(registerObject.confirmPasswordError).getText()
                .contains("Password is required."));
    }

}
