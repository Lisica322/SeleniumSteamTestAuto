package test;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class TestDriver {


    protected WebDriver webDriver;
    private static final String AUTOMATION_STEAM_URL = "https://store.steampowered.com/";

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(AUTOMATION_STEAM_URL);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @Test
    public void theSteamTesting() {
        NavigatorSteam navigatorSteam = new NavigatorSteam(webDriver);
        CategorySteamPage categorySteamPage = new CategorySteamPage(webDriver);
        Action action = new Action(webDriver);
        LanguageSteam languageSteam = new LanguageSteam(webDriver);
        FirstGame firstGame = new FirstGame(webDriver);

        languageSteam.checkTheLanguage();
        languageSteam.clickLanguageMenu();
        languageSteam.clickLanguageEnglish();
        navigatorSteam.checkStoreArea();
        navigatorSteam.clickCategories();
        categorySteamPage.waitUntilPageMenuVisible();
        action.clickAction();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        action.containsAction();
        firstGame.clickFirstPageMenu();
        firstGame.clickFirstGamePage();
        firstGame.containsAction();
    }


    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
