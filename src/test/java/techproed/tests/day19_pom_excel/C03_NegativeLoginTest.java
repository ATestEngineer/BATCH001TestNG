package techproed.tests.day19_pom_excel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import java.time.Duration;

public class C03_NegativeLoginTest {

    //Name: US01_Negative_Login

    //Description: Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali

    //Acceptance Criteria
    //Customer email: fake@bluerentalcars.com
    //Customer password: fakepass
    //Error:
    //User with email fake@bluerentalcars.com not found


    //sayfayı kapatınız

    BlueRentalPage blueRentalPage = new BlueRentalPage();

    @Test
    public void test01() {
        //BlueRentalCar sayfasına gidiniz
        Driver.getDriver().get("https://www.bluerentalcars.com/");

        //Login buttonuna tıklayalım
        blueRentalPage.loginButton.click();

        //Properties dosyasındaki kullanımda olmayan email ve password bilgileri ile login olamadığını test edelim
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmail"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("fakePassword"), Keys.ENTER);

        ReusableMethods.visibleWait(blueRentalPage.negatifLoginVerify, 10);
        Assert.assertTrue(blueRentalPage.negatifLoginVerify.isDisplayed());

        ReusableMethods.waitForSecond(3);
        Driver.closeDriver();


//        reusable methoddan önceki eski kullanım:
//        ReusableMethods.waitForSecond(3);
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(blueRentalPage.negatifLoginVerify));


    }
}
