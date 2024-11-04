package core;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static enums.Browser.getValueOfBrowserName;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static utils.PropertyUtils.getSystemProperty;

public class DriverFactory {
    public static final long IMPLICIT_WAIT = 500;
    public static final long DRIVER_WAIT_TIME = 10;
    public static final long DRIVER_SCRIPT_WAIT_TIME = 3;
    public static final String BROWSER_PROPERTY = "browser";

    public static WebDriver getInstance() {
        if (DriverManager.getWebDriver() == null) {
            startDriver(getValueOfBrowserName(getSystemProperty(BROWSER_PROPERTY)));
        }
        return DriverManager.getWebDriver();
    }

    public static void quitDriver() {
        DriverManager.quitWebDriver();
    }

    public static void startDriver(Browser browser) {
        WebDriver driver;
        setupDriver(browser);
        switch (browser) {
            case HEADLESS:
                driver = new ChromeDriver(getHeadlessChrome());
                break;
            case FIREFOX:
                driver = new FirefoxDriver(getFirefoxOptions());
                break;
            case CHROME:
            default:
                driver = new ChromeDriver(getChromeOptions());
                break;
        }
        setDriverDefaults(driver);
        DriverManager.setWebDriver(driver);
    }

    private static void setupDriver(Browser browser) {
        WebDriverManager.getInstance(DriverManagerType.valueOf(browser.getDriverType())).setup();
    }

    private static void setDriverDefaults(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(DRIVER_WAIT_TIME, SECONDS);
        driver.manage().timeouts().setScriptTimeout(DRIVER_SCRIPT_WAIT_TIME, SECONDS);
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage"); //overcome limited resources problems
        options.addArguments("disable-infobars");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--enable-automation");
        options.addArguments("--hooks-type");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL); //do not wait until all resources load
        return options;
    }

    private static ChromeOptions getHeadlessChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--windows-size=1920,1080");
        return options;
    }

    private static FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("dom.disable_beforeunload", true);
        return options;
    }
}
