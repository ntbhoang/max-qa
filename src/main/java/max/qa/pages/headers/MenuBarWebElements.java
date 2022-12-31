package max.qa.pages.headers;

import org.openqa.selenium.By;

public class MenuBarWebElements {


    private By menuButton              = By.cssSelector("#react-burger-menu-btn");
    private By logoutSideBarLink       = By.cssSelector("#logout_sidebar_link");
    private By shoppingCartLink        = By.cssSelector(".shopping_cart_link");


    public By getMenuButton() {
        return menuButton;
    }

    public By getLogoutSideBarLink() {
        return logoutSideBarLink;
    }

    public By getShoppingCartLink() {
        return shoppingCartLink;
    }
}
