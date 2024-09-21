package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class DemoPage {

    public DemoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    public WebElement firstName;

    @FindBy (xpath = "//input[@type='email']")
    public WebElement emailBox;


    @FindBy (id = "imagesrc")
    public WebElement chooseFile;

    @FindBy (xpath = "//input[@type='tel']")
    public WebElement phoneBox;

    @FindBy (xpath = "//input[@value='FeMale']")
    public WebElement genderRadioButton;

    @FindBy (id = "checkbox3")
    public WebElement checkBox3;

    @FindBy (id = "checkbox2")
    public WebElement checkBox2;

    @FindBy (id = "checkbox1")
    public WebElement checkBox1;

    @FindBy (tagName = "multi-select")
    public WebElement languageDropDownBox;

    @FindBy (xpath = "//*[.='Turkish']")
    public WebElement optionLanguageTurkish;

    @FindBy (id = "Skills")
    public WebElement skillsDropDownBox;

    @FindBy (id = "countries")
    public WebElement countriesDropDownBox;

    @FindBy (xpath = "//*[.='Select Country']")
    public WebElement optionSelectCountry;

    @FindBy (id = "select2-country-container")
    public WebElement selectCountryDropDownBox;

    @FindBy (xpath = "//span[@title='Bangladesh']")
    public WebElement optionBangladesh;

    @FindBy (id = "yearbox")
    public WebElement yearBox;

    @FindBy (xpath = "//select[@ng-model='monthbox']")
    public WebElement monthBox;

    @FindBy (id = "daybox")
    public WebElement dayBox;

    @FindBy (id = "firstpassword")
    public WebElement firstPasswordBox;

    @FindBy (id = "secondpassword")
    public WebElement secondPasswordBox;

    @FindBy (id = "submitbtn")
    public WebElement submitButton;




    /*
   --------------- fake mail sitesi-------------------
     */

    //fake email sitesine ait zamandan kazanmak icin burada olusturduk
    @FindBy (id = "email")
    public WebElement fakeEmail;



}
