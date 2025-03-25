package practikum.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BrowserRule extends ExternalResource {
    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected void before() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage","--headless");
        webDriver = new ChromeDriver(options);

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    protected void after() {
        webDriver.quit();
    }
}
