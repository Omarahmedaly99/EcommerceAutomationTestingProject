package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P04_ContactUs extends PageBase
{
    public P04_ContactUs(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By fullNameTextBox = By.id("FullName");
    private final By emailTextBox = By.id("Email");
    private final By enquiryTextBox = By.id("Enquiry");
    private final By submitBtn = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[2]/button");
    public By successMessage = By.cssSelector("div.result");
    public void ContactUs(String fullName,String email,String enquiry)
    {
        setTextElementText(fullNameTextBox,fullName);
        setTextElementText(emailTextBox,email);
        setTextElementText(enquiryTextBox,enquiry);
        clickButton(submitBtn);
    }
}
