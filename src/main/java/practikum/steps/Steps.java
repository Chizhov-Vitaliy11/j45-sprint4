package practikum.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.lang.model.util.Elements;
import javax.swing.text.Element;
import java.time.Duration;
import java.util.List;

public class Steps {
    private final WebDriver webDriver;


    public Steps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openSait(String url) {
        webDriver.get(url);

    }

    public void click(By element) {
//        new WebDriverWait(webDriver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.visibilityOfElementLocated(element)).click();
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(element));

    }

    public void waitAndClick(By element, int second) {
        new WebDriverWait(webDriver, Duration.ofSeconds(second))
                .until(ExpectedConditions.visibilityOfElementLocated(element)).click();
    }

    public void wait(By element, int second) {
        new WebDriverWait(webDriver, Duration.ofSeconds(second)).until(ExpectedConditions.visibilityOfElementLocated(
                element
        ));
    }

    public void deleteElement(By element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].remove();", webDriver.findElement(element));
    }

    public void sendKey(By element, String text, String attribute) {
        webDriver.findElement(element).sendKeys(text);

    }

    public void scroll(By element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(element));

    }

    public String getText(By element) {
        return webDriver.findElement(element).getText();
    }

    public List<WebElement> elementFromTheList(By elements) {
        return webDriver.findElements(elements);
    }

}
