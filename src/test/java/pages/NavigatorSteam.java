package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigatorSteam extends BasePage {
    private static final String GENRE_TAB_LOC = "#genre_tab";
    private static final String STORE_AREA_LOC = "#store_nav_area";

    public NavigatorSteam(WebDriver webDriver) {
        super(webDriver);
    }

    public void checkStoreArea() {
        WebDriverWait storeAreaWait = new WebDriverWait(webDriver, 10, 300);
        WebElement storeArea = webDriver.findElement(By.cssSelector(STORE_AREA_LOC));
        storeAreaWait.until(ExpectedConditions.visibilityOf(storeArea));

    }

    public void clickCategories() {
        WebDriverWait categoriesElementWait = new WebDriverWait(webDriver, 10, 300);
        WebElement categoriesElement = webDriver.findElement(By.cssSelector(GENRE_TAB_LOC));
        categoriesElementWait.until(ExpectedConditions.visibilityOf(categoriesElement));
        categoriesElement.click();
    }

}
