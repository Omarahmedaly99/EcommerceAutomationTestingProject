package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P04_ContactUs;
import pages.HomePage;

public class T04_ContactUs extends TestBase
{
    String fullName = "Omar Ahmed";
    String email = "omar4@mail.com";
    String enquiry = "I have a problem ordering a product";
    HomePage homeObject;
    P04_ContactUs contactUsObject;
    @Test
    public void UserCanUseContactUsPage()
    {
        homeObject = new HomePage(driver);
        homeObject.openContactUsPage();
        contactUsObject = new P04_ContactUs(driver);
        contactUsObject.ContactUs(fullName,email,enquiry);
        Assert.assertTrue(driver.findElement(contactUsObject.successMessage).getText().contains("Your enquiry has been successfully sent to the store owner."));
    }
}
