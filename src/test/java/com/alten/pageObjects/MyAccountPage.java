package com.alten.pageObjects;

import org.openqa.selenium.WebDriver;

public class MyAccountPage extends AbstractPage {

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        title = "My account - My Store";
    }

}
