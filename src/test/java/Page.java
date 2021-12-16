import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public abstract class Page
{
    protected MyDriver driver;
    
    public Page (MyDriver driver)
    {
        this.driver = driver;
    }

    public void swipe(Integer startX, Integer startY,
            Integer finalX, Integer finalY)
    {
        driver.swipe(startX, startY, finalX, finalY);
    }

    public abstract boolean atPage();
}
