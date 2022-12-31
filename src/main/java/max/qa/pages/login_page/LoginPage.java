package max.qa.pages.login_page;

import max.qa.enums.WaitStrategy;
import max.qa.factory.WaitStrategyFactory;
import max.qa.pages.inventory_page.InventoryPage;
import org.openqa.selenium.WebElement;


public final class LoginPage{
    private LoginWebElements elements;

    public LoginPage(){
        this.elements = new LoginWebElements();
    }

    public LoginPage enterUserName(String userName){
        WebElement element = WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.userNameTextBox);
        //ExtentTestManager.getTest().log(Status.INFO, "Enter value for userNameTextBox");
        element.clear();
        element.sendKeys(userName);

        return this;
    }
    public LoginPage enterPassword(String password){
        WebElement element = WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.passwordTextBox);
        //ExtentTestManager.getTest().log(Status.INFO, "Enter value for passwordTextBox");
        element.clear();
        element.sendKeys(password);

        return this;
    }

    public InventoryPage click(){
        //ExtentTestManager.getTest().log(Status.INFO, "Click on continue button");
        WaitStrategyFactory.perform(WaitStrategy.CLICKABLE, this.elements.loginButton).click();
       return new InventoryPage();
    }

    public InventoryPage login(String userName, String password){
        this.enterUserName(userName)
                .enterPassword(password)
                .click();
        return new InventoryPage();
    }
}
