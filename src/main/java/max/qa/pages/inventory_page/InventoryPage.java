package max.qa.pages.inventory_page;

import io.qameta.allure.Step;
import max.qa.driver.DriverManager;
import max.qa.pages.cart_page.CartPage;
import max.qa.pages.cart_page.CartWebElements;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class InventoryPage {

    private InventoryWebElements elements;
    private CartWebElements cartElements;


    public InventoryPage(){
        this.elements = new InventoryWebElements();
        this.cartElements = new CartWebElements();
    }

    @Step("Select {0} item, click on the `AddToCart` button")
    public InventoryPage addItemToCart(String name){
        By addToCartButton = this.elements.getAddToCartButton(name);
        DriverManager.getWebDriver().findElement(addToCartButton).click();
        return this;
    }


    @Step("Click on the `ShoppingCart Icon`, navigate to purchase details page")
    public CartPage viewCartDetailsInformation(){
        DriverManager.getWebDriver().findElement(this.elements.shoppingCartLink).click();
        By priceTextBox = this.cartElements.getCartElement("price");
        new WebDriverWait(DriverManager.getWebDriver(),
                Duration.ofSeconds(15)).until(ExpectedConditions.presenceOfElementLocated(priceTextBox));

        return new CartPage();
    }
}
