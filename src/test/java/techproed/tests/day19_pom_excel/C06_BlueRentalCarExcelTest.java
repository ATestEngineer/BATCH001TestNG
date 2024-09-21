package techproed.tests.day19_pom_excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C06_BlueRentalCarExcelTest {

    BlueRentalPage blueRentalPage = new BlueRentalPage();
   
    @Test
    public void test01() {
        
        //BlueRentalCar sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarUrl"));
        
        //Login buttonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        
        //Excel dosyasındaki tüm email ve password bilgileriyle login olalım ve login olduğumuzu doğrulayalım
        String path = "src/test/java/techproed/resources/adminTestData.xlsx";
        String pageName ="customer_info";
        ExcelReader excelReader = new ExcelReader(path, pageName);

        for (int i = 1; i <= excelReader.rowCount() ; i++) { //i 'nin 1 den başlama sebebi, sutun başlıklarını dahil etmemek

            String email = excelReader.getCellData(i,0);
            String password = excelReader.getCellData(i,1);

            blueRentalPage.loginButton.click();
            blueRentalPage.email.sendKeys(email);
            blueRentalPage.password.sendKeys(password, Keys.ENTER);

            blueRentalPage.dropDownMenuVerify.click();
            Assert.assertTrue(blueRentalPage.profileLink.isDisplayed());

            ReusableMethods.waitForSecond(1);
            blueRentalPage.logOutLink.click();
            ReusableMethods.waitForSecond(1);
            blueRentalPage.okButton.click();
            ReusableMethods.waitForSecond(1);

        }

        //sayfayı kapatalım
        Driver.closeDriver();
    }
}
