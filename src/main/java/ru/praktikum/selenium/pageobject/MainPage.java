package ru.praktikum.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class MainPage {
    public MainPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    WebDriver webDriver;

    private By upperOrderButton = By.className("Button_Button__ra12g");
    //кнопка заказать верхняя
    private final By cookieButton = By.className("App_CookieButton__3cvqF");
    //кнопка принять куки нажимать перед нижней кнопкой заказать и перед кликом на вопросы
    private By lowerOrderButton = By.className("Button_Middle__1CSJM");
    //кнопка заказать нижняя
    private By priceQuestion = By.id("accordion__heading-0");
    //Сколько это стоит? И как оплатить?
    private By priceAnswer = By.id("accordion__panel-0");
    //Сутки — 400 рублей. Оплата курьеру — наличными или картой.
    private By quantityQuestion = By.id("accordion__heading-1");
    //Хочу сразу несколько самокатов! Так можно?
    private By quantityAnswer = By.id("accordion__panel-1");
    //Пока что у нас так: один заказ — один самокат...
    private By timeQuestion = By.id("accordion__heading-2");
    //Как рассчитывается время аренды?
    private By timeAnswer = By.id("accordion__panel-2");
    //Допустим, вы оформляете заказ на 8 мая...
    private By dateQuestion = By.id("accordion__heading-3");
    //Можно ли заказать самокат прямо на сегодня?
    private By dateAnswer = By.id("accordion__panel-3");
    //Только начиная с завтрашнего дня...
    private By extensionQuestion = By.id("accordion__heading-4");
    //Можно ли продлить заказ или вернуть самокат раньше?
    private By extensionAnswer = By.id("accordion__panel-4");
    //Пока что нет! Но если что-то срочное...
    private By chargerQuestion = By.id("accordion__heading-5");
    //Вы привозите зарядку вместе с самокатом?
    private By chargerAnswer = By.id("accordion__panel-5");
    //Самокат приезжает к вам с полной зарядкой...
    private By cancellationQuestion = By.id("accordion__heading-6");
    //Можно ли отменить заказ?
    private By cancellationAnswer = By.id("accordion__panel-6");
    //Да, пока самокат не привезли...
    private By suburbQuestion = By.id("accordion__heading-7");
    //Я жизу за МКАДом, привезёте?
    private By suburbAnswer = By.id("accordion__panel-7");
    //Да, обязательно. Всем самокатов!...
    private By[] allQuestions = new By[]{
            priceQuestion,
            quantityQuestion,
            timeQuestion,
            dateQuestion,
            extensionQuestion,
            chargerQuestion,
            cancellationQuestion,
            suburbQuestion
    };
    private By[] allAnswers = new By[]{
            priceAnswer,
            quantityAnswer,
            timeAnswer,
            dateAnswer,
            extensionAnswer,
            chargerAnswer,
            cancellationAnswer,
            suburbAnswer
    };

    //методы для главной страницы
    public void clickCookieButton() {

        webDriver.findElement(cookieButton).click();
    }

    public void clickOrderButton() {
        webDriver.findElement(upperOrderButton).click();
    }

    public By getQuestion(int i) {

        return allQuestions[i];
    }

    public By getAnswer(int i) {
        return allAnswers[i];
    }

    public void clickQuestion(int i) {
        webDriver.findElement(getQuestion(i)).click();
    }

    public void clickUpperOrderButton() {
        webDriver.findElement(upperOrderButton).click();
    }

    public void clickLowerOrderButton() {
        webDriver.findElement(lowerOrderButton).click();
    }

    String[] texts =
            {
                    "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
                    "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
                    "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                    "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
                    "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                    "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                    "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                    "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
            };


    public void scroll() {//проскролить страницу до нижнего элемента
        WebElement element = webDriver.findElement(By.className("accordion__button"));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
    }

    //здесь описаны 2 способа проверки 1-ого задание через метод checkValue, я не знал как правильно и поэтому сделал два варианта, нужно просто один раскоментить, а другой наоборот закоментить
//    public void checkValue() {
//        for (int i = 0; i < 8; i = i + 1) { // Объявление цикла и его настройки
//            By button = By.id("accordion__heading-" + i);
//            webDriver.findElement(button).click(); // Тело цикла, выполняется при каждой итерации
//            String text = webDriver.findElement(By.xpath(
//                    ".//div[@id='accordion__heading-" + i + "']/parent::div/parent::div/div[2]"
//            )).getText();
//            assertEquals("текст не верный", texts[i], text);
//
//        }
//    }


    public void checkValue() {
        for (int i = 1; i < 9; i = i + 1) { // Объявление цикла и его настройки
            String xpath = ".//div[@class='accordion']/div[" + i + "]";
            webDriver.findElement(By.xpath(xpath + "/div")).click(); // Тело цикла, выполняется при каждой итерации
            String text = webDriver.findElement(By.xpath(xpath + "/div[2]")).getText();
            assertEquals("текст не верный", texts[i - 1], text);

        }
    }

}
