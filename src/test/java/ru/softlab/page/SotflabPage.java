package ru.softlab.page;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.softlab.tests.TestBase;


public class SotflabPage extends TestBase {

    public SotflabPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }

    //private By homePage = By.linkText("https://www.softlab.ru/");
    private String homeTitle = "R-Style Softlab | R-Style Softlab";

    @FindBy(css = ".logo")
    private WebElement logotip;

    @FindBy(linkText = "О компании")
    private WebElement company;

    @FindBy(linkText = "Решения")
    private WebElement solutions;

    @FindBy(linkText = "Услуги")
    private WebElement services;

    @FindBy(linkText = "Мероприятия")
    private WebElement events;

    @FindBy(linkText = "Пресс-центр")
    private WebElement press;

    @FindBy(linkText = "Карьера")
    private WebElement career;

    @FindBy(linkText = "Блог")
    private WebElement blog;

    @FindBy(css = ".support")
    private WebElement buttonSupport;

    @FindBy(css = "input.textbox")
    private WebElement search;

    @FindBy(css = ".newsList")
    private WebElement newList;

    @FindBy(css = ".inFocus")
    private WebElement inFocus;

    @FindBy(css = "li.bjqs-slide:nth-child(1)")
    private WebElement slide;

    @Step("Вход на сайт https://www.softlab.ru/")
    public void open() {
        wd.get("https://www.softlab.ru/");
        checkWindowTitle(homeTitle);
    }

    @Step("Присутствует логотип")
    public void isLogoPresent() {
        Assert.assertEquals(logotip.isDisplayed(), true);
    }

    @Step("Присутствует меню 'О компании' ")
    public void isCompanyPresent() {
        Assert.assertEquals(company.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Решения' ")
    public void isSolutionsPresent() {
        Assert.assertEquals(solutions.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Услуги' ")
    public void isServicesPresent() {
        Assert.assertEquals(services.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Мероприятия' ")
    public void isEventsPresent() {
        Assert.assertEquals(events.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Пресс-центр' ")
    public void isPressPresent() {
        Assert.assertEquals(press.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Карьера' ")
    public void isCareerPresent() {
        Assert.assertEquals(career.isDisplayed(), true);
    }

    @Step("Присутствует меню 'Блог' ")
    public void isBlogPresent() {
        Assert.assertEquals(blog.isDisplayed(), true);
    }

    @Step("Присутствует кнопка 'Поддержка' ")
    public void isButtonSupporsPresent() {
        Assert.assertEquals(buttonSupport.isDisplayed(), true);
    }

    @Step("Присутствует поле 'Поиск' ")
    public void isSearchPresent() {
        Assert.assertEquals(search.isDisplayed(), true);
    }

    @Step("Присутствует лента 'Новости и события' ")
    public void isNewsListPresent() {
        Assert.assertEquals(newList.isDisplayed(), true);
    }

    @Step("Присутствует лента 'История успеха'")
    public void isInFocusPresent() {
        Assert.assertEquals(inFocus.isDisplayed(), true);
    }

    @Step("Присутствует карусель")
    public void isSlidePresent() {
        Assert.assertEquals(slide.isDisplayed(), true);
    }

    @Step("Клик по кнопке 'Поддержка' ")
    public void clickButtonSolutions() {
        solutions.click();

    }

    private void checkWindowTitle(String title) {
        Assert.assertEquals(wd.getTitle(), title);
    }


}
