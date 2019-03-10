package com.alten.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

public abstract class AbstractPage {

    protected String title;
    protected WebDriver driver;

    private final By userLocator = By.className("account");
    private final By signInLocator = By.className("login");
    private final By contactUsLocator = By.cssSelector("a[title='Contact Us']");

    public void assertPageTitle() {
        assertTrue("Page title should be " + title + ", but was " + driver.getTitle() + " instead.", driver.getTitle().equals(title));
    }

    public void selectAllInField(By loc) {
        driver.findElement(loc).sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END));
    }

    public void verifyUserIsLogged(String user) {
        WebElement element = driver.findElement(userLocator);
        String actualText = element.getText();
        assertTrue("Expected user is: " + user + ", and actual user is: " + actualText, user.equals(actualText));
    }

    public void signIn() {
        driver.findElement(signInLocator).click();
    }

    public void contact() {
        driver.findElement(contactUsLocator).click();
    }

}
