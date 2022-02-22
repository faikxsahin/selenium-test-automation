package com.testinium.page;

import com.testinium.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FavoritesPage {

    Methods methods;
    Logger logger = LogManager.getLogger(FavoritesPage.class);

    public FavoritesPage() {

        methods = new Methods();

    }

    public void controlFavorites() {

        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[text()='Favorilerim']"));
        methods.waitBySeconds(2);
//        Assert.assertTrue(methods.isElementVisible(By.id("product-593012")));
//        Assert.assertTrue(methods.isElementVisible(By.id("product-561234")));
//        Assert.assertTrue(methods.isElementVisible(By.id("product-133053")));
//        Assert.assertTrue(methods.isElementVisible(By.id("product-394421")));

    }

}
