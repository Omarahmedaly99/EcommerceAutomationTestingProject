package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
    }
    private final By clickLogo = By.xpath("/html/body/div[6]/div[1]/div[2]/div[1]/a/img");
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    public By logoutLink = By.linkText("Log out") ;
    public By myAccountLink = By.linkText("My account");
    private final By contactUsLink = By.linkText("Contact us");
    private final By currencydrl = By.id("customerCurrency");
    private final By computersMenu = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/a");
    private final By desktops = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[1]/a");
    public By desktopsText = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[1]/h1");
    private final By notebooks = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a");
    public By notebooksText = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[1]/h1");
    private final By software = By.xpath("/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[3]/a");
    public By softwareText = By.xpath("//*[@id=\"main\"]/div/div[3]/div/div[1]/h1");
    public By emailError = By.id("Email-error");
    public By passwordError = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");
    public By emptyEmail = By.cssSelector("span.field-validation-error");
    public void clickLogo()
    {
        clickButton(clickLogo);
    }
    public void openRegistrationPage()
    {
        clickButton(registerLink);
    }

    public void openLoginPage()
    {
        clickButton(loginLink);
    }
    public void clickLogout()
    {
        WebElement element = driver.findElement(logoutLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void openMyAccount()
    {
        clickButton(myAccountLink);
    }

    public void openContactUsPage()
    {
        scrollToBottom();
        clickButton(contactUsLink);
    }
    public void changeCurrency()
    {
        select = new Select(driver.findElement(currencydrl));
        select.selectByVisibleText("Euro");
    }
    public void selectDesktopFromAComputerMenu()
    {
        actions.moveToElement(driver.findElement(computersMenu))
                .moveToElement(driver.findElement(desktops))
                .click().build().perform();
    }
    public void selectNotebooksFromAComputerMenu()
    {
        actions.moveToElement(driver.findElement(computersMenu))
                .moveToElement(driver.findElement(notebooks))
                .click().build().perform();
    }
    public void selectSoftwareFromAComputerMenu()
    {
        actions.moveToElement(driver.findElement(computersMenu))
                .moveToElement(driver.findElement(software))
                .click().build().perform();
    }

}

