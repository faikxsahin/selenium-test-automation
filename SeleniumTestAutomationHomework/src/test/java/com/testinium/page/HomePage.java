package com.testinium.page;

import com.testinium.methods.Methods;
import org.openqa.selenium.By;

public class HomePage {

    Methods methods;

    public HomePage() {

        methods = new Methods();

    }

    public void openHomePage() {

        methods.click(By.cssSelector(".logo-text"));
        methods.click(By.cssSelector(".lvl1catalog"));

    }

}
