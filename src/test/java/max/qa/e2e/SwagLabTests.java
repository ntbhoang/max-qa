package max.qa.e2e;

import io.qameta.allure.*;
import max.qa.BaseTest;
import max.qa.driver.DriverManager;
import max.qa.enums.Configuration;
import max.qa.enums.Credential;
import max.qa.listeners.TestListener;
import max.qa.pages.cart_page.CartPage;
import max.qa.pages.inventory_page.InventoryPage;
import max.qa.pages.login_page.LoginPage;
import max.qa.utils.ReadPropertyFile;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Listeners({TestListener.class})
public final class SwagLabTests extends BaseTest {

    String url = ReadPropertyFile.get(Configuration.URL);
    String standard_user = Credential.getCredential(Credential.SLCredentials.STANDARD_USER);
    String password = Credential.getCredential(Credential.SLCredentials.PASSWORD);

    @Test(priority = 0, description = "Login with valid credential")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Login with valid credential successfully")
    @Story("User is able to login into the system with valid credential")
    public void testLoginWithValidCredential(Method m){
        WebDriver driver = DriverManager.getWebDriver();
        driver.get(url);

        LoginPage loginPage = new LoginPage();
        loginPage.login(standard_user, password);

        Assertions.assertThat(driver.getTitle()).isEqualTo("Swag Labs");
    }

    @Test(priority = 0, description = "Add an item into cart")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Add an item into cart successfully")
    @Story("User is able to add item into the cart")
    public void testAddAnItemToCart(Method m){
        WebDriver driver = DriverManager.getWebDriver();
        driver.get(url);

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = loginPage.login(standard_user, password);
        CartPage cartPage = inventoryPage.addItemToCart("backpack")
                        .viewCartDetailsInformation()
                        .checkout();

    }
}
