package techproed.tests.day20_dataprovider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderTest {


    @DataProvider
    public static Object[][] credentials() {

        ExcelReader excelReader = new ExcelReader("src/test/java/techproed/resources/adminTestData.xlsx", "customer_info");

        return new Object[][]{
                {ConfigReader.getProperty("blueRentalEmail1"), ConfigReader.getProperty("blueRentalPassword1")},
                {excelReader.getCellData(1, 0), excelReader.getCellData(1,1)},
                {"beyhancan@bluerentalcars.com", "beyhan"},
                {"johnson@bluerentalcars.com", "johnson"}
        };
    }




    @Test (dataProvider = "credentials")
    public void test01(String email, String password) {
        // BlueRentalCar Sayfasına Gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarUrl"));

        // Login butonuna tıklayalım
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();

        // Dataprovider Kullanarak verilen email ve password bilgileri ile login olalım
        blueRentalPage.email.sendKeys(email);
        blueRentalPage.password.sendKeys(password, Keys.ENTER);


        // Sayfayı kapatalım
        ReusableMethods.waitForSecond(3);
        Driver.closeDriver();
    }
}
