package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener , IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context){
        System.out.println("onStart ==>> Tüm testlerden önce bir kez çağırılır" +context.getName());
    }

    @Override
    public void onFinish(ITestContext context){
        System.out.println("onFinish ==>> Tüm testlerden sonra bir kez çağırılır" +context.getName());
    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("onTestStart ==>> Tüm test methodlarından önce bir kez çağrılır" +result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("onTestSuccess ==>> sadece pass olan testlerden sonra bir kez çağrılır" +result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("onTestFailure==>> sadece fail olan testlerden sonra bir kez çağrılır" +result.getName());
        ReusableMethods.screenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("onTestSkipped==>> testleriniz arasında çalışmayan atlanan testler varsa bir kez çağrılır" +result.getName());
    }


     /*
    Bu methodun amaci sadece bir test basarisiz oldugu zaman
    o testi yeniden kac defa calistiracağımızi belirlemektir
    maxRetryCount = 1; ==>ek olarak calisma sayisidir
    Bu ornekte fail olan test normal bir kere calistiktan sonra,
    bir kere daha bu methodun calismasini saglayacak.
    buraya kac yazarsak o kadar tekrar calisir.
     */

    private static int retryCount = 0; //bir kez çalıştıracak, fail alırsa ;
    private static final int maxRetryCount = 1; //kaç kez kontrol etmek isterseniz o kadar kontrol eder
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true; //true döndürmesi, fail olan testin yeniden çalıştırılmasını sağlar
        }
        return false;
    }

    /*
    Bu method bir test methoduna bir RetryAnalyzer eklemek icin kullanilir
    Listeners classindaki retry methodunu yani yukarida yazmis oldugumuz methodu
    RetryAnalyzer olarak ayarlar
    Bu sayede test fail oldugu zaman Listeners clasimizdaki
    bu retry methodu cagrilir ve yukaridaki tekar calistirma uygulanmis olacak
     */

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(Listeners.class);
    }











}
