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

public class MainPage {



    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final By itemHeadings = By.xpath(".//div[contains(@id,'accordion__heading')]"); // Заголовки
    private final By itemPanels = By.xpath(".//div[contains(@id,'accordion__panel')]"); // Содержание
    private final By buttonsToOrder = By.xpath(".//button[contains(@class,'Button_Button') and text()='Заказать']");


    public String getUrl() {
        return url;
    }


    // Получить локатор заголовков
    public By getItemHeadings() {
        return itemHeadings;
    }


    // Получить локатор панелей
    public By getItemPanels() {
        return itemPanels;
    }

    public By getButtonsToOrder() {
        return buttonsToOrder;
    }
}