package techproed.tests.practice.medunna;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class PasswordStrength {
    MedunnaPage medunnaPage = new MedunnaPage();

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

        medunnaPage.accountMenuButton.click();
        medunnaPage.registerButton.click();

        medunnaPage.password1TextBox.sendKeys("abcd");
        Assert.assertTrue(medunnaPage.passwordStrengthRed.isDisplayed(), "HATA");

        ReusableMethods.waitForSecond(2);

        medunnaPage.password1TextBox.sendKeys("123");
        Assert.assertTrue(medunnaPage.passwordStrengthOrange.isDisplayed(), "HATA");

        ReusableMethods.waitForSecond(2);
        medunnaPage.password1TextBox.sendKeys("+");
        Assert.assertTrue(medunnaPage.passwordStrengthGreen1.isDisplayed(), "HATA");

        ReusableMethods.waitForSecond(2);
        medunnaPage.password1TextBox.sendKeys("B");
        Assert.assertTrue(medunnaPage.passwordStrengthGreen2.isDisplayed(), "HATA");

    }
}
