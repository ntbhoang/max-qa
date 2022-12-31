package max.qa.listeners;

import lombok.SneakyThrows;
import max.qa.reports.ExtentManager;
import max.qa.reports.ExtentTestManager;
import org.testng.*;

public final class TestListener implements ITestListener, ISuiteListener{

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " is Passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " is Failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " is Skipped.");

    }

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
