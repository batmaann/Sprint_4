package ru.praktikum.selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    WebDriver webDriver;

    public OrderPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    private By fieldName = By.className("Input_Responsible__1jDKN");
    //поле имя
    private By fieldLastname = By.xpath(".//input[@placeholder='* Фамилия']");
    //поле фамилия
    private By fieldAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //поле адрес
    private By fieldMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    //поле станция метро
    private By metroStation = By.xpath(".//li[@data-index='3']");
    //нужная станция метро
    private By fieldNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //поле номера телефона
    private By nextButton = By.className("Button_Middle__1CSJM");
    //кнопка далее
    private By stationMetro = By.xpath(".//div[text()='Черкизовская']");

    //методы для страницы Для кого самокат


    public void station() {
        webDriver.findElement(fieldMetroStation).click();
        webDriver.findElement(stationMetro).click();
    }

    public void clickNext() {
        webDriver.findElement(nextButton).click();
    }


    public void sendValue(String name, String lastName, String address, String phone) {
        webDriver.findElement(fieldName).sendKeys(name);//ввод имени
        webDriver.findElement(fieldLastname).sendKeys(lastName);//ввод фамилии
        webDriver.findElement(fieldAddress).sendKeys(address);//ввод адреса
        station();
        webDriver.findElement(fieldNumber).sendKeys(phone);//ввод телефона

    }

    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }


}
