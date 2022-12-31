package max.qa.pages.inventory_page;

import org.openqa.selenium.By;

public class InventoryWebElements {

    protected String addToCartStr       = "#add-to-cart-sauce-labs-%s";

    public By getAddToCartButton(String name){
        String tempCss = String.format(addToCartStr, name);
        return By.cssSelector(tempCss);
    }
}
