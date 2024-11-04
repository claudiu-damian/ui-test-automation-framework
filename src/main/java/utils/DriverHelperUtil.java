package utils;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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
//div class="oival0u atm_6i_idpfg4 atm_fq_idpfg4 atm_mk_1n9t6rb atm_n3_idpfg4 atm_tk_idpfg4 atm_wq_18b4za2 atm_e2_1kxcs5u atm_2d_e5ic7o dir dir-ltr"
    public static void waitForElementToBeClickable(WebElement element) {
        (new WebDriverWait(getDriver(), 10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static String getTextBasedOnCss(String selector) {
        return getDriver().findElement(By.cssSelector(selector)).getText();
    }

    public static String getJoinedTextFromElementsBasedOnCss(String elementsSelector) {
        List<WebElement> elements = getDriver().findElements(By.cssSelector(elementsSelector));
        List<String> stringElements = new ArrayList<>();
        elements.forEach(element -> stringElements.add(element.getText()));
        return String.join(", ", stringElements);
    }
}
