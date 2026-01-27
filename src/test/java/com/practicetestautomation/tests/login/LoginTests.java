package com.practicetestautomation.tests.login;

import com.practicetestautomation.pageobjects.LoginPage;
import com.practicetestautomation.pageobjects.SuccessfulLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void positiveLoginTest() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.visit();

        SuccessfulLoginPage successfulLoginPage = loginPage.executeLogin("student", "Password123");

        successfulLoginPage.load();

        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        String actualUrl = successfulLoginPage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        String expectedText = "Congratulations student. You successfully logged in!";
        String pageSource = successfulLoginPage.getPageSource();
        Assert.assertTrue(pageSource.contains(expectedText));

        Assert.assertTrue(successfulLoginPage.isLogOutButtonDisplayed());
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
