package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageobjects.LoginPage;
import com.practicetestautomation.pageobjects.SuccessfulLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(LoginTests.class);

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        logger.info("Running test in Chrome browser!");
    }

    @Test
    public void positiveLoginTest() {
        logger.info("Starting positiveLoginTest");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit();

        SuccessfulLoginPage successfulLoginPage = loginPage.executeLogin("student", "Password123");

        successfulLoginPage.load();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = successfulLoginPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        logger.info("Verifying login...");

        String expectedText = "Congratulations student. You successfully logged in!";
        String pageSource = successfulLoginPage.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText));

        Assert.assertTrue(successfulLoginPage.isLogOutButtonDisplayed());
    }

    @Test
    public void negativeLoginTest() {
        logger.info("Starting negativeLoginTest");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit();

        loginPage.executeLogin("username", "password");
        logger.info("Entered false username and password");

        String expectedErrorMessage = "Your username is invalid!";
        Assert.assertEquals(loginPage.getErrorMessage(), expectedErrorMessage);
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
        logger.info("Browser is closed!");
    }

}
