package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P07_ProductReview extends PageBase
{
    public P07_ProductReview(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By reviewTitleTextBox = By.id("AddProductReview_Title");
    private final By reviewTextBox = By.id("AddProductReview_ReviewText");
    private final By ratingBtn = By.id("addproductrating_3");
    private final By submit = By.id("add-review");
    public By reviewNotification = By.xpath("//p[@class=\"content\"]");
    private final By closeNotification = By.xpath("//span[@class=\"close\"]");
    public void AddProductReview(String reviewTitle,String reviewMessage)
    {
        setTextElementText(reviewTitleTextBox,reviewTitle);
        setTextElementText(reviewTextBox,reviewMessage);
        clickButton(ratingBtn);
        clickButton(submit);
        waitForElementWithLocatorToBeVisible(driver,closeNotification);
        clickButton(closeNotification);
    }
}
