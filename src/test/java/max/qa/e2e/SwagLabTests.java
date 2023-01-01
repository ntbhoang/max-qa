package max.qa.e2e;

import lombok.Data;
import max.qa.BaseTest;
import max.qa.driver.DriverManager;
import max.qa.enums.Configuration;
import max.qa.enums.Credential;
import max.qa.listeners.TestListener;
import max.qa.pages.cart_page.CartPage;
import max.qa.pages.inventory_page.InventoryPage;
import max.qa.pages.login_page.LoginPage;
import max.qa.reports.ExtentManager;
import max.qa.utils.ReadPropertyFile;
import org.assertj.core.api.Assertions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public final class SwagLabTests extends BaseTest{

    private static final String APP_URL = ReadPropertyFile.get(Configuration.URL);
    private static final String STANDARD_USER = Credential.getCredential(Credential.SLCredentials.STANDARD_USER);
    private static final String PASSWORD = Credential.getCredential(Credential.SLCredentials.PASSWORD);


    @Test(dataProvider = "loginData")
    public void testLoginWithDataProvider(String userName, String password){
        DriverManager.getWebDriver().get(APP_URL);
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(userName, password);
        Assertions.assertThat(DriverManager.getWebDriver().getTitle()).isEqualTo("Swag Lab");
        inventoryPage.logout();
    }


    public void testLoginWithValidCredential(Method m){
        DriverManager.getWebDriver().get(APP_URL);
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(STANDARD_USER, PASSWORD);
        Assertions.assertThat(DriverManager.getWebDriver().getTitle()).isEqualTo("Swag Labs");
        inventoryPage.logout();
    }

    public void testAddAnItemToCart(Method m){
        DriverManager.getWebDriver().get(APP_URL);
        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(STANDARD_USER, PASSWORD);
        CartPage cartPage = inventoryPage.addItemToCart("backpack")
                        .viewCartInformationDetails()
                        .checkout();
        Assertions.assertThat(DriverManager.getWebDriver().getTitle()).isEqualTo("Swag Labs");
    }


    @DataProvider(name = "loginData", parallel = true)
    public Object[][] loginData(){
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
        };
    }
}
