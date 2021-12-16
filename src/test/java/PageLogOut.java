import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLogOut extends Page
{
    public PageLogOut(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.vkontakte.android:id/use_another_account")
    private MobileElement logInOtherAccount;

    public boolean atPage()
    {
        return driver.exist(logInOtherAccount);
    }
}
