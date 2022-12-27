package max.qa.pages;

import max.qa.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class BasePage {

    protected BasePage(){}

    public void clickOn(By by){
        DriverManager.getWebDriver().findElement(by).click();
    }

    public void enter(By by, String value){
        DriverManager.getWebDriver().findElement(by).sendKeys(value);
    }

    public String getPageTitle(){
        return DriverManager.getWebDriver().getTitle();
    }
}
