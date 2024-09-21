package techproed.tests.day18_pom;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C04_PageClassUsage {


    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test01() throws InterruptedException {
        //amazon sayfasına gidelim
        Driver.getDriver().get("https://amazon.com");
        Thread.sleep(3000);

        //arama kutusunda iphone aratalim
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);

    }
}
