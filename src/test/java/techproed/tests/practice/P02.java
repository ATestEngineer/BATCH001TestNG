package techproed.tests.practice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class P02 {
    //Go to https://books-pwakit.appspot.com/
    //search for selenium in searchbox
    //test if the header contains selenium

    //https://books-pwakit.appspot.com/ adresine gidin
    //searchboxta selenium aratin
    //basligin selenium icerdigini test edin
    //Sayfayi kapatin


    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("bookUrl"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        WebElement searchBox = (WebElement) js.executeScript( "return document.querySelector(\"body > book-app\").shadowRoot.querySelector(\"#input\")" );

        searchBox.sendKeys("Selenium", Keys.ENTER);
        ReusableMethods.waitForSecond(1);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Selenium"));
        Driver.closeDriver();


    }
}
