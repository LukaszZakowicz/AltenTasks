package com.alten;

import com.alten.pageObjects.*;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AutomationPractice {

    // Test data
    private static String pageURL = "http://automationpractice.com/index.php";
    private static String firstName = "Lukasz";
    private static String lastName = "Zakowicz";
    private static String email = Helpers.generateEmail();
    private static String password = "mySecretPassword";

    WebDriver driver;
    MainPage mainPage;

    @Before
    public void initializeTestPage() {

        // Initialize Chrome Driver
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        // Open browser
        driver.navigate().to(pageURL);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage.assertPageTitle();
    }

    @Test
    public void aa_registerUser() {

        // Create page objects for all pages used in the test
        AuthenticationPage authPage = new AuthenticationPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Click "Sign in"
        mainPage.signIn();
        authPage.assertPageTitle();

        // Submit email
        authPage.submit(email);
        createAccountPage.assertPageTitle();

        // Fill in all mandatory fields
        createAccountPage.waitForPageToLoad();
        createAccountPage.selectGender(Gender.MALE);
        createAccountPage.enterFirstName(firstName);
        createAccountPage.enterLastName(lastName);
        createAccountPage.assertEmail(email);
        createAccountPage.enterPassword(password);
        createAccountPage.enterAddressLine1("my address");
        createAccountPage.enterCity("Boston");
        createAccountPage.selectState("Massachusetts");
        createAccountPage.enterZip("12345");
        createAccountPage.selectCountry("United States");
        createAccountPage.enterPhone("123456789");
        createAccountPage.enterAlias("myAlias");

        // Click register
        createAccountPage.clickRegister();
        myAccountPage.assertPageTitle();

        // Verify that user is logged in
        myAccountPage.verifyUserIsLogged(firstName + " " + lastName);
    }

    @Test
    public void authoriseExistingUser() {

        // Create page objects for all pages used in the test
        AuthenticationPage authPage = new AuthenticationPage(driver);
        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        MyAccountPage myAccountPage = new MyAccountPage(driver);

        // Click "Sign in"
        mainPage.signIn();
        authPage.assertPageTitle();

        // Login
        authPage.login(email, password);
        myAccountPage.assertPageTitle();

        // Verify that user is logged in
        myAccountPage.verifyUserIsLogged(firstName + " " + lastName);
    }

    @Test
    public void contactSupport() {

        String finalMessage = "Your message has been successfully sent to our team.";

        // Create page objects for all pages used in the test
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        // Click "Contact Us"
        mainPage.contact();
        contactUsPage.assertPageTitle();

        // Fill in the form
        contactUsPage.selectSubjectHandling("Customer service");
        contactUsPage.enterEmail(email);
        contactUsPage.enterOrderReference("12345");
        contactUsPage.enterMessage("Hey, where is my order?");

        // Click "Send"
        contactUsPage.clickSend();

        // Verify that message was sent
        Assert.assertTrue("Expected: " + finalMessage + ", actual: " + contactUsPage.getResultMessage(),
                contactUsPage.getResultMessage().equals(finalMessage));
    }

    @After
    public void cleanupAfterTest() {
        driver.close();
    }
}
