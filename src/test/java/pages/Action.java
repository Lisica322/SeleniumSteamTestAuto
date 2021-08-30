package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action extends BasePage {
    private static final String ACTION_GENRE_GROUP = "//*[@data-genre-group ='action'][@class='popup_menu_subheader popup_genre_expand_header responsive_hidden']";

    private static final String PAGE_HEADER_LOC = "//*[@class='pageheader']";

    public Action(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickAction() {
        WebDriverWait actionGenreGroupWait = new WebDriverWait(webDriver, 10, 300);
        WebElement actionGenreGroup = webDriver.findElement(By.xpath(ACTION_GENRE_GROUP));
        actionGenreGroupWait.until(ExpectedConditions.visibilityOf(actionGenreGroup));
        actionGenreGroup.click();
    }

    public void containsAction() {
        WebDriverWait actionPageHeaderWait = new WebDriverWait(webDriver, 10, 300);
        WebElement actualPageHeader = webDriver.findElement(By.xpath(PAGE_HEADER_LOC));
        actionPageHeaderWait.until(ExpectedConditions.visibilityOf(actualPageHeader));
        String actualPageHeaderText = actualPageHeader.getText();
        Assertions.assertEquals("Browsing Action", actualPageHeaderText.trim(), "Не совпадает название раздела с заголовком!");
    }
}
