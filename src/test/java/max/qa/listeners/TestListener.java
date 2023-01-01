package max.qa.listeners;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import lombok.SneakyThrows;
import max.qa.driver.Driver;
import max.qa.enums.Configuration;
import max.qa.reports.ExtentManager;
import max.qa.reports.ExtentTestManager;
import max.qa.utils.ReadPropertyFile;
import max.qa.utils.TakeScreenShot;
import org.testng.*;

public final class TestListener implements ITestListener, ISuiteListener{

    private String getTestName(ITestResult result){
        return result.getName();
    }

    /*
        - similar to @BeforeMethod
     */
    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.createExtentTest(getTestName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result){
        TakeScreenShot.takeBase64Screenshot(getTestName(result) + " is Passed.",
                Configuration.PASSED_STEPS_SCREEN_SHOT);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        TakeScreenShot.takeBase64Screenshot(getTestName(result) + " is Failed."
                , Configuration.FAILED_STEPS_SCREEN_SHOT);
        ExtentTestManager.getExtentTest().fail(result.getThrowable().toString());
        ExtentTestManager.getExtentTest().fail(result.getThrowable().getStackTrace().toString());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        TakeScreenShot.takeBase64Screenshot(getTestName(result) + " is Skipped."
                , Configuration.SKIPPED_STEPS_SCREEN_SHOT);
    }

    /*
        Before and After the suite, init the Extent report
     */
    @Override
    public void onStart(ISuite suite) {
        ExtentManager.initReporter();
    }


    @SneakyThrows
    @Override
    public void onFinish(ISuite suite) {
        ExtentManager.flushReporter();
        ExtentTestManager.unload();
    }
}
