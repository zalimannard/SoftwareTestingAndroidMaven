import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageChat extends Page
{
    public PageChat(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "Прикрепить вложение")
    private MobileElement attach;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement allowAccess;

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement allowFileAccess;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.ImageView")
    private MobileElement firstPhotoCheck;

    @AndroidFindBy(id = "com.vkontakte.android:id/fl_bottom_button")
    private MobileElement addPhotos;

    @AndroidFindBy(accessibility = "Отправить")
    private MobileElement sendMessage;

    @AndroidFindBy(id = "com.vkontakte.android:id/writebar_edit")
    private MobileElement messageText;

    @AndroidFindBy(accessibility = "Дима Колесников. Тест проверка. Сообщение прочитано")
    private MobileElement lastMessage;

    @AndroidFindBy(accessibility = "Удалить")
    private MobileElement deleteMessage;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement confirmDelete;


    public void clickAttach()
    {
        driver.clickTo(attach);
    }

    public void clickAllowAccess()
    {
        driver.clickTo(allowAccess);
    }

    public void clickAllowFileAccess()
    {
        driver.clickTo(allowFileAccess);
    }

    public void clickToFirstPhotoCheck()
    {
        driver.clickTo(firstPhotoCheck);
    }

    public void clickAddPhotos()
    {
        driver.clickTo(addPhotos);
    }

    public void clickSendMessage()
    {
        driver.clickTo(sendMessage);
    }

    public void sendMessageText(String text)
    {
        driver.sendText(messageText, text);
    }

    public void clickLastMessage()
    {
        driver.clickTo(lastMessage);
    }

    public void clickDeleteMessage()
    {
        driver.clickTo(deleteMessage);
    }

    public void clickConfirmDeleteMessage()
    {
        driver.clickTo(confirmDelete);
    }

    public boolean atPage()
    {
        return driver.exist(attach);
    }
}
