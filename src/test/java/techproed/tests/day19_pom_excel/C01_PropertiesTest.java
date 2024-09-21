package techproed.tests.day19_pom_excel;

import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_PropertiesTest {


    @Test
    public void test01() {

        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("openSourceUrl"));

        //kullanici=Admin
        //kullaniciSifre=admin123
        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim login olalım
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("openSourceUserName"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("openSourcePassword"));
        openSourcePage.loginButton.submit();

        //Login Testinin basarili oldugunu test edelim
        Assert.assertTrue(openSourcePage.dashBoard.isDisplayed());

        //Yeni açılan sayfanın ekran görüntüsünü alalım
        ReusableMethods.screenShot("open source");

        //Dashboard yazısnın ekran görüntüsünü alalım
        ReusableMethods.screenShotOfWebElement(openSourcePage.dashBoard);

        //sayfayi kapatalim
        ReusableMethods.waitForSecond(1);
        Driver.closeDriver();

    }
}
