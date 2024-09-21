package techproed.tests.day17_annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C05_DependsOnMethod {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://amazon.com");
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium", Keys.ENTER);


        Assert.assertTrue(false);    //Burada kasten fail aldik böylece bu teste bagli olan method calismayacak

    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        //sonuc yazisinin testng icerdigini test edelim

        String actualResultText=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();
        System.out.println("actualResultText = " + actualResultText);
        Assert.assertTrue(actualResultText.contains("selenium"));
    }

}
