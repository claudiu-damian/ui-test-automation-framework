package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[aria-labelledby='littleSearchLabel']")
public class LittleSearchBar extends HtmlElement {
    @FindBy(css = "[data-testid='little-search-anytime'")
    private Button littleSearchDate;

    public void clickOnSearchDate() {
        littleSearchDate.click();
    }
}
