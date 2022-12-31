package max.qa.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import max.qa.enums.ReportPath;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * ExtentManager class helps to initializes and flush extent instance.
 *
 * <pre>
 * <b>
 * <a href=</a>
 * </b>
 * </pre>
 *
 * Jan 2023
 * @author max.nguyen
 * @version 1.0
 * @since 1.0
 * @see
 */
public final class ExtentManager {

    private static ExtentReports extent;

    private ExtentManager() {}

    public static void initReporter(){
        if (Objects.isNull(extent)){
            extent = new ExtentReports();
            ExtentSparkReporter reporterType = new ExtentSparkReporter(ReportPath.EXTENT_PATH.getValue());
            reporterType.config().setTheme(Theme.DARK);
            reporterType.config().setReportName("Swag Labs Automation Web Demo");
            reporterType.config().setDocumentTitle("Max Nguyen E2E Tests Document");
            extent.attachReporter(reporterType);
        }
    }

    public static void flushReporter() throws IOException {
        if(Objects.nonNull(extent))
            extent.flush();
        Desktop.getDesktop().browse(new File(ReportPath.EXTENT_PATH.getValue()).toURI());
    }

    public static ExtentTest createExtentTest(String methodName){
        // TODO document why this method is empty
        return extent.createTest(methodName);
    }
}
