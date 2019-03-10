package com.alten.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends AbstractPage {

    private final By newEmailLocator = By.id("email_create");
    private final By existingEmailLocator = By.id("email");
    private final By submitCreateLocator = By.id("SubmitCreate");
    private final By passwordLocator = By.id("passwd");
    private final By signInLocator = By.id("SubmitLogin");

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        title = "Login - My Store";
    }

    public void submit(String email) {
        driver.findElement(newEmailLocator).sendKeys(email);
        driver.findElement(submitCreateLocator).click();
    }

    public void login(String email, String password) {
        driver.findElement(existingEmailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(signInLocator).click();
    }
}
