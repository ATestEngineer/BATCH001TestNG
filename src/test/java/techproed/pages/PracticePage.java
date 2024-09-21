package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

import java.util.List;

public class PracticePage {

    public PracticePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "h5")
    public List<WebElement> products;



    //---------------------DHTML PAGE
    @FindBy(xpath = "//div[@id='countries']/div")
    public List<WebElement> countries;
    // List<WebDriver>     driver.findElements(...)


    //capitals
    @FindBy(id = "box1")
    public WebElement oslo;

    @FindBy(id = "box2")
    public WebElement stockholm;

    @FindBy(id = "box3")
    public WebElement washington;

    @FindBy(id = "box4")
    public WebElement copenhagen;

    @FindBy(id = "box5")
    public WebElement seoul;

    @FindBy(id = "box6")
    public WebElement rome;

    @FindBy(id = "box7")
    public WebElement madrid;


    //countries
    @FindBy(id = "box101")
    public WebElement Norway;

    @FindBy(id = "box102")
    public WebElement Sweden;

    @FindBy(id = "box103")
    public WebElement UnitedStates;

    @FindBy(id = "box104")
    public WebElement Denmark;

    @FindBy(id = "box105")
    public WebElement SouthKorea;

    @FindBy(id = "box106")
    public WebElement Italy;

    @FindBy(id = "box107")
    public WebElement Spain;

}

