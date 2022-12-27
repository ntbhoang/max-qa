package max.qa.e2e;

import max.qa.BaseTest;
import max.qa.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


/**
 * Set the class to final because we don't want other classes inherit from it
 *
 * @author max.nguyen
 * Jan 2022
 */
public final class SearchGoogleTests extends BaseTest {

    @Test
    public void test1(){
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Test Automation", Keys.ENTER);
    }

    @Test
    public void test2(){
        //Driver.initDriver();
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void test3(){
        //Driver.initDriver();
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
    }
}
