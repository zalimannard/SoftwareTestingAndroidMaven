import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageMain extends Page
{
    public PageMain(MyDriver driver)
    {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy (id = "com.vkontakte.android:id/title")
    private MobileElement mainTextElement;

    @AndroidFindBy (accessibility = "Новости")
    private MobileElement categoriesComboBox;

    @AndroidFindBy (xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]")
    private MobileElement newsInComboBox;


    public void clickCategoriesComboBox()
    {
        driver.clickTo(categoriesComboBox);
    }

    public void clickNewsInComboBox()
    {
        driver.clickTo(newsInComboBox);
    }

    public boolean atPage()
    {
        return driver.exist(mainTextElement);
    }
}
