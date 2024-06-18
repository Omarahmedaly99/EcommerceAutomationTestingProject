package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PageBase
{
    protected WebDriver driver ;
    public JavascriptExecutor jse;
    public Select select;
    public Actions actions;
    public WebDriverWait wait;
    long seconds = 30;

    protected void clickButton (By button)
    {
        driver.findElement(button).click();
    }

    protected  void setTextElementText(By textElement , String value)
    {
        driver.findElement(textElement).sendKeys(value);
    }
    public void scrollToBottom()
    {
        jse.executeScript("scrollBy(0,2500)");
    }
    public void waitForElementWithLocatorToBeVisible(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitForElementWithLocatorToBePresent(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitForElementToBeClickable(WebDriver driver, By element) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementWithLocatorToBeClickable(WebDriver driver, By locator) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void clearDataFromInputField(By element) {
        driver.findElement(element).clear();
    }

}
