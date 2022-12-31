package max.qa.reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.Objects;

/**
 * ExtentTestManager class helps to ihelps to achieve thread safety for the {ExtentTest} instance.
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
public final class ExtentTestManager {

    private static final ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();


    private ExtentTestManager(){}

    public static void setTest(ExtentTest testRef){
        if (Objects.nonNull(testRef))
            extentTestThreadLocal.set(testRef);
    }

    public static ExtentTest getTest(){
        return extentTestThreadLocal.get();
    }

    public static void unload(){
        extentTestThreadLocal.remove();
    }
}
