package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CategorySteamPage extends BasePage {
    private static final String PAGE_MENU_LOC = "//*[@class = 'popup_body popup_menu_twocol_new']";

    public CategorySteamPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void waitUntilPageMenuVisible() {
        WebDriverWait pageMenuWait = new WebDriverWait(webDriver, 10, 300);
        WebElement pageMenu = webDriver.findElement(By.xpath(PAGE_MENU_LOC));
        pageMenuWait.until(ExpectedConditions.visibilityOf(pageMenu));
    }
}
