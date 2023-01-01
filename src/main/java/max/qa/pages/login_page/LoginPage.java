package max.qa.pages.login_page;

import max.qa.enums.WaitStrategy;
import max.qa.factory.WaitStrategyFactory;
import max.qa.pages.inventory_page.InventoryPage;
import max.qa.reports.ExtentTestManager;
import org.openqa.selenium.WebElement;


public final class LoginPage{
    private LoginWebElements elements;

    public LoginPage(){
        this.elements = new LoginWebElements();
    }

    public LoginPage enterUserName(String userName){
        WebElement element = WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.userNameTextBox);
        element.clear();
        element.sendKeys(userName);
        ExtentTestManager.getExtentTest().pass("`" + userName + "`" +" is entered into the passwordTextBox.");
        return this;
    }
    public LoginPage enterPassword(String password){
        WebElement element = WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.passwordTextBox);
        element.clear();
        element.sendKeys(password);
        ExtentTestManager.getExtentTest().pass("`" + password + "`" +" is entered into the passwordTextBox.");
        return this;
    }

    public InventoryPage click(){
        WaitStrategyFactory.perform(WaitStrategy.CLICKABLE, this.elements.loginButton).click();
        ExtentTestManager.getExtentTest().pass("Clicked on the `continue` button.");
       return new InventoryPage();
    }

    public InventoryPage login(String userName, String password){
        this.enterUserName(userName)
                .enterPassword(password)
                .click();
        return new InventoryPage();
    }
}
