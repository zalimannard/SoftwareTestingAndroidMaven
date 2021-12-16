import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageFooter extends Page
{
    public PageFooter(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Главная")
    private MobileElement mainPage;

    @AndroidFindBy(accessibility = "Мессенджер")
    private MobileElement messenger;
    
    @AndroidFindBy(accessibility = "Открыть меню")
    private MobileElement leftMenu;

    @AndroidFindBy(id = "com.vkontakte.android:id/bottom_navigation")
    private MobileElement bottomPanel;

    public void clickMainPage()
    {
        driver.clickTo(mainPage);
    }

    public void clickMessagePage()
    {
        driver.clickTo(messenger);
    }

    public void clickLeftMenuPage()
    {
        driver.clickTo(leftMenu);
    }

    public boolean atPage()
    {
        return driver.exist(bottomPanel);
    }
}
