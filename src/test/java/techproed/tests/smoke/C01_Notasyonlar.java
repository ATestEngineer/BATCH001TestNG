package techproed.tests.smoke;

import org.testng.annotations.*;

public class C01_Notasyonlar {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Her şeyden önce @BeforeSuite notasyonuna sahip method 1 kez çalışır");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Her şeyden sonra @AfterSuite notasyonuna sahip method 1 kez çalışır");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden önce @BeforeTest notasyonuna sahip method 1 kez çalışır");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Testlerden sonra @AfterTest notasyonuna sahip method 1 kez çalışır");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Her class'tan önce @BeforeClass notasyonuna sahip method 1 kez çalışır");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Her class'tan sonra @AfterClass notasyonuna sahip method 1 kez çalışır");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Her test methodundan önce @BeforeMethod notasyonuna sahip method 1 kez çalışır");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Her test methodundan sonra @AfterMethod notasyonuna sahip method 1 kez çalışır");
    }

    @Test
    public void test01() {
        System.out.println("test01 methodu çalıştı");
    }

    @Test
    public void test02() {
        System.out.println("test02 methodu çalıştı");
    }

    @Test
    public void test03() {
        System.out.println("test03 methodu çalıştı");
    }
}
