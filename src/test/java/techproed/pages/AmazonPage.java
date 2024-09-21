package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class AmazonPage {

     /*
        PageFactory.initElements() kodu bu classtaki ögeleri webdriver ile eslestirir
        Bu sayede classtaki webelementlere erismek icin @FindBy gibi PageFactory ye yardimci olan
        annotationlar kullanilabilir
        */

    public AmazonPage(){
        PageFactory.initElements(Driver.getDriver(), this);
        //bu constructor, bu classtaki objeleri, web elementleri, notasyonları; objeler ile ilişkilendirecek

    }

    //Web element locate

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchBox;

    //initElements(); bu method, page class içerisinde depolayacağımız web elementlerin driver aracılığıyla
    //başlatılmaısnı sağlar

    //captcha handle işlemi
    @FindBy(xpath = "//*[contains(text(), 'Try different image')]")
    public WebElement captchaHandling;

    public void handleCaptcha(){
        try {
            ReusableMethods.click(captchaHandling);
        }catch (Exception e){
            //captcha'nin çıkmaması durumunda, alacağımız exception'ı, burayı boş bırakarak ignore etmiş oluruz
        }

    }




}
