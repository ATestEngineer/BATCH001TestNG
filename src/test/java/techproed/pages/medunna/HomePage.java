package techproed.pages.medunna;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "account-menu")
    public WebElement accountMenuDropDown;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

}
