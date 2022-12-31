package max.qa.pages.cart_page;

import io.qameta.allure.Step;
import max.qa.driver.DriverManager;
import max.qa.pages.headers.MenuBarWebElements;

public final class CartPage {

    protected CartWebElements elements;
    private MenuBarWebElements menuBarWebElements;

    public CartPage(){
        this.elements = new CartWebElements();
        this.menuBarWebElements = new MenuBarWebElements();
    }

    @Step("Click on `CheckOut` button")
    public CartPage checkout(){
        DriverManager.getWebDriver().findElement(this.elements.checkoutButton).click();
        return this;
    }
}
