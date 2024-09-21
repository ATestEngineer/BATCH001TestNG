package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_DataProvider {


    /*
    data provider, ilk otomatik oluşturulduğunda, "(name = "amazonProducts")" gibi bir ifade ile oluşturulmaz.
    biz ne zaman testlerimizi özelleştirmek istersek, dataprovider'ı belli gurup teste özel yapmak istersek;
    "(name = "amazonProducts")" bu eklentiyi data provider'ın yanına ekleriz
     */


    @DataProvider (name = "amazonProducts")
    public static Object[][] products() {
        return new Object[][]{
                {"laptop"}, {"phone"}, {"mouse"}, {"mousepad"}
        };
    }



    @Test(dataProvider = "googleProducts")
    public void test01(String product) {

        //Google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //DataProvider ile istediğimiz ürünleri aratalım
        GooglePage googlePage = new GooglePage();
        googlePage.searchBox.sendKeys(product, Keys.ENTER);

        //sayfayı kapatalım
        Driver.closeDriver();

    }


    //aynı data provider'ı farklı test methodlarıyla kardeş kardeş kullanmanın örneği:
    @Test (dataProvider = "amazonProducts")
    public void test02(String data) {
        //amazon sayfasına gidelim,
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //aramakutusunda dataprovider'dan gelen verileri aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.handleCaptcha();
        amazonPage.searchBox.sendKeys(data, Keys.ENTER);

        Driver.closeDriver();

    }
}
