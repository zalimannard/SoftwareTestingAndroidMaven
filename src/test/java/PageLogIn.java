import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageLogIn extends Page
{
    public PageLogIn(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.vkontakte.android:id/login_button")
    private MobileElement loginButton;

    @AndroidFindBy(id = "com.vkontakte.android:id/continue_btn")
    private MobileElement continueButton;

    @AndroidFindBy(id = "com.vkontakte.android:id/email_or_phone")
    private MobileElement login;

    @AndroidFindBy(id = "com.vkontakte.android:id/vk_password")
    private MobileElement password;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup")
    private MobileElement backgroundLogin;


    public void clickLoginButton()
    {
        driver.clickTo(loginButton);
    }

    public void clickContinue()
    {
        driver.clickTo(continueButton);
    }

    public void sendLogin(String text)
    {
        driver.sendText(login, text);
    }

    public void sendPassword(String text)
    {
        driver.sendText(password, text);
    }

    public boolean atPage()
    {
        return driver.exist(backgroundLogin);
    }
}
