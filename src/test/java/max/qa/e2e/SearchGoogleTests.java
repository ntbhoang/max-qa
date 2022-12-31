package max.qa.e2e;


import max.qa.BaseTest;
import max.qa.driver.DriverManager;
import max.qa.listeners.TestListener;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


/**
 * Set the class to final because we don't want other classes inherit from it
 *
 * @author max.nguyen
 * Jan 2023
 */
@Listeners(TestListener.class)
public final class SearchGoogleTests{

    @Test
    public void test1(Method method){
        System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Test Automation", Keys.ENTER);
    }

    @Test
    public void test2(Method method){
        System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
    }

    @Test
    public void test3(Method method){
        System.out.println("The thread ID for Firefox is "+ Thread.currentThread().getId());
        DriverManager.getWebDriver().get("https://www.google.com/");
        DriverManager.getWebDriver().findElement(By.name("q")).sendKeys("Playwright", Keys.ENTER);
    }
}
