package practikum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practikum.pom.FormCreateOrderPage;
import practikum.pom.MainPage;
import practikum.rules.BrowserRule;


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
    public String dateWhenGiveScooter;
    @Parameterized.Parameter(6)
    public String howManyPeriodRental;
    @Parameterized.Parameter(7)
    public int indexColorScooter;
    @Parameterized.Parameter(8)
    public String comment;
    @Parameterized.Parameter(9)
    public int indexButtonOrder;
    private MainPage mainPage;

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Before
    public void before() {
        this.mainPage = new MainPage(browserRule.getWebDriver());
    }

    @Parameterized.Parameters
    public static Object[] getTextImportantQuestions() {
        return new Object[][]{
                {"Иван", "Иванов", "", 20, "799999999999", "23.03.2025", "сутки", 1, "Комментарий", 0},
                {"Петр", "Сидоров", "ул.Пушкина", 35, "799999999999", "27.03.2025", "двое суток", 0, "Комментарий", 1},
                {"Анастасия", "Васнецова", "", 45, "799999999999", "25.03.2025", "пятеро суток", 1, "Комментарий", 0},


        };
    }

    @Test
    public void checkModalWindowSuccessCreateOrder() {

        mainPage.openSait()
        .clickButtonToOrder(indexButtonOrder);




        FormCreateOrderPage formCreateOrderPage = new FormCreateOrderPage(browserRule.getWebDriver());
        formCreateOrderPage.createOrder(name,secondName,address,indexStationMetro,phone,dateWhenGiveScooter,howManyPeriodRental,indexColorScooter,comment);
        // Проверка
        assertEquals("Что-то пошло не так", "Заказ оформлен", formCreateOrderPage.getTextSuccessCreateOrder());


    }


}