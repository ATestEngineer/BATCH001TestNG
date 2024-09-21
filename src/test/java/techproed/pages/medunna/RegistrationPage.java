package techproed.pages.medunna;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class RegistrationPage {

    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ssn")
    public WebElement ssnBox;

    @FindBy(xpath = "//div[text()='Your SSN is required.']")
    public WebElement ssnRequiredMessage;

    @FindBy(xpath = "//div[text()='Your SSN is invalid']")
    public WebElement ssnInvalidMessage;

    @FindBy(id = "firstName")
    public WebElement firstNameBox;

    @FindBy(xpath = "//div[text()='Your FirstName is required.']")
    public WebElement firstNameRequiredMessage;

    @FindBy(xpath = "//div[text()='Your LastName is required.']")
    public WebElement lastNameRequiredMessage;

    @FindBy(id = "lastName")
    public WebElement lastNameBox;

}
