package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P05_Search extends PageBase
{
    public P05_Search(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By searchTextBox = By.id("small-searchterms");
    private final By searchBtn = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    private final By productList = By.id("ui-id-1");
    private final By productTitle = By.linkText("Apple MacBook Pro 13-inch");
    public void productSearch(String productName)
    {
        setTextElementText(searchTextBox,productName);
        clickButton(searchBtn);
    }
    public void OpenProductDetailsPage()
    {
        clickButton(productTitle);
    }
    public void SearchUsingAutoSuggest(String searchText)
    {
        waitForElementWithLocatorToBeVisible(driver, searchTextBox);
        clickButton(searchTextBox);
        setTextElementText(searchTextBox,searchText);
        waitForElementWithLocatorToBeVisible(driver,productList);
        clickButton(productList);
    }

}
