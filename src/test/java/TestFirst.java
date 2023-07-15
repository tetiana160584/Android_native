import configuration.BaseClass;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SettingPage;

import java.time.Duration;

public class TestFirst extends BaseClass {
    static SettingPage settingPage = new SettingPage(driver);

//    @BeforeClass
//    public static  void b(){
//        settingPage=new SettingPage(driver);
//    }

    @Test
    public void test1() {
        System.out.println(driver.currentActivity());
    }

    @Test
    public void test2() {
        settingPage.changeTemp('f');
    }

    @Test
    public void test3() {
        settingPage.changeSpeed(SettingPage.SPEED.METRES);
    }

    @Test
    public void testChangeTime() {
        settingPage.changeTime(SettingPage.TIME.UK);
    }

    @Test
    public void testChangeNotification() {
        settingPage.changeNotification(SettingPage.NOTIF.ON);
    }


    @Test
    public void testChangeStatusBar() {
        settingPage.changeStatusBar(SettingPage.StBar.Yes);
    }



}




