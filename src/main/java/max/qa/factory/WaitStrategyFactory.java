package max.qa.factory;

import max.qa.constants.Constants;
import max.qa.driver.DriverManager;
import max.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class WaitStrategyFactory {

    private static WebDriverWait wait;
    private static WebElement element;

    static {
        wait = new WebDriverWait(DriverManager.getWebDriver(),
                                Duration.ofSeconds(Constants.getPageLoadTimeout()));
    }

    public static WebElement perform(WaitStrategy strategy, By by){
        if (strategy == WaitStrategy.CLICKABLE){
            element = wait.until(ExpectedConditions.elementToBeClickable(by));
        }
        else if (strategy == WaitStrategy.PRESENCE){
            element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if (strategy == WaitStrategy.VISIBLE) {
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if (strategy == WaitStrategy.NONE){
            element = DriverManager.getWebDriver().findElement(by);
        }
        return element;
    }
}
