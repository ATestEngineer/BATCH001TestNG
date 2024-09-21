package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class MedunnaPage {

    public MedunnaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        //bu constructor, bu classtaki objeleri, web elementleri, notasyonları; objeler ile ilişkilendirecek
    }



    //------------------------login page
    @FindBy(id = "account-menu")
    public WebElement accountMenuButton;

    @FindBy(id = "login-item")
    public WebElement loginButton;

    @FindBy(id = "username")
    public WebElement userNameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[.='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//span[.='Admin Batch210']")
    public WebElement loginVerify;





    //--------------------register page

     @FindBy(id= "ssn")
     public WebElement ssnTextBox;
    @FindBy (css= "#firstName")
    public WebElement firstNameTextBox;

    @FindBy (css= "#lastName")
    public WebElement lastNameTextBox;

    @FindBy (css= "#username")
    public WebElement userNameTextBox;

    @FindBy (css= "#email")
    public WebElement emailTextBox;

    @FindBy (css= "input[name='firstPassword']")
    public WebElement password1TextBox;

    @FindBy (css= "#secondPassword")
    public WebElement password2TextBox;

    @FindBy (css= "#register-submit")
    public WebElement registerButton2;

    @FindBy(xpath = "//*[.='Registration Saved']")
    public WebElement registrationSavedText;


    //---------------------------------password strength

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public WebElement passwordStrengthRed;

    @FindBy (xpath = "//li[@style='background-color: rgb(255, 153, 0);']")
    public WebElement passwordStrengthOrange;

    @FindBy (xpath = "//li[@style='background-color: rgb(153, 255, 0);']")
    public WebElement passwordStrengthGreen1;

    @FindBy (xpath = "//li[@style='background-color: rgb(0, 255, 0);']")
    public WebElement passwordStrengthGreen2;









}
