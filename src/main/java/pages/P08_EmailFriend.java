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
    private final By sendEmail = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/form/div[2]/button");

    public By resultMessage = By.cssSelector("div.result");
    public void UserSendProductAFriend(String friendEmail,String message)
    {
        setTextElementText(friendEmailTextBox,friendEmail);
        setTextElementText(personalMessageTextBox,message);
        clickButton(sendEmail);
    }
}
