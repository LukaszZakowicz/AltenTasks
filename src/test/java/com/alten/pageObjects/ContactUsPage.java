package com.alten.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends AbstractPage {

    private final By subjectHandlingLocator = By.id("id_contact");
    private final By emailLocator = By.id("email");
    private final By orderLocator = By.id("id_order");
    private final By messageLocator = By.id("message");
    private final By sendLocator = By.id("submitMessage");
    private final By finalMessageLocator = By.xpath("//p[@class='alert alert-success']");

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        title = "Contact us - My Store";
    }

    public void selectSubjectHandling(String subject) {
        Select subjectHandlingDropdown = new Select(driver.findElement(subjectHandlingLocator));
        subjectHandlingDropdown.selectByVisibleText(subject);
    }

    public void enterEmail(String email) {
        driver.findElement(emailLocator).sendKeys(email);
    }

    public void enterOrderReference(String orderReference) {
        driver.findElement(orderLocator).sendKeys(orderReference);
    }

    public void enterMessage(String messageText) {
        driver.findElement(messageLocator).sendKeys(messageText);
    }

    public void clickSend() {
        driver.findElement(sendLocator).click();
    }

    public String getResultMessage() {
        return driver.findElement(finalMessageLocator).getText();
    }
}
