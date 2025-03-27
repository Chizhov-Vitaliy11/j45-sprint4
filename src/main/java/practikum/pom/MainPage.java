package practikum.pom;

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

public class MainPage {

    private final WebDriver webDriver;
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By buttonsToOrder = By.xpath(".//button[contains(@class,'Button_Button') and text()='Заказать']");
    private final By buttonsToOrderHeader = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final By buttonsToOrderMidle = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public MainPage openSait() {
        webDriver.get(url);
        return this;
    }

    // Поиск и нажатие кнопки "Вопросы о важном"
    public MainPage clickItemHeadings(int indexHeading) {
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__heading-" + indexHeading + "']"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", element);
        return this;
    }


    // Получить текст в выпадающем списке  "Вопросы о важном"
    public String getTextItemPanels(int indexPanels) {
        WebElement element = webDriver.findElement(By.xpath(".//div[@id='accordion__panel-" + indexPanels + "']"));
        return element.getText();
    }

    //Нажатие верхней кнопки "Заказать"
    public MainPage clickButtonToOrder(int indexButton) {
        List<WebElement> elements = webDriver.findElements(buttonsToOrder);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", elements.get(indexButton));
        return this;
    }
}