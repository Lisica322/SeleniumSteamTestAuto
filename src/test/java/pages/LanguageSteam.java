package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class LanguageSteam extends BasePage {
    private static final String PAGE_HEADER_LOC = "//*[@id = 'language_pulldown']";
    private static final String ENGLISH_LANGUAGE_LOC = "//*[@class='popup_menu_item tight'][contains(text(),'English')]";

    public void checkTheLanguage() {
        Set<Cookie> cookies = webDriver.manage().getCookies();
        for (Cookie contText : cookies) {
            if (contText.getValue().startsWith("RU")) {
                clickLanguageMenu();
                clickLanguageEnglish();
            }
        }
    }

    public LanguageSteam(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickLanguageMenu() {
        WebDriverWait clickLanguageWait = new WebDriverWait(webDriver, 10, 300);
        WebElement languagePageHeader = webDriver.findElement(By.xpath(PAGE_HEADER_LOC));
        clickLanguageWait.until(ExpectedConditions.visibilityOf(languagePageHeader));
        languagePageHeader.click();
    }

    public void clickLanguageEnglish() {
        WebDriverWait clickLanguageEnglishWait = new WebDriverWait(webDriver, 10, 300);
        WebElement EnglishLanguage = webDriver.findElement(By.xpath(ENGLISH_LANGUAGE_LOC));
        clickLanguageEnglishWait.until(ExpectedConditions.visibilityOf(EnglishLanguage));
        EnglishLanguage.click();
    }
}