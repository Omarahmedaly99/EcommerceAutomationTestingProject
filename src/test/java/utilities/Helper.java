package utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Helper {
    // Method to take screenshot when the test cases fail
    public static void captureScreenshot (WebDriver driver , String screenshotName)
    {
        Path dest = Paths.get("./Screenshots",screenshotName+".png");
        try {
            Files.createDirectories(dest.getParent());
            FileOutputStream out = new FileOutputStream(dest.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        }
        catch (IOException e) {
            System.out.println("Exception while taking screenshot" + e.getMessage());
        }
    }
    public static void scrollWithSpecificSize(WebDriver driver, int sizeX, int sizeY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String jsCommand = String.format("window.scrollBy('%s','%s')", sizeX, sizeY);
        js.executeScript(jsCommand, "");
    }
}
