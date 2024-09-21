package techproed.tests.day19_pom_excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C04_ExcelReaderTest {

    @Test
    public void test01() {

        String path = "src/test/java/techproed/resources/adminTestData.xlsx";
        String pageName = "customer_info";

        ExcelReader excelReader = new ExcelReader(path, pageName);

       String email = excelReader.getCellData(1,0);
       String password = excelReader.getCellData(1,1);

        System.out.println(email+" "+password);

       String email2 = excelReader.getCellData(3,0);
        String password2 = excelReader.getCellData(3,1);

        System.out.println(email2+" "+password2);


    }
}
