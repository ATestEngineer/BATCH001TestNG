package techproed.tests.day21_xmlfiles_paralleltest;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ParallelTest {

    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.closeDriver();

    }

    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("techproedUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalCarUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.closeDriver();
    }


}
