package ru.softlab.tests;

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
    @Test //КАК ПРОВЕРЯТЬ ЗАГРУЗКУ КАЖДОГО ОКНА?
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

    @Test //КАК ПРОВЕРЯТЬ ЗАГРУЗКУ КАЖДОГО ОКНА?
    public void testSoftlabSolutionsCSS() throws Exception {
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.open();
        softlabSolutionsPage.checkColorCssRSBank();
    }

    @Test
    public void testSoftlabSolutionsButtonOrange() throws Exception {
        softlabSolutionsPage = new SoftlabSolutionsPage(wd);
        softlabSolutionsPage.open();
        softlabSolutionsPage.openPDF();
        softlabSolutionsPage.closeWindow();
        softlabSolutionsPage.checkButtonOrange();

    }

    @Test //КАК ПРОВЕРЯТЬ ЗАГРУЗКУ КАЖДОГО ОКНА?
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


