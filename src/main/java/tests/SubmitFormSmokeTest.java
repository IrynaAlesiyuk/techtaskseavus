package tests;

import core.constants.Gender;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageMethods.PracticeFormPageMethods;
import utils.DriversManager;

import static core.constants.Browsers.CHROME;

public class SubmitFormSmokeTest extends DriversManager {

    private static final String FIRST_NAME = "TestFirstName";
    private static final String LAST_NAME = "TestLastName";
    private static final String PHONE_NUMBER = "1234567890";

    @BeforeClass
    public void setup() {
        driver = initBrowser(CHROME);
        driver.get("https://demoqa.com/automation-practice-form");
    }

    @Test(description = "Fill in obligatory fields and submit form")
    public void fillInStudentForm() {
        new PracticeFormPageMethods(driver).fillObligatoryFieldsAndSubmitForm(FIRST_NAME, LAST_NAME, Gender.MALE, PHONE_NUMBER, driver)
                .verifyWindowIsDisplayed()
                .verifyStudentName(FIRST_NAME + " " + LAST_NAME);
    }

    @AfterMethod
    public void shutdown() {
        driver.close();
    }
}
