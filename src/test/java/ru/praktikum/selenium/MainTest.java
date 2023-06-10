package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.praktikum.selenium.pageobject.MainPage;
import org.openqa. selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;

public class MainTest {
    WebDriver webDriver;
    TestData testData = new TestData();
    @Before
    public void setupDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        //webDriver = new ChromeDriver();
        webDriver = new FirefoxDriver();

        MainPage mainPage = new MainPage(webDriver);
        webDriver.manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
        webDriver.get(APP_URL);
        mainPage.clickCookieButton();

    }

    @Test// 1 задание
    public void name() {
        MainPage mainPage = new MainPage(webDriver);
        scroll();
        checkValue();

    }
    public void checkValue() {
        for (int i = 1; i < 9; i = i + 1) { // Объявление цикла и его настройки
            String xpath = ".//div[@class='accordion']/div[" + i + "]";
            webDriver.findElement(By.xpath(xpath + "/div")).click(); // Тело цикла, выполняется при каждой итерации
            String text = webDriver.findElement(By.xpath(xpath + "/div[2]")).getText();
            Assert.assertEquals("текст не верный", testData.texts[i - 1], text);

        }
    }

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


    @After
    public void teardown() {
        //Закрыть браузер
        webDriver.quit();
    }
}
