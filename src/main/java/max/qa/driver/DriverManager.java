package max.qa.driver;

import org.openqa.selenium.WebDriver;

import java.util.Objects;


/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 *
 * <pre>
 * <b>
 *
 * </b>
 * </pre>
 *
 * Jan 2022
 * @author max.nguyen
 * @version 1.0
 * @since 1.0
 * @see Driver
 */

public class DriverManager {

    private DriverManager() {}

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
     *
     * @author Max.Nguyen
     * Jan 2022
     * @return {@link org.openqa.selenium.WebDriver} instance.
     */
    public static WebDriver getWebDriver(){
        return DRIVER_THREAD_LOCAL.get();
    }

    /**
     * Set the WebDriver instance to thread local variable
     *
     * @author Max.nguyen
     * Jan 2022
     * @param driverRef {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
     */
    public static void setWebDriver(WebDriver driverRef){
        if (Objects.nonNull(driverRef))
            DRIVER_THREAD_LOCAL.set(driverRef);
    }

    public static void unload(){
        DRIVER_THREAD_LOCAL.remove();
    }
}
