package techproed.utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtilities {

    //Boundary Value Analysis (sınır değer analizi)
    //Equivalance Partitioning (eş değer analizi)

    @DataProvider(name = "positiveTestData")
    public static Object[][] provideBoundaryValueTestData() {
        return new Object[][] {
                { "18" },    // Alt sınır
                { "30" },  // Geçerli yaş
                { "100" },   // Üst sınır
        };
    }
    @DataProvider(name = "negativeTestData")
    public static Object[][] provideNegativeTestData() {
        return new Object[][] {
                { "17" },   // Alt sınırın altı
                { "101" }   // Üst sınırın üstü
        };
    }
    @DataProvider(name = "invalidTestData")
    public static Object[][] provideinvalidTestData() {
        return new Object[][] {
                { "ali" },   // invalidTestData
                { "?" },
                { "-5" }
        };
    }


}
