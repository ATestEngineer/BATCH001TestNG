package techproed.tests.day18_pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C01_SoftAssertion {

    @Test(groups = "smoke")
    public void test01() {

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(4,2);
        System.out.println("test çalışmaya devam etti");

        softAssert.assertNotEquals(2, 2);
        System.out.println("test çalışmaya devam etti");

        softAssert.assertTrue(1>2);
        System.out.println("test çalışmaya devam etti");

        softAssert.assertFalse(4>3);
        System.out.println("test çalışmaya devam etti");

        softAssert.assertAll();
        System.out.println("test fail olduğu için bu yazı consolda gözükmeyecek");

    }





}
