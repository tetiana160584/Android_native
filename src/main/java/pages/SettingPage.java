package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingPage {
    By tempID = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By titleSpeed = By.id("com.weather.forecast.weatherchannel:id/md_title");
    By speedD = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By speedFormat = By.id("com.weather.forecast.weatherchannel:id/tv_wind_speed_format");
    By formatTime = By.id("com.weather.forecast.weatherchannel:id/tg_format_time_setting");
    By notification = By.id("com.weather.forecast.weatherchannel:id/tgNotifi_settings");
    By statusBar = By.id("com.weather.forecast.weatherchannel:id/tg_notifi_second_settings");
    By doneButton = By.id("com.weather.forecast.weatherchannel:id/tvDone");

    public SettingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private static AndroidDriver driver;



    public void changeTime(TIME time) {
        MobileElement buttonTime = (MobileElement) driver.findElement(formatTime);
        switch (time){
            case USA:{
                if (buttonTime.getAttribute("checked").equals("false")){
                    buttonTime.click();
                }
            }
            break;
            case UK:{
                if (buttonTime.getAttribute("checked").equals("true")){
                    buttonTime.click();
                }
            }
            break;
        }
    }
    public void changeNotification(NOTIF notif) {
        MobileElement buttonNotif=(MobileElement) driver.findElement(notification);
        switch (notif){
            case OFF:{
                if (buttonNotif.getAttribute("checked").equals("true")){
                    buttonNotif.click();
                }
            }
            break;
            case ON:{
                if (buttonNotif.getAttribute("checked").equals("false")){
                    buttonNotif.click();
                }
            }
            break;
       }
   }

   public void changeStatusBar (StBar status){
        MobileElement buttonStatus= (MobileElement) driver.findElement(statusBar);
        switch (status){
            case Yes:{
                if (buttonStatus.getAttribute("checked").equals("false")){
                    buttonStatus.click();
                }
            }
            break;
            case NO:{
                if (buttonStatus.getAttribute("checked").equals("true")){
                    buttonStatus.click();
                }
            }
            break;
        }

   }

            public void changeTemp ( char temp){
                MobileElement element = (MobileElement) driver.findElement(tempID);
                switch (temp) {
                    case 'f': {
                        if (element.getAttribute("checked").equals("false")) {// false=cel
                            element.click();
                        }
                    }
                    break;
                    case 'c': {
                        if (element.getAttribute("checked").equals("true")) {// true=cel
                            element.click();
                        }
                    }
                    break;
                }
            }

            public void changeSpeed (SPEED speed){
                if (!driver.findElement(speedFormat).getText().equals(speed.speed)) {
                    driver.findElement(speedD).click();
                    MobileElement button = (MobileElement) new WebDriverWait(driver, 10)
                            .until(ExpectedConditions.presenceOfElementLocated(By.id("com.weather.forecast.weatherchannel:id/md_contentRecyclerView")));
                    List<MobileElement> list = button.findElements(By.className("android.widget.LinearLayout"));
                    for (MobileElement l : list) {

                        if (l.findElement(By.className("android.widget.TextView")).getText().equals(speed.speed)) {
                            l.click();
                            break;
                        }
                    }
                }
            }

            public enum SPEED {
                METRES("m/s"),
                KILOMETRES("");
                String speed;

                SPEED(String speed) {
                    this.speed = speed;
                }
            }

            public enum TIME {
                USA("12"),
                UK("24");
                String time;
                TIME(String time) {
                    this.time = time;
                }
            }

            public enum NOTIF {
                ON("true"),
                OFF("false");
                String notif;
                NOTIF(String notif) {
                    this.notif = notif;
                }
            }

            public enum StBar{
            Yes ("true"),
            NO ("false");
            String status;
            StBar(String status){this.status=status;}
            }



    }















