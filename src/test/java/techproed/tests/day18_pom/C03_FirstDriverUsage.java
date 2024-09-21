package techproed.tests.day18_pom;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import techproed.utilities.Driver;

public class C03_FirstDriverUsage {


    @Test
    public void test01() {

        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://facebook.com");
        Driver.getDriver().get("https://google.com");

        Driver.closeDriver();


    }




}

