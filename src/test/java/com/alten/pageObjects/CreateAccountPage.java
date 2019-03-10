package com.alten.pageObjects;

import com.alten.Gender;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends AbstractPage {

    private final By firstNameLocator = By.id("customer_firstname");
    private final By lastNameLocator = By.id("customer_lastname");
    private final By MrLocator = By.cssSelector("#id_gender1");
    private final By MrsLocator = By.cssSelector("#id_gender2");
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("passwd");
    private final By address1Locator = By.id("address1");
    private final By cityLocator = By.id("city");
    private final By stateLocator = By.id("id_state");
    private final By zipLocator = By.id("postcode");
    private final By countryLocator = By.id("id_country");
    private final By phoneLocator = By.id("phone_mobile");
    private final By aliasLocator = By.id("alias");
    private final By registerButtonLocator = By.id("submitAccount");

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        title = "Login - My Store";
    }

    public void waitForPageToLoad() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(firstNameLocator));
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(driver.findElement(firstNameLocator)));
    }

    public void selectGender(Gender gender) {
        if (gender == Gender.MALE) {
            driver.findElement(MrLocator).click();
        } else {
            driver.findElement(MrsLocator).click();
        }
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameLocator).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameLocator).sendKeys(lastName);
    }

    public void assertEmail(String email) {
        Assert.assertTrue(driver.findElement(emailLocator).getAttribute("value").equals(email));
    }

    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void enterAddressLine1(String address1) {
        driver.findElement(address1Locator).sendKeys(address1);
    }

    public void enterCity(String city) {
        driver.findElement(cityLocator).sendKeys(city);
    }

    public void selectState(String state) {
        Select stateDropdown = new Select(driver.findElement(stateLocator));
        stateDropdown.selectByVisibleText(state);
    }

    public void enterZip(String zip) {
        driver.findElement(zipLocator).sendKeys(zip);
    }

    public void selectCountry(String country) {
        Select countryDropdown = new Select(driver.findElement(countryLocator));
        countryDropdown.selectByVisibleText(country);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneLocator).sendKeys(phone);
    }

    public void enterAlias(String alias) {
        selectAllInField(aliasLocator);
        driver.findElement(aliasLocator).sendKeys(alias);
    }

    public void clickRegister() {
        driver.findElement(registerButtonLocator).click();
    }

}
