package max.qa.pages.cart_page;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CartWebElements {


    public CartWebElements(){}

    protected By quantity = By.cssSelector(".cart_quantity");
    protected By inventoryName = By.cssSelector(".inventory_item_name");
    protected By price = By.cssSelector(".inventory_item_price");
    protected By checkoutButton = By.cssSelector("#checkout");
    protected By continueButton = By.cssSelector("#continue");


    public By getCartElement(String name){
        By returnedElement = null;
        switch (name.toLowerCase()){
            case "quantity":
                returnedElement = this.quantity;
                break;

            case "price":
                returnedElement = this.price;
                break;
            case "inventory":
                returnedElement = this.inventoryName;
            break;
        }
        return returnedElement;
    }
}
