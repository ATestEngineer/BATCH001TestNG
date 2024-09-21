package techproed.tests.practice.classwork;

import org.openqa.selenium.WebElement;
import org.testng.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.pages.PracticePage;
import techproed.utilities.*;
import java.util.List;

@Listeners(techproed.utilities.ExtentReportsListener.class)

public class P01 {


    // Go to https://practicesoftwaretesting.com/#/
    //test if the page title contains "Software Testing"
    //test if the page url contains the word "practice"
    //test that the number of products displayed on the page is 9
    // test whether each product is displayed on the page
    // print the products displayed on the page to the console
    //test that the number of products containing "hammer" displayed on the page is 4


    @Test (description = "US002 - TC001 User verifies the product")
    public void productVisibilityTest() {


        //  https://practicesoftwaretesting.com/#/ sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("softwareTestingUrl"));
        ExtentReportUtils.extentTestInfo("Kullanıcı verilen adrese gider");



        //  sayfa basliginin "Software Testing" icerdigini test edin
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Software Testing"));
        ExtentReportUtils.extentTestPass("Sayfa başlığının 'Software Testing' icerdigi doğrulandı");


        //  sayfa url'nin "practice" kelimesini icerdigini test edin
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("practice"));
        ExtentReportUtils.extentTestPass("Sayfa urlinin 'practice' icerdigi doğrulandı");

        //  sayfada görüntülenen ürün sayisinin 9 oldugunu test edin
        PracticePage practicePage = new PracticePage();
        List<WebElement> products = practicePage.products;
        Assert.assertEquals(products.size(), 9);
        ExtentReportUtils.extentTestPass("Sayfada görüntülenen ürün sayısının '9' olduğu doğrulandı");

        WaitUtils.waitForPageToLoad(10);
        //  her bir ürününün sayfada görüntülendigini test edin
        for (WebElement w : products){
            Assert.assertTrue(w.isDisplayed());
        }


        WaitUtils.waitForPageToLoad(10);
        //  sayfada görüntülenen ürünleri konsol a yazdirin
        products.forEach(t -> System.out.println(t.getText()));


        WaitUtils.waitForPageToLoad(10);

        //  sayfada görüntülenen ürünlerden "hammer" iceren ürün sayisinin 4 oldugunu test edin


        int counter=0;

        for(WebElement w : products){
            if (w.getText().contains("hammer")){
                counter++;
            }
        }
        ExtentReportUtils.extentTestFail("sayfada görüntülenen hammer ürün sayısı 4 değil");
        ExtentReportUtils.addScreenShotToReport();

        Assert.assertEquals(counter, 4 );


        Driver.closeDriver();


    }

}
