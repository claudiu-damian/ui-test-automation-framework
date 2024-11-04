package core;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    protected static WebDriver getWebDriver() {
        return webDriver.get();
    }

    protected static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    protected static void quitWebDriver() {
        WebDriver driver = webDriver.get();
        if (driver != null) {
            driver.quit();
        }
        webDriver.remove();
    }
}
