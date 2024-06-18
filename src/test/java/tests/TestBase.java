package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.time.Duration;

public class TestBase
{
    public static WebDriver driver;
    @BeforeSuite
    @Parameters({"browser"})
    public void startDriver(@Optional ("chrome") String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome")) {driver = new ChromeDriver();}
        else if (browserName.equalsIgnoreCase("firefox")) {driver = new FirefoxDriver();}
        else if (browserName.equalsIgnoreCase("ie")) {driver = new InternetExplorerDriver();}

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://demo.nopcommerce.com/");
    }
    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
    // take screenshot when test case fail and add it in the Screenshot folder
    @AfterMethod
    public void screenshotOnFailure(ITestResult result)
    {
        if (result.getStatus()== ITestResult.FAILURE)
        {
            System.out.println("Failed!");
            System.out.println("Taking Screenshot......");
            Helper.captureScreenshot(driver,result.getName());
        }
    }
}
