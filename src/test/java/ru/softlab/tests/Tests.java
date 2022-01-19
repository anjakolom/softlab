package ru.softlab.tests;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.softlab.page.SoftlabSolutionsPage;
import ru.softlab.page.SotflabPage;

public class Tests extends TestBase {
    public static SotflabPage softlabPage;
    public static SoftlabSolutionsPage softlabSolutionsPage;


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
        softlabPage.isSlidePresent();

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
        softlabPage.isSlidePresent();
    }


}


