package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FirstGame extends BasePage {
    private static final String FIRST_PAGE_LOC = "//*[@id='genre_large_cluster']/div[2]/div[1]";
    private static final String FIRST_PRICE_LOC = "//div[@class='discount_block  no_discount']/*/*";
    private static final String FIRST_GAME_LOC = "//div[@class='main']//div[@class='bg']";
    private static final String FIRST_GAME_PRICE_LOC = "//div[@class='game_purchase_action']//div[@class='game_purchase_price price']";

    public void clickFirstPageMenu() {
        WebDriverWait clickFirstPageWait = new WebDriverWait(webDriver, 10, 300);
        WebElement FirstPageMenu = webDriver.findElement(By.xpath(FIRST_PAGE_LOC));
        clickFirstPageWait.until(ExpectedConditions.visibilityOf(FirstPageMenu));
        FirstPageMenu.click();
    }

    public void clickFirstGamePage() {
        WebDriverWait clickFirstGamePageWait = new WebDriverWait(webDriver, 10, 300);
        List<WebElement> firstGamePageMenu = webDriver.findElements(By.xpath(FIRST_GAME_LOC));

        WebElement firstGamePageMenuElementPrice =
                firstGamePageMenu
                        .stream()
                        .findFirst()
                        .orElseThrow(() -> new AssertionError("Пустой список игр"));

        clickFirstGamePageWait.until(ExpectedConditions.visibilityOf(firstGamePageMenuElementPrice));
        firstGamePageMenuElementPrice.click();
    }

    public String containsGameFirst() {
        WebDriverWait actionPageHeaderWait = new WebDriverWait(webDriver, 10, 300);
        WebElement finalePriceMainPage = webDriver.findElement(By.xpath(FIRST_GAME_PRICE_LOC));
        actionPageHeaderWait.until(ExpectedConditions.visibilityOf(finalePriceMainPage));
        return finalePriceMainPage.getText();
    }

    public void containsAction() {
        WebDriverWait actionPageHeaderWait = new WebDriverWait(webDriver, 10, 300);
        List<WebElement> finalePriceMainPage = webDriver.findElements(By.xpath(FIRST_PRICE_LOC));
        WebElement finalePrice = null;
        for (int i = 0; i < finalePriceMainPage.size(); i++) {
            finalePrice = finalePriceMainPage.get(0);
        }
        actionPageHeaderWait.until(ExpectedConditions.visibilityOf(finalePrice));

        assert finalePrice != null;
        String actualPageHeaderText = finalePrice.getText();

        Assertions.assertEquals(containsGameFirst(), actualPageHeaderText.trim(), "Не совпадает цена в разделе с ценой на старнице игры!");
    }


    public FirstGame(WebDriver webDriver) {
        super(webDriver);
    }


}
