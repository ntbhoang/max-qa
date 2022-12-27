package max.qa.pages.cart_page;

import io.qameta.allure.Step;
import max.qa.driver.DriverManager;

public class CartPage {

    protected CartWebElements elements;

    public CartPage(){
        this.elements = new CartWebElements();
    }

    @Step("Click on `CheckOut` button")
    public CartPage checkout(){
        DriverManager.getWebDriver().findElement(this.elements.checkoutButton).click();
        return this;
    }
}
