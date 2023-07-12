package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SettingPage {
    By tempID = By.id("com.weather.forecast.weatherchannel:id/tgTemperature_setting");
    By titleSpeed = By.id("com.weather.forecast.weatherchannel:id/md_title");
    By speedD = By.id("com.weather.forecast.weatherchannel:id/iv_arrow_distance");
    By speedFormat = By.id("com.weather.forecast.weatherchannel:id/tv_wind_speed_format");

    public SettingPage(AndroidDriver driver) {
        this.driver = driver;
    }

    private static AndroidDriver driver;

    public void changeTemp(char temp) {
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

    public void changeSpeed(SPEED speed) {
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
}
