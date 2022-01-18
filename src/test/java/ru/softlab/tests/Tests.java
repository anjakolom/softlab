package ru.softlab.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.softlab.page.SoftlabSolutionsPage;
import ru.softlab.page.SotflabPage;

public class Tests extends TestBase {
    public static SotflabPage softlabPage;
    public static SoftlabSolutionsPage softlabSolutionsPage;
    public Tests() {
        //super(browser);
    }

    @Feature(value = "Проверка отображения главной страницы ")
    @Test
    public void testSoftlabHomePage() throws Exception {
        softlabPage = new SotflabPage(wd);
        softlabPage.open();
        softlabPage.isLogoPresent();
        softlabPage.isCompanyPresent();
        softlabPage.isSolutionsPresent();
        softlabPage.isServicesPresent();
        softlabPage.isEventsPresent();
        softlabPage.isPressPresent();
        softlabPage.isCareerPresent();
        softlabPage.isBlogPresent();
        softlabPage.isSearchPresent();
        softlabPage.isNewsListPresent();
        softlabPage.isInFocusPresent();
        softlabPage.isButtonSupporsPresent();


    }
    @Feature(value = "Выбрать вкладку «Решения». Проверить отображение страницы 'Решения'")
    @Test
    public void testSoftlabSolutions() throws Exception {
        softlabPage = new SotflabPage(wd);
        softlabPage.open();
        softlabPage = new SotflabPage(wd);
        softlabPage.clickButtonSolutions();
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.isTableRSbankPresent();
        softlabSolutionsPage.isTableInsurancePresent();
        softlabSolutionsPage.isKatalogProductPresent();

    }

    @Feature(value = "Навести мышкой на одну из плашек в блоке «Решения для банков», проверить цвет фона и текста.")
    @Test
    public void testSoftlabSolutionsCSS() throws Exception {
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.open();
        softlabSolutionsPage.checkColorCssRSBank();
    }
    @Feature(value = "Нажать на кнопку «Посмотреть» в блоке «Каталог продуктов» и закрыть окно с PDF")
    @Test
    public void testSoftlabSolutionsButtonOrange() throws Exception {
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.open();
        softlabSolutionsPage.openPDF();
        softlabSolutionsPage.closeWindow();
        softlabSolutionsPage.checkButtonOrange();

    }
    @Feature(value = "Нажать на логотип компании в левом верхнем углу, проверить отображение главной страницы")
    @Test
    public void testSoftlabSolutionsLogotip() throws Exception {
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.open();
        softlabSolutionsPage.checkLogo();
        softlabPage = new SotflabPage(wd);
        softlabPage.isLogoPresent();
        softlabPage.isCompanyPresent();
        softlabPage.isSolutionsPresent();
        softlabPage.isServicesPresent();
        softlabPage.isEventsPresent();
        softlabPage.isPressPresent();
        softlabPage.isCareerPresent();
        softlabPage.isBlogPresent();
        softlabPage.isSearchPresent();
        softlabPage.isNewsListPresent();
        softlabPage.isInFocusPresent();
        softlabPage.isButtonSupporsPresent();

    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }

    private boolean isElementPresent(By by) {
        try {
            wd.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }


}


