package techproed.tests.day20_dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {

    /*
    Dataprovider bircok veriyi test caslerde loop kullanmadan aktarmak icin
    testng den gelen bir özelliktir
    2 boyutlu object array return eder,
    Dataprovideri kullanabilmek icin @Test notasyonundan sonra
    parametre olarak dataprovider yazip asagidaki örnekte oldugu gibi bir isim veririz.
    Bu verileri kullanabilmek icin test methodunada data tipine uygun parametre ekleriz
    inttelijden dataprovideri olusturmasi icin yardim alabiliriz,
    sari uyarinin üzerinde bekledigimizde create ... seklinde cikan uyariya tiklamamiz yeterli olacaktir
    bizim data provedirda belirttigimiz data adedince ilgili test methodumuz tekrar tekrar calistirilir
    bunu arka planda testng kendisi otomatik olarak yapar
     */


    @DataProvider
    public static Object[][] isimler() {
        return new Object[][]{
                {"alican@can.com", "ali", 15, true},
                {"velican@can.com", "veli" , 8, false},
                {"ayse@can.com", "ayse", 90, true},
                {"fatma@can.com", "fatma", 102, false}
        };
    }



    @Test(dataProvider = "isimler" )
    public void test01(String email, String password, int age, boolean isValid) {
        System.out.println(email);
        System.out.println(password);
        System.out.println(age);

    }
}
