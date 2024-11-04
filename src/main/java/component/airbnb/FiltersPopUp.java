package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[aria-label='Filters']")
public class FiltersPopUp extends HtmlElement {
    @FindBy(css = "button[aria-label='decrease value'][aria-describedby*='searchFlow-title-label-filter-item-min_bedrooms']")
    private Button decreaseBedroomsValue;

    @FindBy(css = "button[aria-label='increase value'][aria-describedby*='searchFlow-title-label-filter-item-min_bedrooms']")
    private Button increaseBedroomsValue;

    @FindBy(css = "[data-testid='stepper-filter-item-min_bedrooms-stepper-value']")
    private HtmlElement bedroomNumber;

    @FindBy(id = "filter-item-amenities-7")
    private Button poolOption;

    @FindBy(css = "[class*='ptiimno atm_7l_1p8m8iw']")
    private HtmlElement applyFilterButton;

    public void selectPoolOption() {
        poolOption.click();
    }

    public void addBedroomsToFilter() {
        increaseBedroomsValue.click();
    }

    public String getBedroomNumberFromFilter() {
        return bedroomNumber.getText();
    }

    public void applyFilter() {
        applyFilterButton.click();
    }
}