package techproed.tests.practice;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import techproed.pages.PracticePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.List;

public class P03 {

    //http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
    //Tüm ülkeleri yazdırınız
    //Ülkeler ile şehirleri eşleştiriniz


    @Test
    public void test01() {
        //http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html adresine gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("dhtmlUrl"));

        //Tüm ülkeleri yazdırınız
        PracticePage practicePage = new PracticePage();
        List<WebElement> countries = practicePage.countries;
        for (WebElement w : countries){
            System.out.println("Countries Name: " + w.getText());
        }

        //page.countries.forEach(t-> System.out.println(t.getText()));


        //Ülkeler ile şehirleri eşleştiriniz
        Actions actions = new Actions(Driver.getDriver());

        actions.dragAndDrop(practicePage.seoul, practicePage.SouthKorea).
                dragAndDrop(practicePage.oslo, practicePage.Norway).
                dragAndDrop(practicePage.stockholm, practicePage.Sweden).
                dragAndDrop(practicePage.rome, practicePage.Italy).
                dragAndDrop(practicePage.madrid, practicePage.Spain).
                dragAndDrop(practicePage.copenhagen, practicePage.Denmark).
                dragAndDrop(practicePage.washington, practicePage.UnitedStates).perform();

//        ActionsUtils.dragAndDrop(page.oslo,page.norway);
//        ActionsUtils.dragAndDrop(page.stockholm,page.sweden);
//        ActionsUtils.dragAndDrop(page.washington,page.unitedStates);
//        ActionsUtils.dragAndDrop(page.copenhagen,page.denmark);
//        ActionsUtils.dragAndDrop(page.seoul,page.southKorea);
//        ActionsUtils.dragAndDrop(page.rome,page.italy);
//        ActionsUtils.dragAndDrop(page.madrid,page.spain);

    }
}
