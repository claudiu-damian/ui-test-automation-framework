package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.InitializationUtil.getDriver;

@Log4j2
public class DriverHelperUtil {
    public static void waitForPage() {
        log.info("Waiting for the page to be loaded");
        boolean stillChanging = true;
        String previous = "";
        String current;
        while (stillChanging) {
            current = getDriver().getPageSource();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("Catch InterruptedException: " + e);
            }
            stillChanging = (!previous.equals(current));
            previous = current;
        }
    }

    public static void closeCurrentTabAndSwitch(String windowsHandle) {
        getDriver().close();
        getDriver().switchTo().window(windowsHandle);
    }

    public static void switchTabAndWaitForPage(String windowsHandle) {
        getDriver().switchTo().window(windowsHandle);
        waitForPage();
    }

    public static void createCssSelectorAndClick(String element) {
        WebElement webElement = getDriver().findElement(By.cssSelector(element));
        waitForElementToBeClickable(webElement);
        webElement.click();
    }

    public static void waitForElementToBeClickable(WebElement element) {
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
