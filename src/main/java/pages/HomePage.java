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
    private final By clickLogo = By.xpath("//img[@alt=\"nopCommerce demo store\"]");
    private final By registerLink = By.linkText("Register");
    private final By loginLink = By.linkText("Log in");
    public By logoutLink = By.linkText("Log out") ;
    public By myAccountLink = By.linkText("My account");
    private final By contactUsLink = By.linkText("Contact us");
    private final By currencydrl = By.id("customerCurrency");
    private final By computersMenu = By.xpath("//a[@href=\"/computers\"]");
    private final By desktops = By.xpath("//a[@href=\"/desktops\"]");
    public By desktopsText = By.xpath("//h1[text() = 'Desktops']");
    private final By notebooks = By.xpath("//a[@href=\"/notebooks\"]");
    public By notebooksText = By.xpath("//h1[text() = 'Notebooks']");
    private final By software = By.xpath("//a[@href=\"/software\"]");
    public By softwareText = By.xpath("//h1[text() = 'Software']");
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

