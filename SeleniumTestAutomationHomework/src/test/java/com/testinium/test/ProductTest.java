package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.*;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {

        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        FavoritesPage favoritesPage = new FavoritesPage();
        HomePage homePage = new HomePage();
        PointCatalogPage pointCatalogPage = new PointCatalogPage();

        loginPage.login();
        productPage.selectFavorites();
        favoritesPage.controlFavorites();
        homePage.openHomePage();
        pointCatalogPage.selectRandomBook();

    }


}
