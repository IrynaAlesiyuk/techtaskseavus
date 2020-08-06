package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage {

    @FindBy(id = "firstName")
    protected WebElement firstNameField;

    @FindBy(id = "lastName")
    protected WebElement lastNameField;

    @FindBy(id = "gender-radio-1")
    protected WebElement genderMaleRadioBtn;

    @FindBy(id = "gender-radio-2")
    protected WebElement genderFemaleRadioBtn;

    @FindBy(id = "gender-radio-3")
    protected WebElement genderOtherRadioBtn;

    @FindBy(id = "userNumber")
    protected WebElement mobileNumberField;

    @FindBy(id = "submit")
    protected WebElement submitBtn;
}
