package com.alten.pageObjects;

import org.openqa.selenium.WebDriver;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        this.driver = driver;
        title = "My Store";
    }

}
