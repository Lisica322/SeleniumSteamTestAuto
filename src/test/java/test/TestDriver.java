package test;


import org.junit.jupiter.api.Test;
import pages.*;

public class TestDriver extends BaseTest {


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


}
