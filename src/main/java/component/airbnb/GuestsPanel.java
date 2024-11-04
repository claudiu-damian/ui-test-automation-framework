package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[data-testid='structured-search-input-field-guests-panel']")
public class GuestsPanel extends HtmlElement {
    @FindBy(css = "button[aria-label='increase value'][aria-describedby='searchFlow-title-label-adults']")
    private Button adultsIncreaseButton;
    @FindBy(css = "button[aria-label='decrease value'][aria-describedby='searchFlow-title-label-adults']")
    private Button adultsDecreaseButton;
    @FindBy(css = "button[aria-label='increase value'][aria-describedby='searchFlow-title-label-children']")
    private Button childrenIncreaseButton;
    @FindBy(css = "button[aria-label='decrease value'][aria-describedby='searchFlow-title-label-children']")
    private Button childrenDecreaseButton;
    @FindBy(css = "button[aria-label='increase value'][aria-describedby='searchFlow-title-label-infants']")
    private Button infantsIncreaseButton;
    @FindBy(css = "button[aria-label='decrease value'][aria-describedby='searchFlow-title-label-infants']")
    private Button infantsDecreaseButton;
    @FindBy(css = "button[aria-label='increase value'][aria-describedby='searchFlow-title-label-pets']")
    private Button petsIncreaseButton;
    @FindBy(css = "button[aria-label='decrease value'][aria-describedby='searchFlow-title-label-pets']")
    private Button petsDecreaseButton;

    public void addAdult() {
        adultsIncreaseButton.click();
    }

    public void addChild() {
        childrenIncreaseButton.click();
    }
}
