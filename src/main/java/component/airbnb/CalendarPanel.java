package component.airbnb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import utils.TextUtils;

import static utils.InitializationUtil.getDriver;

@FindBy(css = "[data-testid='structured-search-input-field-dates-panel']")
public class CalendarPanel extends HtmlElement {
    private final TextUtils textUtils = new TextUtils();
    @FindBy(className = "_qz9x4fc")
    private Button calendarArrow;

    public void selectDate(String date) {
        WebElement dateElement = getDriver().findElement(By.cssSelector(textUtils.createCSSSelectorWithDataTestID(date)));
        dateElement.click();
    }
}
