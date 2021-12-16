import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLeftMenu extends Page
{
    public PageLeftMenu(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Настройки")
    private MobileElement settings;

    @AndroidFindBy(accessibility = "Переключить тему")
    private MobileElement changeTheme;

    @AndroidFindBy(id = "com.vkontakte.android:id/scroll_container")
    private MobileElement leftMenuContainer;


    public void clickSettings()
    {
        driver.clickTo(settings);
    }

    public void clickChangeTheme()
    {
        driver.clickTo(changeTheme);
    }

    public boolean atPage()
    {
        return driver.exist(leftMenuContainer);
    }
}
