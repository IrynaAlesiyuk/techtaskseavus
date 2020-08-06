package pageMethods;


import core.constants.Gender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import pages.PracticeFormPage;
import pages.SubmittedFormPage;


public class PracticeFormPageMethods extends PracticeFormPage {


    private static final Logger LOGGER = LogManager.getLogger(PracticeFormPageMethods.class.getName());

    public PracticeFormPageMethods(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public SubmittedFormPageMethods fillObligatoryFieldsAndSubmitForm(String firstName, String lastName, Gender gender, String phoneNumber, WebDriver driver) {
        LOGGER.info("Fill in obligatory fields");
        fillInFirstName(firstName);
        fillInSecondName(lastName);
        selectGender(gender, driver);
        fillInPhoneNumber(phoneNumber);
        return clickSubmitBtn(driver);
    }

    private void fillInFirstName(String firstName) {
        LOGGER.info("Enter First Name=" + firstName);
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    private void fillInSecondName(String lastName) {
        LOGGER.info("Enter Second Name=" + lastName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    private void selectGender(Gender gender, WebDriver driver) {
        LOGGER.info("Select gender=" + gender);
        switch (gender) {
            case MALE:
                try {
                    genderMaleRadioBtn.click();
                } catch (WebDriverException e) {
                    JavascriptExecutor executor = (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click()", genderMaleRadioBtn);
                }
                break;
            case FEMALE:
                genderFemaleRadioBtn.click();
                break;
            default:
                genderOtherRadioBtn.click();
                break;
        }
    }

    private void fillInPhoneNumber(String phoneNumber) {
        LOGGER.info("Enter Phone Number=" + phoneNumber);
        mobileNumberField.clear();
        mobileNumberField.sendKeys(phoneNumber);
    }

    private SubmittedFormPageMethods clickSubmitBtn(WebDriver driver) {
        LOGGER.info("Click 'Submit' button");
        try {
            submitBtn.click();
        } catch (WebDriverException e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click()", submitBtn);
        }
        return new SubmittedFormPageMethods(driver);
    }

}
