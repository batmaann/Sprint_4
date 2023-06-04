package ru.praktikum.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.selenium.pageobject.MainPage;
import ru.praktikum.selenium.pageobject.OrderPage;
import ru.praktikum.selenium.pageobject.PageRent;
import org.openqa. selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainTest {
    WebDriver webDriver;
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
        mainPage.scroll();
        mainPage.checkValue();

    }

    @Test// 2 задание
    public void orderTest() {
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);
        PageRent pageRent = new PageRent(webDriver);
        mainPage.clickOrderButton();
        orderPage.sendValue();
        orderPage.clickNext();
        pageRent.completeTheSecondPage("30.06.2023","comment");
        pageRent.completeTheSecondPageAnother("29.07.2023","test");
    }


    @After
    public void teardown() {
        //Закрыть браузер
        webDriver.quit();
    }
}
