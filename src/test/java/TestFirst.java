import configuration.BaseClass;
import org.junit.Test;
import pages.SettingPage;

public class TestFirst extends BaseClass {
    static SettingPage settingPage=new SettingPage(driver);

//    @BeforeClass
//    public static  void b(){
//        settingPage=new SettingPage(driver);
//    }

    @Test
    public void test1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void test2(){
        settingPage.changeTemp('f');
    }
    @Test
    public void test3(){
        settingPage.changeSpeed(SettingPage.SPEED.METRES);
    }

}
