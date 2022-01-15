package ru.softlab.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import ru.softlab.tests.TestBase;

import java.util.Set;


public class SoftlabSolutionsPage extends TestBase {

    public SoftlabSolutionsPage(WebDriver wd) {
        PageFactory.initElements(wd, this);
        this.wd = wd;
    }

    //проверить главную страницу! //app.get("https://www.softlab.ru/");
    private By solutions = By.linkText("https://www.softlab.ru/solutions/");
    private String solutionsTitle = "R-Style Softlab | Решения для банков";
    private String homeTitle = "R-Style Softlab | R-Style Softlab";

    private String catalogTitle = "";

    @FindBy(xpath = "//h1[contains(.,'Решения для банков')]")
    private WebElement title_1;

    @FindBy(css = ".logo")
    private WebElement logotip;

    //Плашки с решениями
    @FindBy(css = "#bx_1914200112_5021")
    private WebElement rs_bank_1;

    @FindBy(css = "#bx_1914200112_6336")
    private WebElement rs_bank_2;

    @FindBy(css = "#bx_1914200112_2245")
    private WebElement rs_bank_3;

    @FindBy(css = "#bx_1914200112_2246")
    private WebElement rs_bank_4;

    @FindBy(css = "#bx_1914200112_2249")
    private WebElement rs_bank_5;

    @FindBy(css = "#bx_1914200112_5323")
    private WebElement rs_bank_6;

    @FindBy(css = "#bx_1914200112_6186")
    private WebElement rs_bank_7;

    @FindBy(css = "#bx_1914200112_6244")
    private WebElement rs_bank_8;

    @FindBy(xpath = "//h2[contains(.,'Решения для страховых компаний')]")
    private WebElement title_2;

    @FindBy(css = "#bx_1914200112_6200")
    private WebElement insurance_1;

    @FindBy(css = "#bx_1914200112_6199")
    private WebElement insurance_2;

    @FindBy(css = "#bx_1914200112_6202")
    private WebElement insurance_3;

    @FindBy(css = "#bx_1914200112_6507")
    private WebElement insurance_4;

    @FindBy(xpath ="//div/strong[contains(.,'Каталог продуктов')]")
    private WebElement katalogProduct;

    @FindBy(css =".i-orange-list")
    private WebElement icon;

    @FindBy(xpath ="//a[contains(.,'Посмотреть')][@class='button orange slim load']")
    private WebElement buttonOrange;

    //Переход на текущую страницу
    public void open(){
        wd.get("https://www.softlab.ru/solutions/");
    }
    //Проверка видимости плашек в таблице "Решения для банков"
    public void isTableRSbankPresent() {
        Assert.assertEquals(title_1.isDisplayed(), true);
        Assert.assertEquals(rs_bank_1.isDisplayed(), true);
        Assert.assertEquals(rs_bank_2.isDisplayed(), true);
        Assert.assertEquals(rs_bank_3.isDisplayed(), true);
        Assert.assertEquals(rs_bank_4.isDisplayed(), true);
        Assert.assertEquals(rs_bank_5.isDisplayed(), true);
        Assert.assertEquals(rs_bank_6.isDisplayed(), true);
        Assert.assertEquals(rs_bank_7.isDisplayed(), true);
        //Assert.assertEquals(rs_bank_8.isDisplayed(), true);
    }

    //Проверка видимости плашек в таблице "Решения для страховых компаний"
    public void isTableInsurancePresent() {
        Assert.assertEquals(title_2.isDisplayed(), true);
        Assert.assertEquals(insurance_1.isDisplayed(), true);
        Assert.assertEquals(insurance_2.isDisplayed(), true);
        Assert.assertEquals(insurance_3.isDisplayed(), true);
        Assert.assertEquals(insurance_4.isDisplayed(), true);
    }

    //Проверка видимости блока "Каталог продуктов"
    public void isKatalogProductPresent() {
        Assert.assertEquals(katalogProduct.isDisplayed(), true);
        Assert.assertEquals(icon.isDisplayed(), true);
        Assert.assertEquals(buttonOrange.isDisplayed(), true);
    }

    public void openPDF(){
        String window1 = wd.getWindowHandle();
        String window2 = null;
        buttonOrange.click();
        Assert.assertEquals(wd.getTitle(), solutionsTitle);
        Set<String> currentWindows = wd.getWindowHandles();

        for (String window : currentWindows){
            if(!window.equals(window1)){
                window2=window;
                break;
            }
        }
        Assert.assertNotEquals(window1, window2);
        wd.switchTo().window(window2);
        checkWindowTitle(catalogTitle);
        //Переделать на ссылку https://www.softlab.ru/upload/catalog.pdf
    }
    public void closeWindow() {

        String window1 = null;
        wd.close();
        Set<String> currentWindows = wd.getWindowHandles();
        if (currentWindows.size()>0){
            for (String window : currentWindows) {
                if (!window.equals(window1)) {
                    window1 = window;
                    break;
                }
            }
        }
        wd.switchTo().window(window1);
        checkWindowTitle(solutionsTitle);

    }

    private void checkWindowTitle(String title) {
        Assert.assertEquals(wd.getTitle(), title);
    }

    public void checkColorCssRSBank(){
        String cssLocator ="#bx_1914200112_5021";
        WebElement rs_bank = wd.findElement(By.cssSelector(cssLocator));
        checkWindowTitle(solutionsTitle);

        String colorText = rs_bank.getCssValue("color");
        Assert.assertEquals(colorText,"rgba(0, 111, 102, 1)");
        String backgroundColor = rs_bank.getCssValue("background-color");
        Assert.assertEquals(backgroundColor,"rgba(0, 0, 0, 0)");

        mouseOver("#bx_1914200112_5021");

        colorText = rs_bank.getCssValue("color");
        backgroundColor = rs_bank.getCssValue("background-color");
        Assert.assertEquals(colorText,"rgba(255, 255, 255, 1)");
        Assert.assertEquals(backgroundColor.substring(20),"rgba(75, 186, 173, 0)");
    }

    public void mouseOver(String cssselector) {
        Actions builder = new Actions(wd);
        builder.moveToElement(
                wd.findElement(By
                        .cssSelector(cssselector)))
                .build().perform();

    }

    public void checkLogo() {
        logotip.click();
        checkWindowTitle(homeTitle);
    }

    public void checkButtonOrange() {
        Assert.assertEquals(buttonOrange.isEnabled(),true);
    }

}
