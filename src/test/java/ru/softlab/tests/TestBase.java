package ru.softlab.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private final Properties properties;
    protected WebDriver wd;
    private String browser;

    /*public TestBase(String browser) {
        this.browser = browser;
        properties = new Properties();
    }*/

    public TestBase() {
        properties = new Properties();
    }

    //Драйвер браузера: BrowserType.FIREFOX,BrowserType.IE,BrowserType.CHROME
    //protected static final ApplicationManager app
    //        = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));


    @BeforeSuite
    public void setUp() throws Exception {

       // String target = System.getProperty("target", "local");
        //properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        /*if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }*/
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");
        //wd = new FirefoxDriver();
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //wd.get(properties.getProperty("web.baseUrl"));
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        wd.quit();

    }




}
