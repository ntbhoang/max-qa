package max.qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

/**
 * DriverManager class helps to achieve thread safety for the {@link org.openqa.selenium.WebDriver} instance.
 *
 * <pre>
 * <b>
 * <a href="https://www.youtube.com/channel/UC6PTXUHb6j4Oxf0ccdRI11A">Testing Mini Bytes Youtube channel</a>
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

    private static ThreadLocal<WebDriver> dt = new ThreadLocal<>();

    /**
     * Returns the thread safe {@link org.openqa.selenium.WebDriver} instance fetched from ThreadLocal variable.
     *
     * @author Amuthan Sakthivel
     * Jan 2022
     * @return {@link org.openqa.selenium.WebDriver} instance.
     */
    public static WebDriver getWebDriver(){
        return dt.get();
    }

    /**
     * Set the WebDriver instance to thread local variable
     *
     * @author max.nguyen
     * Jan 2022
     * @param driverRef {@link org.openqa.selenium.WebDriver} instance that needs to saved from Thread safety issues.<p>
     */
    public static void setWebDriver(WebDriver driverRef){
        if(Objects.nonNull(driverRef))
            dt.set(driverRef);
    }

    public static void unload(){
        dt.remove();
    }
}
