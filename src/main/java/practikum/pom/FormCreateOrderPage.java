package practikum.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FormCreateOrderPage {
    private WebDriver webDriver;

    // поле "Имя"
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // поле "Фамилия"
    private final By inputSecondName = By.xpath(".//input[@placeholder='* Фамилия']");
    // поле "Адрес"
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // поле "Станция метро"
    private final By inputMetro = By.xpath(".//input[@class='select-search__input' and @placeholder='* Станция метро']");
    private final By selectSearchMetro = By.xpath(".//div[@class='select-search__value']");
    // Список станции метро
    private final By listMetro = By.xpath(".//button[contains(@class,'Order_SelectOption')]");
    // поле "Телефон"
    private final By inputPhone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // поле "Когда привезти самокат"
    private final By inputWhenGiveScooter = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // выбор даты поле "Когда привезти самокат"
    private final By datePickerWhen = By.xpath(".//div[@class='react-datepicker']");
    // поле "Срок аренды"
    private final By inputPeriodRental = By.xpath(".//div[@class='Dropdown-placeholder']");
    // Выпадающий список "Срок аренды"
    private final By listPeriodRental = By.xpath(".//div[@class='Dropdown-option']");


    // Цвет самоката
    private final By checkboxColorScooter = By.xpath(".//input[contains(@class,'Checkbox_Input') and @type='checkbox']");
    // поле "Комментарий"
    private final By inputComment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Далее"
    private final By buttonNext = By.xpath(".//button[contains(@class,'Button_Button') and text()='Далее']");
    // Кнопка "Заказать"
    private final By buttonToOrder = By.xpath(".//button[contains(@class,'Button_Middle') and text()='Заказать']");
    // Кнопка "Да" в модальном окне оформления заказа
    private final By buttonYesCreateOrder = By.xpath(".//button[contains(@class,'Button_Button') and text()='Да']");
    // Текст "Заказ оформлен"
    private final By textSuccessCreateOrder = By.xpath(".//div[contains(@class,'Order_ModalHeader') and text()='Заказ оформлен']");

    public FormCreateOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // заполнение формы заказа
    public void createOrder(String name, String secondName, String address, int indexStationMetro, String phone, String dateWhenGiveScooter, String howManyPeriodRental,int indexColorScooter, String commet) {
        sendInputName(name);
        sendInputSecondName(secondName);
        sendInputAddress(address);
        clickListStationMetro(indexStationMetro);
        sendInputPhone(phone);
        clickButtonNext();
        sendWhenGiveScooter(dateWhenGiveScooter);
        clickListPeriodRental(howManyPeriodRental);
        clickCheckboxColorScooter(indexColorScooter);
        sendCommet(commet);
        clickButtonToOrder();
        clickButtonYesCreateOrder();
    }


    // ввод поля "Имя"
    public void sendInputName(String name) {
        webDriver.findElement(inputName).sendKeys(name);

    }

    // ввод поля "Фамилия"
    public void sendInputSecondName(String secondName) {
        webDriver.findElement(inputSecondName).sendKeys(secondName);

    }

    // ввод поля "Адрес"
    public void sendInputAddress(String address) {
        webDriver.findElement(inputAddress).sendKeys(address);

    }

    // Выбор станции метро из списка
    public void clickListStationMetro(int indexStationMetro) {
        // нажатие с ожиданием на поле "Станция метро"
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(inputMetro)).click();
        // ожидание списка с метро
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(
                listMetro
        ));
        By stationMetro = By.xpath(".//button[@value='" + indexStationMetro + "']");
        // скролл до станции метро в списке
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(stationMetro));
        // нажатие с ожиданием на станцию метро из списка
        new WebDriverWait(webDriver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(stationMetro)).click();

    }

    // ввод поля "Адрес"
    public void sendInputPhone(String phone) {
        webDriver.findElement(inputPhone).sendKeys(phone);

    }

    // Нажатие кнопки "Далее"
    public void clickButtonNext() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(buttonNext));
    }

    // ввод поля "Когда привезти самокат"
    public void sendWhenGiveScooter(String dateWhenGiveScooter) {
        webDriver.findElement(inputWhenGiveScooter).sendKeys(dateWhenGiveScooter);
        // удаление элемента выбор даты
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].remove();", webDriver.findElement(datePickerWhen));
    }

    // Нажатие из списка "Срок аренды"
    public void clickListPeriodRental(String howManyPeriodRental) {
        // нажатие с ожиданием на поле "Срок аренды"
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(inputPeriodRental)).click();
        // ожидание списка
        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(
                listPeriodRental
        ));
        By periodRental = By.xpath(".//div[@class='Dropdown-option' and text()='" + howManyPeriodRental + "']");
        // скролл до элемента списка срока аренды
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", webDriver.findElement(periodRental));
        // нажатие с ожиданием срок аренды  из списка
        new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(periodRental)).click();

    }
    // Нажатие на checkbox "Цвет самоката"
    public void clickCheckboxColorScooter( int indexColorScooter){
        List<WebElement> elements = webDriver.findElements(checkboxColorScooter);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", elements.get(indexColorScooter));

    }
    // ввод поля "Комментарий"
    public void sendCommet(String commet) {
        webDriver.findElement(inputComment).sendKeys(commet);

    }

    // Нажатие  кнопку "Заказать"
    public void clickButtonToOrder() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(buttonToOrder));
    }

    // Нажатие  кнопку "Да"
    public void clickButtonYesCreateOrder() {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].click();", webDriver.findElement(buttonYesCreateOrder));
    }

    public String getTextSuccessCreateOrder() {
        return webDriver.findElement(textSuccessCreateOrder).getText();
    }



}

