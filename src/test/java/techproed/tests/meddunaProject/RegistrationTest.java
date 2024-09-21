package techproed.tests.meddunaProject;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import techproed.pages.medunna.HomePage;
import techproed.pages.medunna.RegistrationPage;
import techproed.utilities.*;

public class RegistrationTest {

    /*
                             US001: SSN, Ad ve Soyad kullanılarak kayıt yapılabilmelidir

      AC004: Herhangi bir karakter içeren geçerli bir soyadı olmalıdır ve bu zorunlu bir alandır
          AC004TC01: Kullanıcı soyadını boş bırakır, “Soyadınız gereklidir.” mesajı olmalıdır.
          AC004TC02: Kullanıcı soyadını yalnızca boşluk bırakarak girer, “Soyadınız gereklidir.” mesajı olmalıdır. (space karakteri)
          AC004TC03: Kullanıcı herhangi bir karakter içeren soyadı girer, herhangi bir hata mesajı olmamalıdır
   */

    HomePage homePage = new HomePage();
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
        ExtentReportUtils.extentTestInfo("Kullanıcı belirtilen siteye (https://www.medunna.com/) gider");
        ExtentReportUtils.extentTestPass("Kullanıcı anasayfaya gider");
        homePage.accountMenuDropDown.click();
        ExtentReportUtils.extentTestPass("Kullanıcı insan sembolune tıklar");
        WaitUtils.waitFor(1);
        homePage.registerButton.click();
        ExtentReportUtils.extentTestPass("Kullanıcı register butonuna tıklar");

        //BrowserUtils.clickWithTimeOut(homePage.accountMenuDropDown, 2);  > imkan

    }

    @Test (description = "US001-AC001")
    public void test01() {

         //AC001: 3. ve 5. rakamlardan sonra “-” işaretine uyarak geçerli bir SSN olmalıdır, 9 rakam uzunluğunda olmalıdır


        //AC001-TC01: Kullanıcı ssn 22255-5432'yi girer, “SSN'niz geçersiz” mesajı olmalıdır
        registrationPage.ssnBox.sendKeys("22255-5432", Keys.TAB);
        ExtentReportUtils.addScreenShotToReport();
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);
        WaitUtils.waitFor(1);

        //AC001-TC02: Kullanıcı 222-555432 numaralı SSN'yi girer, “SSN'niz geçersiz” mesajı olmalı
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-555432", Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);
        WaitUtils.waitFor(1);

       //AC001-TC03: Kullanıcı 222-55-543 numaralı SSN'yi girer, “SSN'niz geçersiz” mesajı olmalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-543", Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);
        WaitUtils.waitFor(1);


        //AC001-TC04: Kullanıcı 222-55-543a ssn'sini girdiğinde “SSN'niz geçersiz” mesajı çıkmalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-543a", Keys.TAB);
        ExtentReportUtils.addScreenShotToReport();
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnInvalidMessage);
        WaitUtils.waitFor(1);

        //AC001-TC05: Kullanıcı 222-55-5432 numaralı ssn'yi girer, herhangi bir hata mesajı olmamalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-5432", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.ssnInvalidMessage);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);
        ExtentReportUtils.addScreenShotToReport();
    }

    @Test (description = "US001-AC002")
    public void test02() {
                                          //        AC002: SSN boş bırakılamaz

        //        AC002TC01: Kullanıcı ssn'yi boş bırakır, “SSN'niz gereklidir” mesajı olmalıdır.
        registrationPage.ssnBox.sendKeys(Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);

        //        AC002TC02: Kullanıcı yalnızca ssn alanına sadece space karakteri girer, “SSN'niz gereklidir” mesajı olmalıdır.
        registrationPage.ssnBox.sendKeys(" ", Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(registrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);

        //        AC002TC03: Kullanıcı 222-55-5432 numaralı ssn'yi girer, herhangi bir hata mesajı olmamalıdır
        registrationPage.ssnBox.clear();
        registrationPage.ssnBox.sendKeys("222-55-5432", Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.ssnInvalidMessage);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.ssnRequiredMessage);
        WaitUtils.waitFor(1);

    }

    @Test(description = "US001-AC003")
    public void test03() {
                            // AC003: Herhangi bir karakter içeren ve space karakteri içermeyen geçerli bir ad olmalıdır


//        AC003TC01: Kullanıcı İlk Adı boş bırakır, “İlk Adınız gereklidir.” mesajı olmalıdır.
        registrationPage.firstNameBox.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);


//        AC003TC02: Kullanıcı yalnızca First Name alanını space karakteri girer, “First Name" gereklidir.” mesajı olmalıdır.
        registrationPage.firstNameBox.sendKeys(" ", Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementDisplayed(registrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);


//        AC003TC03: Kullanıcı herhangi bir karakter içeren bir ad girdiğinde, herhangi bir hata mesajı olmamalıdır
        registrationPage.firstNameBox.clear();
        WaitUtils.waitFor(1);
        registrationPage.firstNameBox.sendKeys("Ali123.", Keys.TAB);
        WaitUtils.waitFor(1);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.firstNameRequiredMessage);
        WaitUtils.waitFor(1);
    }

    @Test(description = "US001_AC004: Herhangi bir karakter içeren geçerli bir soyadı olmalıdır ve bu zorunlu bir alandır")
    public void test04() {
        // AC004TC01: Kullanıcı soyadını boş bırakır, "Soyadınız gereklidir." mesajı olmalıdır.
        registrationPage.lastNameBox.sendKeys(Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.lastNameRequiredMessage);

        // AC004TC02: Kullanıcı soyadını yalnızca boşluk bırakarak girer, "Soyadınız gereklidir." mesajı olmalıdır.
        registrationPage.lastNameBox.sendKeys(" ",Keys.TAB);
        BrowserUtils.verifyElementDisplayed(registrationPage.lastNameRequiredMessage);

        // AC004TC03: Kullanıcı herhangi bir karakter içeren soyadı girer, herhangi bir hata mesajı olmamalıdır
        registrationPage.lastNameBox.clear();
        registrationPage.lastNameBox.sendKeys("Ab12#",Keys.TAB);
        BrowserUtils.verifyElementNotDisplayed(registrationPage.lastNameRequiredMessage);
        Driver.closeDriver();
    }



}
