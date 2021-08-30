package test;

import consts.SteamsURL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(SteamsURL.BASE_URL.getBaseUrl());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
