package practikum.test;

import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import practikum.pom.MainPage;
import practikum.rules.BrowserRule;
import practikum.steps.Steps;

import javax.swing.text.Element;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ListImportantQuestionsTest {

    private final String textAnswer;
    private final int indexQuestion;
    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    public ListImportantQuestionsTest(int indexQuestion, String textAnswer) {
        this.indexQuestion=indexQuestion;
        this.textAnswer=textAnswer;
    }

    @Parameterized.Parameters
    public static Object[] getTextImportantQuestions() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void checkList() {


        Steps steps = new Steps(browserRule.getWebDriver());
        MainPage mainPage = new MainPage();
        steps.openSait(mainPage.getUrl());


        List<WebElement> ItemHeadings = browserRule.getWebDriver().findElements(mainPage.getItemHeadings()); // Список заголовок
        List<WebElement> ItemPanels = browserRule.getWebDriver().findElements(mainPage.getItemPanels()); // Список панелей

        steps.click(By.id(ItemHeadings.get(indexQuestion).getAttribute("id")));
        steps.wait(By.id(ItemPanels.get(indexQuestion).getAttribute("id")), 5);
        assertEquals("Показан не тот текст в вопросе: "+ ItemHeadings.get(indexQuestion).getText(),textAnswer , ItemPanels.get(indexQuestion).getText());





    }


}