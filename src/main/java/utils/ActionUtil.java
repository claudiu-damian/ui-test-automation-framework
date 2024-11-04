package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.InitializationUtil.getDriver;

public class ActionUtil {
    private static Actions actions = new Actions(getDriver());

    public static void hover(WebElement webElement) {
        actions.moveToElement(webElement).perform();
    }

    public static void createCssSelectorAndHover(String element) {
        hover(getDriver().findElement(By.cssSelector(element)));
    }
}
