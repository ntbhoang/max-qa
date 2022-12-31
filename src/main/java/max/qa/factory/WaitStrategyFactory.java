package max.qa.factory;

import max.qa.constants.Constants;
import max.qa.driver.DriverManager;
import max.qa.enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public final class WaitStrategyFactory {

    private WaitStrategyFactory(){}

    public static WebElement perform(WaitStrategy strategy, By by){
        WebElement element = null;
        if (strategy == WaitStrategy.CLICKABLE){
            element = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(Constants.getPageLoadTimeout()))
                    .until(ExpectedConditions.elementToBeClickable(by));
        }
        else if (strategy == WaitStrategy.PRESENCE){
            element = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(Constants.getPageLoadTimeout()))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
        }
        else if (strategy == WaitStrategy.VISIBLE) {
            element = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(Constants.getPageLoadTimeout()))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
        }
        else if (strategy == WaitStrategy.NONE){
            element = DriverManager.getWebDriver().findElement(by);
        }
        return element;
    }
}
