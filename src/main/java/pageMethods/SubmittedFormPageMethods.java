package pageMethods;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SubmittedFormPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class SubmittedFormPageMethods extends SubmittedFormPage {

    private static final Logger LOGGER = LogManager.getLogger(SubmittedFormPageMethods.class.getName());

    public SubmittedFormPageMethods(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public SubmittedFormPageMethods verifyWindowIsDisplayed() {
        LOGGER.info("Verify that window has correct header");
        assertThat(headerName.getText(), is("Thanks for submitting the form"));
        return this;
    }

    public SubmittedFormPageMethods verifyStudentName(String studentName) {
        LOGGER.info("Verify that student name is " + studentName);
        assertThat(studentNameValue.getText(), is(studentName));
        return this;
    }
}
