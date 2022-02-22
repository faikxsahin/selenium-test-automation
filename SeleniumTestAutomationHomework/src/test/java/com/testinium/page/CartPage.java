package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class CartPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public CartPage() {

        methods = new Methods();

    }

    public void buyItem() {

        methods.click(By.id("sprite-cart-icon"));
        methods.waitBySeconds(2);

    }

}
