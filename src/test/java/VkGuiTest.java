import static org.junit.Assert.assertTrue;

import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

public class VkGuiTest
{
    private DesiredCapabilities capabilities;
    private MyDriver driver = null;
    private User user = null;
    
    private PageFooter pageFooter;
    private PageLeftMenu pageLeftMenu;
    private PageLogIn pageLogIn;
    private PageLogOut pageLogOut;
    private PageMain pageMain;
    private PageMessage pageMessage;
    private PageSettings pageSettings;
    private PageChat pageChat;

    @Before
    public void setUp()
    {
        switch (Configuration.PLATFORM)
        {
            case ANDROID:
                setAndroidCapabilities(
                        ConfigProperties.getProperty("mobileConfig"));
                break;
            case IOS:
                // setIosCapabilities();
                break;
            case ANY:
                setAndroidCapabilities(
                        ConfigProperties.getProperty("browserstackConfig"));
            default:
                throw new RuntimeException("Incorrect platform");
        }

        pageFooter = new PageFooter(driver);
        pageLeftMenu = new PageLeftMenu(driver);
        pageLogIn = new PageLogIn(driver);
        pageLogOut = new PageLogOut(driver);
        pageMain = new PageMain(driver);
        pageMessage = new PageMessage(driver);
        pageSettings = new PageSettings(driver);
        pageChat = new PageChat(driver);

        user = new User(ConfigProperties.getProperty("vkLogin"),
                ConfigProperties.getProperty("vkPassword"));

        /* driver.resetApp(); */
        /* driver.manage().deleteAllCookies(); */
    }

    private void setAndroidCapabilities(String path) throws JSONException
    {
        this.capabilities = new DesiredCapabilities();
        JSONObject appiumJson = JsonService.readFromJsonFile(
                this.getClass().getClassLoader().getResource(path).getPath());
        JSONObject capabilities = JsonService.getCapabilities(appiumJson);
        capabilities.keySet().forEach(
                keyStr -> this.capabilities.setCapability(
                    keyStr, capabilities.get(keyStr)));
        try
        {
            this.driver = new MyDriver(
                    new URL(JsonService.getUrl(appiumJson)),
                    this.capabilities);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        /* driver.installApp("/run/media/zalimannard/Files/Online/Course3/Semester1/SoftwareTesting/AndroidMaven/com.vkontakte.android.apk"); */
    }
    
    @Test
    public void sendFile()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickMessagePage();

        pageMessage.clickSearch();
        pageMessage.clickFavourites();

        pageChat.clickAttach();
        pageChat.clickAllowAccess();
        pageChat.clickAllowFileAccess();
        pageChat.clickToFirstPhotoCheck();
        pageChat.clickAddPhotos();
        pageChat.clickSendMessage();
        assertTrue(pageChat.atPage());
    }

    @Test
    public void deleteMessage()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickMessagePage();

        pageMessage.clickSearch();
        pageMessage.clickFavourites();

        pageChat.sendMessageText("Тест проверка");
        pageChat.clickSendMessage();
        pageChat.clickLastMessage();
        pageChat.clickDeleteMessage();
        pageChat.clickConfirmDeleteMessage();
        assertTrue(pageChat.atPage());
    }

    @Test
    public void doNotDisturb()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickLeftMenuPage();

        pageLeftMenu.clickSettings();

        pageSettings.clickDoNotDisturbOn();
        pageSettings.clickDoNotDisturbOneHour();
        assertTrue(pageSettings.isDoNotDisturbOff());
    }

    /* @Test */
    public void openNews()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickMainPage();
        
        pageMain.clickCategoriesComboBox();
        pageMain.clickNewsInComboBox();

        assertTrue(pageMain.atPage());
    }

    /* @Test */
    public void openAndScrollMessenger()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickMessagePage();
        assertTrue(pageMessage.atPage());

        pageMessage.swipe(400, 400, 400, 100);
        pageMessage.swipe(400, 100, 400, 400);

        assertTrue(pageMessage.atPage());
    }

    /* @Test */
    public void changeTheme()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickLeftMenuPage();

        pageLeftMenu.clickChangeTheme();
        pageLeftMenu.clickChangeTheme();
        assertTrue(pageLeftMenu.atPage());
    }

    /* @Test */
    public void logOut()
    {
        pageLogIn.clickLoginButton();
        pageLogIn.sendLogin(user.getLogin());
        pageLogIn.sendPassword(user.getPassword());
        pageLogIn.clickContinue();

        pageFooter.clickLeftMenuPage();

        pageLeftMenu.clickSettings();
        assertTrue(pageSettings.atPage());

        pageSettings.swipe(400, 400, 400, 100);
        pageSettings.swipe(400, 400, 400, 100);
        pageSettings.swipe(400, 400, 400, 100);

        pageSettings.clickLogOut();
        pageSettings.clickLogOutConfirm();

        assertTrue(pageLogOut.atPage());
    }

    @After
    public void tearDown()
    {
        if (this.driver != null)
        {
            driver.quit();
        }
    }
}
