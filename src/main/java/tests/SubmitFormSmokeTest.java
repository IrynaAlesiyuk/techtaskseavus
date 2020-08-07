package tests;

import core.constants.GenderType;
import core.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageMethods.PracticeFormPageMethods;
import core.driver.DriverManagerFactory;

import static core.constants.BrowserType.CHROME;
import static core.constants.BrowserType.FIREFOX;

public class SubmitFormSmokeTest extends DriverManagerFactory {

    private static final String FIRST_NAME = "TestFirstName";
    private static final String LAST_NAME = "TestLastName";
    private static final String PHONE_NUMBER = "1234567890";

    DriverManager driverManager;
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(FIREFOX);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @AfterMethod
    public void shutdown() {
        driverManager.quitDriver();
    }

    @Test(description = "Fill in obligatory fields and submit form")
    public void fillInStudentForm() {
        new PracticeFormPageMethods(driver).fillObligatoryFieldsAndSubmitForm(FIRST_NAME, LAST_NAME, GenderType.MALE, PHONE_NUMBER, driver)
                .verifyWindowIsDisplayed()
                .verifyStudentName(FIRST_NAME + " " + LAST_NAME);
    }
}
