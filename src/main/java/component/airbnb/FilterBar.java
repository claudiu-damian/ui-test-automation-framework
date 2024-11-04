package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static utils.DriverHelperUtil.waitForElementToBeClickable;

@FindBy(css = "[class*='atm_eiwevr_lafn7y__oggzyc']")
public class FilterBar extends HtmlElement {
    @FindBy(css = "button[class*='dezgoh_1vpy06o_uv4tnr']")
    private Button filtersButton;

    public void clickOnFiltersButton() {
        waitForElementToBeClickable(filtersButton);
        filtersButton.click();
    }
}
