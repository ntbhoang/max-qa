package max.qa.utils;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import lombok.SneakyThrows;
import max.qa.constants.Constants;
import max.qa.driver.DriverManager;
import max.qa.enums.Configuration;
import max.qa.enums.WaitStrategy;
import max.qa.factory.WaitStrategyFactory;
import max.qa.reports.ExtentTestManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public final class TakeScreenShot {

    private TakeScreenShot(){}

    public static void forFullScreen(){
        WebDriver driver = DriverManager.getWebDriver();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(Constants.getFullScreenFilePath());
        copyScreenshotFile(scrFile, destFile);
    }

    public static void forElement(By by){
        File elementScrFile = WaitStrategyFactory.perform(WaitStrategy.NONE, by).getScreenshotAs(OutputType.FILE);
        File eleDestFile = new File(Constants.getElementScreenshotPath());
        copyScreenshotFile(elementScrFile, eleDestFile);
    }

    public static String asBase64Image(){
        WebDriver driver = DriverManager.getWebDriver();
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    public static void takeBase64Screenshot(String message, Configuration testStatus){
        switch (testStatus){
            case PASSED_STEPS_SCREEN_SHOT:
                if (ReadPropertyFile.get(testStatus).equalsIgnoreCase("yes"))
                    ExtentTestManager.getExtentTest().pass(message, buildBase64Image());
                else
                    ExtentTestManager.getExtentTest().pass(message);
                break;
            case FAILED_STEPS_SCREEN_SHOT:
                if (ReadPropertyFile.get(testStatus).equalsIgnoreCase("yes"))
                    ExtentTestManager.getExtentTest().fail(message, buildBase64Image());
                else
                    ExtentTestManager.getExtentTest().fail(message);
                break;
            case SKIPPED_STEPS_SCREEN_SHOT:
                if (ReadPropertyFile.get(testStatus).equalsIgnoreCase("yes"))
                    ExtentTestManager.getExtentTest().skip(message, buildBase64Image());
                else
                    ExtentTestManager.getExtentTest().skip(message);
                break;
            default:
                break;
        }
    }

    private static Media buildBase64Image(){
        return MediaEntityBuilder.createScreenCaptureFromBase64String(TakeScreenShot.asBase64Image()).build();
    }

    @SneakyThrows
    private static void copyScreenshotFile(File scrFile, File destFile){
        Files.copy(scrFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
