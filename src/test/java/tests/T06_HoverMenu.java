package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class T06_HoverMenu extends TestBase
{
    HomePage homeObject;
    @BeforeMethod
    public void WelcomeHomePage()
    {
        homeObject = new HomePage(driver);
    }
    @Test
    public void UserCanSelectAComputerMenu()
    {
        homeObject.selectDesktopFromAComputerMenu();
        Assert.assertTrue(driver.findElement(homeObject.desktopsText).getText().contains("Desktops"));
        homeObject.selectNotebooksFromAComputerMenu();
        Assert.assertTrue(driver.findElement(homeObject.notebooksText).getText().contains("Notebooks"));
        homeObject.selectSoftwareFromAComputerMenu();
        Assert.assertTrue(driver.findElement(homeObject.softwareText).getText().contains("Software"));
    }
}

