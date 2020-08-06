package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubmittedFormPage {

    @FindBy(id = "example-modal-sizes-title-lg")
    protected WebElement headerName;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    protected WebElement studentNameValue;

    @FindBy(id = "closeLargeModal")
    protected WebElement closeBtn;
}
