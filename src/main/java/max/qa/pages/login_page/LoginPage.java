package max.qa.pages.login_page;

import io.qameta.allure.Step;
import max.qa.enums.WaitStrategy;
import max.qa.factory.WaitStrategyFactory;
import max.qa.pages.BasePage;
import max.qa.pages.inventory_page.InventoryPage;
import org.openqa.selenium.Keys;


public class LoginPage extends BasePage{
    private LoginWebElements elements;

    public LoginPage(){
        this.elements = new LoginWebElements();
    }

    @Step("Enter {0} into user name text-box ")
    public LoginPage enterUserName(String userName){
        WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.userNameTextBox).sendKeys(userName, Keys.TAB);
        return this;
    }
    @Step("Enter {0} into password text-box ")
    public LoginPage enterPassword(String password){
        WaitStrategyFactory.perform(WaitStrategy.PRESENCE,
                this.elements.passwordTextBox).sendKeys(password, Keys.TAB);
        return this;
    }

    @Step("Click continue button")
    public InventoryPage click(){
        WaitStrategyFactory.perform(WaitStrategy.CLICKABLE, this.elements.loginButton).click();
       return new InventoryPage();
    }

    @Step("Enter {0} into userName text-box, {1} into password text-box, click continue button")
    public InventoryPage login(String userName, String password){
        this.enterUserName(userName)
                .enterPassword(password)
                .click();
        return new InventoryPage();
    }
}
