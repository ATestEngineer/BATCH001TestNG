package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {

    public BlueRentalPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.=' Login']")
    public WebElement loginButton;


    @FindBy(id = "formBasicEmail")
    public WebElement email;

    @FindBy(id = "formBasicPassword")
    public WebElement password;

    @FindBy(id = "dropdown-basic-button")
    public WebElement dropDownMenuVerify;

    @FindBy(xpath = "//*[contains(text(), 'not found')]")
    public WebElement negatifLoginVerify;

    @FindBy(tagName = "em")
    public WebElement emailVerify;

    @FindBy(xpath= "//*[.='Profile']")
    public WebElement profileLink;

    @FindBy(xpath= "//*[.='Logout']")
    public WebElement logOutLink;

    @FindBy(xpath= "//*[.='OK']")
    public WebElement okButton;
}
