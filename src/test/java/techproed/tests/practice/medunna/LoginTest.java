package techproed.tests.practice.medunna;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class LoginTest {
    //gerçek projede, bu class "test" package'ı içerisinde olmalı

    //Login işlemi için test case oluşturunuz

    //Credientals:
    //    #Medunna Datalari
    //    medunnaUrl=https://www.medunna.com/
    //    adminUserName=adminbatch210
    //    adminPassword=Batch210+
    //    userName=Admin Batch210

    //POSITIVE SMOKE TEST
    //İLK ÖNCE GEÇERLİ DATALAR İLE TESTİMİ GERÇEKLEŞTİRMELİYİM.


    @Test (description = "US01 - Kullanıcı geçerli datalar ile siteye giriş yapabilmeli")
    public void loginTest() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

        MedunnaPage medunnaPage = new MedunnaPage();

        medunnaPage.accountMenuButton.click();
        medunnaPage.loginButton.click();
        medunnaPage.userNameBox.sendKeys(ConfigReader.getProperty("adminUserName"));
        medunnaPage.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword"), Keys.ENTER);

        ReusableMethods.waitForSecond(3);

        medunnaPage.loginVerify.isDisplayed();
        Assert.assertEquals(medunnaPage.loginVerify.getText(), "Admin Batch210", "HATA");
        Assert.assertEquals(medunnaPage.loginVerify.getText(), ConfigReader.getProperty("userName"), "HATA");

    }


}
