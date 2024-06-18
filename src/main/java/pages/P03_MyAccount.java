package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
public class P03_MyAccount extends PageBase

{
    public P03_MyAccount(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By changePasswordLink = By.linkText("Change password");
    private final By oldPasswordText = By.id("OldPassword");
    private final By newPasswordText = By.id("NewPassword");
    private final By confirmNewPasswordText = By.id("ConfirmNewPassword");
    private final By changePasswordBtn = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/form/div[2]/button");
    public By passwordWasChanged = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    private final By addresses = By.linkText("Addresses");
    private final By fNameAddress = By.id("Address_FirstName");
    private final By lNameAddress = By.id("Address_LastName");
    private final By emailAddress = By.id("Address_Email");
    private final By companyAddress = By.id("Address_Company");
    private final By countryId = By.id("Address_CountryId");
    private final By cityAddress = By.id("Address_City");
    private final By addressAddress1 = By.id("Address_Address1");
    private final By addressAddress2 = By.id("Address_Address2");
    private final By zipPostalCode = By.id("Address_ZipPostalCode");
    private final By addressPhoneNumber = By.id("Address_PhoneNumber");
    private final By addressFaxNumber = By.id("Address_FaxNumber");
    private final By save = By.xpath("//*[@id=\"main\"]/div/div[2]/form/div/div[2]/div[2]/button");
    private final By closeNotification = By.xpath("//*[@id=\"bar-notification\"]/div/span");
    private final By addNew = By.xpath("//*[@id=\"main\"]/div/div[2]/div/div[2]/div[2]/button");
    public By ExitPasswordWasChanged = By.xpath("//*[@id=\"bar-notification\"]/div/span");
    public void openChangePassword ()
    {
        clickButton(changePasswordLink);
    }
    public void ChangePassword (String oldPassword, String newPassword, String confirmNewPassword)
    {
        setTextElementText(oldPasswordText,oldPassword);
        setTextElementText(newPasswordText,newPassword);
        setTextElementText(confirmNewPasswordText,confirmNewPassword);
        clickButton(changePasswordBtn);
        clickButton(ExitPasswordWasChanged);
    }
    public void addAddresses(String fName,String lName,String email,
                          String company,String city,String address1,String address2,
                          String zip,String pNumber,String fNumber)
    {
        waitForElementWithLocatorToBePresent(driver,addresses);
        clickButton(addresses);
        waitForElementWithLocatorToBePresent(driver,addNew);
        clickButton(addNew);
        setTextElementText(fNameAddress,fName);
        setTextElementText(lNameAddress,lName);
        setTextElementText(emailAddress,email);
        setTextElementText(companyAddress,company);
        waitForElementWithLocatorToBePresent(driver,countryId);
        select = new Select(driver.findElement(countryId));
        select.selectByVisibleText("Egypt");
        waitForElementWithLocatorToBePresent(driver,cityAddress);
        setTextElementText(cityAddress,city);
        setTextElementText(addressAddress1,address1);
        setTextElementText(addressAddress2,address2);
        setTextElementText(zipPostalCode,zip);
        setTextElementText(addressPhoneNumber,pNumber);
        setTextElementText(addressFaxNumber,fNumber);
        clickButton(save);
        clickButton(closeNotification);
    }
}
