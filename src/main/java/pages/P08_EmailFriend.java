package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P08_EmailFriend extends PageBase
{
    public P08_EmailFriend(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By friendEmailTextBox = By.id("FriendEmail");
    private final By personalMessageTextBox = By.id("PersonalMessage");
    private final By sendEmailBtn = By.xpath("//button[@class=\"button-1 send-email-a-friend-button\"]");
    public By resultMessage = By.xpath("//div[@class=\"result\"]");
    public void UserSendProductAFriend(String friendEmail,String message)
    {
        setTextElementText(friendEmailTextBox,friendEmail);
        setTextElementText(personalMessageTextBox,message);
        clickButton(sendEmailBtn);
    }
}
