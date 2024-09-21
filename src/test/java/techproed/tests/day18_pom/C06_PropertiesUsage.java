package techproed.tests.day18_pom;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C06_PropertiesUsage {

    @Test
    public void test01() {
        //1
        String url = ConfigReader.getProperty("amazonUrl");
        Driver.getDriver().get(url);


        //2
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
    }







}
