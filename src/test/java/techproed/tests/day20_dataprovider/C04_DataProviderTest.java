package techproed.tests.day20_dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.DataProviderUtilities;
import techproed.utilities.Driver;

public class C04_DataProviderTest {

    @Test (dataProvider = "positiveTestData", dataProviderClass = DataProviderUtilities.class)
    public void test01(String age) {
        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get("https://dataprovider.netlify.app/");

        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.ageBox.sendKeys(age);
        // 1.yol Keys.TAB, Keys.ENTER
        //2.yol
        dataProviderPage.yasiDogrulaButton.click();
        Assert.assertTrue(dataProviderPage.resultText.isDisplayed());
        Driver.closeDriver();


    }


}
