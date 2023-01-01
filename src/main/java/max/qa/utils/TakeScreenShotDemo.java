package max.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import max.qa.driver.DriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class TakeScreenShotDemo {


    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        DriverManager.setWebDriver(new ChromeDriver());
        WebDriver driver = DriverManager.getWebDriver();
        driver.get("https://www.google.com/");
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir") + "/src/test/screenshots/screenshot.png");
        Files.copy(scrFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        WebElement element = driver.findElement(By.name("q"));
        File elementFile = element.getScreenshotAs(OutputType.FILE);
        File eleDestFile = new File(System.getProperty("user.dir") + "/src/test/screenshots/element-screenshot.png");
        Files.copy(elementFile.toPath(), eleDestFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

        driver.quit();
    }


}
