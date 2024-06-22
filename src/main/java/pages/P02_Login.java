package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_Login extends PageBase
{
    public P02_Login(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By emailTextBox = By.id("Email");
    private final By passwordTextBox = By.id("Password");
    private final By loginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");
    public By emailError = By.id("Email-error");
    public By passwordError = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    public By emptyEmail = By.cssSelector("span.field-validation-error");
    public void UserLogin(String email,String password)
    {
        setTextElementText(emailTextBox,email);
        setTextElementText(passwordTextBox,password);
        clickButton(loginBtn);
    }
}
