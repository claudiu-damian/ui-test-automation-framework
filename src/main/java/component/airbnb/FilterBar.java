package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[class*='atm_eiwevr_lafn7y__oggzyc']")
public class FilterBar extends HtmlElement {
    @FindBy(css = "button[class*='dezgoh_1vpy06o_uv4tnr']")
    private Button filtersButton;

    public void clickOnFiltersButton() {
        filtersButton.click();
    }
}
