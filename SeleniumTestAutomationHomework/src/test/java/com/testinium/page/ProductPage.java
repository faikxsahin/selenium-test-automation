package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProductPage {

    Methods methods;
    Logger logger = LogManager.getLogger(ProductPage.class);

    public ProductPage() {

        methods = new Methods();

    }

    public void selectFavorites() {

        methods.sendKeys(By.id("search-input"), "oyuncak");
        methods.waitBySeconds(2);
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(2);
        methods.scrollWithAction(By.id("faceted-search-group-6"));
        methods.waitBySeconds(2);
        methods.addFavorites();
        methods.waitBySeconds(2);

    }

}
