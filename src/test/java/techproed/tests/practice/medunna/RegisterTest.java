package techproed.tests.practice.medunna;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.MedunnaPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class RegisterTest {

    MedunnaPage medunnaPage = new MedunnaPage();
    Faker faker = new Faker();

    @Test
    public void registerTest() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

        medunnaPage.accountMenuButton.click();
        medunnaPage.registerButton.click();

        //SSN
        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid());

        //first name
        String firstName = faker.name().firstName();
        medunnaPage.firstNameTextBox.sendKeys(firstName);

        //last name
        String lastName = faker.name().lastName();
        medunnaPage.lastNameTextBox.sendKeys(lastName);

        //user name _ full name
        String username = firstName + lastName;
        medunnaPage.userNameTextBox.sendKeys(username);

        //email
        medunnaPage.emailTextBox.sendKeys(faker.internet().emailAddress());

        //password
        String password = faker.internet().password(8,12,true, true, true);
        medunnaPage.password1TextBox.sendKeys(password);

        //confirm password
        medunnaPage.password2TextBox.sendKeys(password, Keys.ENTER);


        ReusableMethods.visibleWait(medunnaPage.registrationSavedText, 10);

        Assert.assertTrue(medunnaPage.registrationSavedText.isDisplayed());

        Driver.closeDriver();

    }


    @Test
    public void test02() {

        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));

        medunnaPage.accountMenuButton.click();
        medunnaPage.registerButton.click();

        String password = faker.internet().password(10, 15, true, true, true);

        medunnaPage.ssnTextBox.sendKeys(faker.idNumber().ssnValid(),
                Keys.TAB,
                faker.name().firstName(),
                Keys.TAB,
                faker.name().lastName(),
                Keys.TAB,
                faker.name().username(),
                Keys.TAB,
                faker.internet().emailAddress(),
                Keys.TAB,
                password,
                Keys.TAB,
                password,
                Keys.TAB,
                Keys.ENTER);

        ReusableMethods.visibleWait(medunnaPage.registrationSavedText, 10);

        Assert.assertTrue(medunnaPage.registrationSavedText.isDisplayed());

        Driver.closeDriver();

    }
}
