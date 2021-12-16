import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageSettings extends Page
{
    public PageSettings(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Не беспокоить']")
    private MobileElement doNotDisturbOn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
    private MobileElement doNotDisturbOneHour;

    @AndroidFindBy(id = "com.vkontakte.android:id/logout")
    private MobileElement logOut;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement logoutConfirm;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView")
    private MobileElement backgroundSettings;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Включить уведомления']")
    private MobileElement doNotDisturbOff;

    public void clickDoNotDisturbOn()
    {
        driver.clickTo(doNotDisturbOn);
    }

    public boolean isDoNotDisturbOff()
    {
        return driver.exist(doNotDisturbOff);
    }

    public void clickDoNotDisturbOneHour()
    {
        driver.clickTo(doNotDisturbOneHour);
    }

    public void clickLogOut()
    {
        driver.clickTo(logOut);
    }

    public void clickLogOutConfirm()
    {
        driver.clickTo(logoutConfirm);
    }

    public boolean atPage()
    {
        return driver.exist(backgroundSettings);
    }
}
