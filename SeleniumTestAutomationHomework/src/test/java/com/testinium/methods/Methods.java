package com.testinium.methods;

import com.testinium.driver.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    Logger logger = LogManager.getLogger(Methods.class);

    public Methods() {

        driver = BaseTest.driver;

        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(30)).
                pollingEvery(Duration.ofMillis(300)).
                ignoring(NoSuchElementException.class);

        jsdriver = (JavascriptExecutor) driver;

    }

    public WebElement findElement(By by) {

        return wait.until(ExpectedConditions.presenceOfElementLocated(by));

    }

    public void click(By by) {

        findElement(by).click();

    }

    public void sendKeys(By by, String text) {

        findElement(by).sendKeys(text);

    }

    public void waitBySeconds(long seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean isElementVisible(By by) {

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            logger.info("True");
            return true;
        } catch (Exception e) {
            logger.info("False" + e.getMessage());
            return false;
        }

    }

    public void scrollWithAction(By by) {

        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }

    public void scrollWithAction(WebElement el) {

        Actions actions = new Actions(driver);
        actions.moveToElement(el).build().perform();

    }

    public void addFavorites() {

        List<WebElement> products = findElements(By.cssSelector(".add-to-favorites"));

        for (int i = 3; i < 7; i++) {
            WebElement el = products.get(i);
            scrollWithAction(el);
            products.get(i).click();
            waitBySeconds(2);
        }

    }

    public Select getSelect(By by) {
        return new Select(findElement(by));
    }

    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);
    }

    public List<WebElement> findElements(By by) {

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        return driver.findElements(by);

    }

    public void randomSelect(By locator) {

        Random rand = new Random();
        findElements(locator).get(rand.nextInt(findElements(locator).size())).click();

    }

    public String getText(By by) {
        return findElement(by).getText();
    }

}
