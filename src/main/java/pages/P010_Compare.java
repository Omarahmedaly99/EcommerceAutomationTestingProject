package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P010_Compare extends PageBase
{
    public P010_Compare(WebDriver driver)
    {
        this.driver = driver;
    }
    private final By clearListBtn = By.xpath("//a[@class=\"clear-list\"]");
    public By YouHaveNoItemsToCompare = By.xpath("//div[@class=\"no-data\"]");
    private final By compareTable = By.xpath("//table[@class=\"compare-products-table\"]");
    public By allRows = By.tagName("tr");
    public By allCol = By.tagName("td");
    public By firstProduct = By.linkText("Asus N551JK-XO076H Laptop");
    public By secondProduct = By.linkText("Lenovo Thinkpad X1 Carbon Laptop");
    public void clearCompareList()
    {
        clickButton(clearListBtn);
    }
    public void compareProducts()
    {
        WebElement table = driver.findElement(compareTable);
        List<WebElement> rows = table.findElements(allRows);
        for (WebElement row : rows)
        {
         List<WebElement> cells = driver.findElements(allCol);
            System.out.println(row.getText()+ "\t");
            for (WebElement col : cells)
                System.out.println(col.getText() + "\t");
        }
    }
}
