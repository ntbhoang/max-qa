package max.qa.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import max.qa.enums.Time;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 *
 * Driver class is responsible for invoking and closing the browsers.
 *
 * <p>
 * It is also responsible for
 * setting the driver variable to DriverManager which handles the thread safety for the
 * webdriver instance.
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
 * @see DriverManager
 */
public class Driver {

    private Driver(){
    }

    public static void initDriver(){
        System.out.println("Before init, driver is:  " + "`" + DriverManager.getWebDriver() + "`" );
        if (Objects.isNull(DriverManager.getWebDriver())){
            ChromeOptions chromeOptions = browserOptionsConfig();
            WebDriverManager.chromedriver().setup();
            DriverManager.setWebDriver(new ChromeDriver(chromeOptions));
        }
        System.out.println("After init, driver is:  " + "`" + DriverManager.getWebDriver() + "`" );
        browserConfig();
    }

    public static void quitDriver(){
        System.out.println("Before quit, driver is:  " + "`" + DriverManager.getWebDriver() + "`" );
        if(Objects.nonNull(DriverManager.getWebDriver())){
            DriverManager.getWebDriver().quit();
            DriverManager.unload();
        }
        System.out.println("After quit, driver is:  " + "`" + DriverManager.getWebDriver() + "`" );
    }

    private static void browserConfig(){
        DriverManager.getWebDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Time.PAGE_LOAD_TIME_OUT.getValue()));
        DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Time.IMPLICIT_WAIT_TIMEOUT.getValue()));
        DriverManager.getWebDriver().manage().window().maximize();
    }

    private static ChromeOptions browserOptionsConfig(){
        ChromeOptions chromeOptions = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        chromeOptions.setExperimentalOption("prefs", prefs);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        return chromeOptions;
    }
}
