package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class P01_Registration extends PageBase
{
    public P01_Registration(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By genderRdoBtn = By.id("gender-male");
    private final By fnTextBox = By.id("FirstName");
    private final By lnTextBox = By.id("LastName");
    private final By emailTextBox = By.id("Email");
    private final By passwordTextBox = By.id("Password");
    private final By confirmPasswordTextBox = By.id("ConfirmPassword");
    private final By registerBtn = By.id("register-button");
    public By successMessage = By.cssSelector("div.result");
    public By emailAlreadyExists = By.xpath("//li[text() = 'The specified email already exists']");
    public By InvalidEmail = By.id("Email-error");
    public By confirmPasswordDifference = By.id("ConfirmPassword-error");
    By companyName = By.id("Company");
    public By firstNameError = By.id("FirstName-error");
    public By lastNameError = By.id("LastName-error");
    public By emailError = By.id("Email-error");

    public By confirmPasswordError = By.id("ConfirmPassword-error");
        public void UserRegistration(String firstName, String lastName, String email,String company, String password, String confirmPassword)
    {
        clickButton(genderRdoBtn);
        setTextElementText(fnTextBox,firstName);
        setTextElementText(lnTextBox,lastName);
        setTextElementText(emailTextBox,email);
        setTextElementText(companyName,company);
        setTextElementText(passwordTextBox,password);
        setTextElementText(confirmPasswordTextBox,confirmPassword);
        clickButton(registerBtn);
    }

}
