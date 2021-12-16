import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class MyDriver extends AndroidDriver
{
    public MyDriver(URL url, DesiredCapabilities capabilities)
    {
        super(url, capabilities);
    }

    public WebElement find(MobileElement element)
    {
        return new WebDriverWait(this, Configuration.TIMEOUTS).until(
                ExpectedConditions.elementToBeClickable(element));
    }
    
    public void clickTo(MobileElement element)
    {
        find(element).click();
    }

    public void sendText(MobileElement element, String text)
    {
        find(element).sendKeys(text);
    }

    public void swipe(Integer fromX, Integer fromY,
            Integer toX, Integer toY)
    {
        (new TouchAction(this))
            .press(new PointOption().withCoordinates(fromX, fromY))
            .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
            .moveTo(new PointOption().withCoordinates(toX, toY))
            .release()
            .perform();
    }

    public boolean exist(MobileElement element)
    {
        return find(element) != null;
    }
}
