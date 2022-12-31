package max.qa.pages.inventory_page;

import io.qameta.allure.Step;
import max.qa.driver.DriverManager;
import max.qa.enums.Time;
import max.qa.enums.WaitStrategy;
import max.qa.factory.WaitStrategyFactory;
import max.qa.pages.cart_page.CartPage;
import max.qa.pages.cart_page.CartWebElements;
import max.qa.pages.headers.MenuBarWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class InventoryPage {

    private InventoryWebElements elements;
    private CartWebElements cartElements;
    private MenuBarWebElements menuBarWebElements;


    public InventoryPage(){
        this.elements = new InventoryWebElements();
        this.cartElements = new CartWebElements();
        this.menuBarWebElements = new MenuBarWebElements();
    }

    @Step("Select `{0}` item, click on the `AddToCart` button")
    public InventoryPage addItemToCart(String name){
        By addToCartButton = this.elements.getAddToCartButton(name);
        DriverManager.getWebDriver().findElement(addToCartButton).click();
        return this;
    }


    @Step("Click on the `ShoppingCart Badge`, navigate to purchase details page")
    public CartPage viewCartInformationDetails(){
        DriverManager.getWebDriver().findElement(this.menuBarWebElements.getShoppingCartLink()).click();
        By priceTextBox = this.cartElements.getCartElement("price");
        new WebDriverWait(DriverManager.getWebDriver(),
                Duration.ofSeconds(Time.EXPLICIT_WAIT_TIMEOUT.getValue()))
                        .until(ExpectedConditions.presenceOfElementLocated(priceTextBox));

        return new CartPage();
    }

    public InventoryPage logout(){
        WaitStrategyFactory.perform(WaitStrategy.PRESENCE, this.menuBarWebElements.getMenuButton()).click();
        WaitStrategyFactory.perform(WaitStrategy.PRESENCE, this.menuBarWebElements.getLogoutSideBarLink()).click();

        return this;
    }
}
