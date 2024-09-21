package techproed.tests.practice;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;
import techproed.pages.DemoPage;
import techproed.utilities.ActionsUtils;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class P01 {

    //Go to https://demo.automationtesting.in/Register.html
    //fill firstname, secondname, address fields with faker
    // Get the fake email by going to https://www.fakemail.net/
    // go back and fill in the email address field with this email
    // upload a file to the page

    //https://demo.automationtesting.in/Register.html adresine gidin
// faker ile firstname, secondname, adress alanlari
// https://www.fakemail.net/ adresine giderek fake maili alinni doldurun
    // https://www.fakemail.net/ adresine giderek fake maili alin
// geri dönün ve email adress kısmını bu email ile doldurun
// sayfaya bir dosya yükleyin
// Diğer alanları doldurun
    Faker faker = new Faker();
    DemoPage demoPage = new DemoPage();

    @Test (description = "US03-Kullanıcı register işlemi yapar")
    public void test01() {

        //https://demo.automationtesting.in/Register.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("demoUrl"));

        // faker ile firstname, secondname, adress alanlarini doldurun
        demoPage.firstName.sendKeys(faker.name().firstName(), Keys.TAB,
                faker.name().lastName(), Keys.TAB,
                faker.address().fullAddress());


        // https://www.fakemail.net/ adresine giderek fake maili alin
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://www.fakemail.net/");
        String fakeMail = demoPage.fakeEmail.getText();

        // geri dönün ve email adress kısmını bu email ile doldurun
        ReusableMethods.switchToWindow(0);
        demoPage.emailBox.sendKeys(fakeMail);


        //"C:\Users\artis       \Downloads\human-3782189_640.jpg"
        String path = System.getProperty("user.home") + "\\Downloads\\human-3782189_640.jpg";
        demoPage.chooseFile.sendKeys(path);

        //Diğer alanları doldurun
        demoPage.phoneBox.sendKeys(faker.phoneNumber().phoneNumber());

        demoPage.genderRadioButton.click();
        demoPage.checkBox2.click();

        demoPage.languageDropDownBox.click();
        ReusableMethods.scrollEnd();
        demoPage.optionLanguageTurkish.click();

        ReusableMethods.ddmValue(demoPage.skillsDropDownBox, "Analytics");

        demoPage.countriesDropDownBox.click();
        demoPage.optionSelectCountry.click();
        demoPage.selectCountryDropDownBox.click();
        demoPage.optionBangladesh.click();
        ReusableMethods.ddmValue(demoPage.yearBox, "1919");
        ReusableMethods.ddmValue(demoPage.monthBox, "April");
        ReusableMethods.ddmValue(demoPage.yearBox, "5");

        String password = faker.internet().password();

        demoPage.firstPasswordBox.sendKeys(password);
        demoPage.secondPasswordBox.sendKeys(password);

        demoPage.submitButton.click();

    }
}
