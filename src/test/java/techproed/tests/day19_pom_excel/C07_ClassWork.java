package techproed.tests.day19_pom_excel;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C07_ClassWork {

        //https://www.medunna.com/

    MedunnaPage medunnaPage = new MedunnaPage();
    Faker faker = new Faker();

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        medunnaPage.accountMenuButton.click();
        medunnaPage.registerButton.click();

        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid());

        //tüm alanları faker classından doldurun
        //register butonuna tıkla
        //butona tıkladıktan sonraki kısım doğrulama test case'i yazınız ve doğrulama yapınız


    }
}
