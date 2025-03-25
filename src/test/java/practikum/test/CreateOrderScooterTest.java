package practikum.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import practikum.pom.FormCreateOrderPage;
import practikum.pom.MainPage;
import practikum.rules.BrowserRule;
import practikum.steps.Steps;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CreateOrderScooterTest {
    @Parameterized.Parameter
    public String name;
    @Parameterized.Parameter(1)
    public String secondName;
    @Parameterized.Parameter(2)
    public String address;
    @Parameterized.Parameter(3)
    public int indexStationMetro;
    @Parameterized.Parameter(4)
    public String phone;
    @Parameterized.Parameter(5)
    public String when;
    @Parameterized.Parameter(6)
    public int indexPeriodRental;
    @Parameterized.Parameter(7)
    public int indexColorScooter;
    @Parameterized.Parameter(8)
    public String comment;
    @Parameterized.Parameter(9)
    public int indexButtonOrder;

    @Rule
    public final BrowserRule browserRule = new BrowserRule();


    @Parameterized.Parameters
    public static Object[] getTextImportantQuestions() {
        return new Object[][]{
                {"Иван","Иванов","",20,"799999999999","23.03.2025",2,1,"Комментарий",0},
                {"Петр","Сидоров","ул.Пушкина",35,"799999999999","27.03.2025",1,0,"Комментарий",1},
                {"Анастасия","Васнецова","",45,"799999999999","25.03.2025",0,1,"Комментарий",0},


        };
    }

    @Test
    public void checkModalWindowSuccessCreateOrder() {

        Steps steps = new Steps(browserRule.getWebDriver());
        MainPage mainPage = new MainPage();
        steps.openSait(mainPage.getUrl());
        List<WebElement> buttonsOrder = steps.elementFromTheList(mainPage.getButtonsToOrder());
        //Нажать на кнопку "Заказать"
        steps.click(By.xpath(".//button[@class ='"+buttonsOrder.get(indexButtonOrder).getAttribute("class")+"']"));
        FormCreateOrderPage formCreateOrderPage = new FormCreateOrderPage();
        //Ожидание поле Фамилия
        steps.wait(formCreateOrderPage.getInputSecondName(), 5);
        //Ввод поля Имя
        steps.sendKey(formCreateOrderPage.getInputName(), ""+name+"", "value");
        //Ввод поля Фамилия
        steps.sendKey(formCreateOrderPage.getInputSecondName(), ""+secondName+"", "value");

        //Ввод поля Адрес
        steps.sendKey(formCreateOrderPage.getInputAddress(), ""+address+"", "value");

        //Нажатие на поле "Станция метро"
        steps.waitAndClick(formCreateOrderPage.getInputMetro(), 30);


        //steps.sendKey(formCreateOrderPage.getInputMetro(), "Севастопольская", "value");


        //Ожидание появления полного списка
        steps.wait(formCreateOrderPage.getListMetro(), 30);

      ///  listMetro.get(0).findElement(By.xpath(".//div[contains(@class,'Order_Text') and text()='"++"' ]"));

        // Скролл списка поля "Станция метро"
        steps.scroll(By.xpath(".//button[@value='"+indexStationMetro+"']"));



        // нажатие на станцию из списка поля "Станция метро"
        steps.waitAndClick(By.xpath(".//button[@value='"+indexStationMetro+"']"), 30);

        // Ввод поля Номер телефона
        steps.sendKey(formCreateOrderPage.getInputPhone(), ""+phone+"", "value");

        // Нажатие на кнопку "Далее"
        steps.click(formCreateOrderPage.getButtonNext());
        // ожидание поля "Когда привезти самокат"
        steps.wait(formCreateOrderPage.getInputWhen(), 10);
        // Ввод поля "Когда привезти самокат"
        steps.sendKey(formCreateOrderPage.getInputWhen(), ""+when+"", "value");
        // удаление элемента DatePicker поля "Когда привезти самокат"
        steps.deleteElement(formCreateOrderPage.getDatePickerWhen());


       // Нажатие на кнопку "Срок Аренды"
        steps.waitAndClick(formCreateOrderPage.getInputPeriodRental(), 30);
        // Ожидание списка поля "Срок Аренды"
        steps.wait(formCreateOrderPage.getListPeriodRental(), 10);
        List<WebElement> listPeriodRental = steps.elementFromTheList(formCreateOrderPage.getListPeriodRental());
        // скролл списка поля "Срок Аренды"
        steps.scroll(By.xpath(".//div[@class='Dropdown-option'and text()='" + listPeriodRental.get(indexPeriodRental).getText() + "']"));
        // нажатие из  списка поля "Срок Аренды"
        steps.waitAndClick(By.xpath(".//div[@class='Dropdown-option'and text()='" + listPeriodRental.get(indexPeriodRental).getText() + "']"), 30);

        List<WebElement> listCheckboxColorScooter = steps.elementFromTheList(formCreateOrderPage.getCheckboxColorScooter());
        // нажатие из  списка поля "Срок Аренды"
        steps.click(By.xpath(".//input[@id='" + listCheckboxColorScooter.get(indexColorScooter).getAttribute("id") + "']"));
        // Ввод поля "Комментарий"
        steps.sendKey(formCreateOrderPage.getInputComment(), "Комментарий", "value");
        System.out.println(formCreateOrderPage.getButtonToOrder());
        // Нажатие на кнопку "Заказать"
        steps.click(formCreateOrderPage.getButtonToOrder());
        // ожидание кнопки "Да"
        steps.wait(formCreateOrderPage.getButtonCreateOrder(), 10);
        // Нажатие на кнопку "Заказать"
        steps.click(formCreateOrderPage.getButtonCreateOrder());
        // ожидание текста "Заказ оформлен"
        steps.wait(formCreateOrderPage.getTextSuccessCreateOrder(), 10);
        // Проверка
        assertEquals("Что-то пошло не так", "Заказ оформлен", steps.getText(formCreateOrderPage.getTextSuccessCreateOrder()));


    }


}