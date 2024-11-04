package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;
import utils.TextUtils;

import static utils.DriverHelperUtil.waitForElementToBeClickable;

@FindBy(id = "search-tabpanel")
public class SearchBar extends HtmlElement {
    private final TextUtils textUtils = new TextUtils();
    @FindBy(id = "bigsearch-query-location-input")
    private TextInput whereField;

    @FindBy(css = "[data-testid='structured-search-input-field-split-dates-0']")
    private Button checkInField;

    @FindBy(css = "[data-testid='structured-search-input-field-split-dates-1']")
    private Button checkOutField;

    @FindBy(css = "[data-testid='structured-search-input-field-guests-button']")
    private Button guestsField;

    @FindBy(css = "button[class*='bhtghtc']")
    private Button searchButton;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-0']/div/div[@class='v1v28j4b atm_c8_km0zk7 atm_g3_18khvle atm_fr_1m9t47k atm_7l_dezgoh atm_cs_10d11i2 atm_ks_15vqwwr atm_sq_1l2sidv atm_vy_1osqo2v v13ly71q atm_ll_exct8b dir dir-ltr']")
    private TextBlock checkInDate;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-split-dates-1']/div/div[@class='v1v28j4b atm_c8_km0zk7 atm_g3_18khvle atm_fr_1m9t47k atm_7l_dezgoh atm_cs_10d11i2 atm_ks_15vqwwr atm_sq_1l2sidv atm_vy_1osqo2v dir dir-ltr']")
    private TextBlock checkOutDate;

    @FindBy(xpath = "//div[@data-testid='structured-search-input-field-guests-button']/div/div[@class='v1v28j4b atm_c8_km0zk7 atm_g3_18khvle atm_fr_1m9t47k atm_7l_dezgoh atm_cs_10d11i2 atm_ks_15vqwwr atm_sq_1l2sidv atm_vy_1osqo2v dir dir-ltr']")
    private TextBlock guestsNumber;

    @FindBy(css = "[aria-labelledby='littleSearchLabel']")
    private Button littleSearchGuests;

    public void enterDestination(String destination) {
        whereField.sendKeys(destination);
    }

    public void clickOnDestination() {
        whereField.click();
    }

    public void clickOnSearch() {
        searchButton.click();
    }

    public void clickOnCheckInField() {
        checkInField.click();
    }

    public void clickOnCheckOutField() {
        checkOutField.click();
    }

    public void clickOnGuestsField() {
        guestsField.click();
    }

    public boolean validateDestination(String expectedDestination) {
        waitForElementToBeClickable(whereField);
        return whereField.getAttribute("value").equals(expectedDestination);
    }

    public boolean validateCheckInDate(String expectedCheckInDate) {
        return checkInDate.getText().equals(expectedCheckInDate);
    }

    public boolean validateCheckOutDate(String expectedCheckOutDate) {
        return checkOutDate.getText().equals(expectedCheckOutDate);
    }

    public boolean validateGuestsNumber(String expectedGuestsNumber) {
        return guestsNumber.getText().equals(expectedGuestsNumber);
    }

    public void clickOnLittleSearchGuests() {
        littleSearchGuests.click();
    }
}
