package component.airbnb;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;

import static enums.LocatorConstants.*;
import static utils.DriverHelperUtil.*;
import static utils.InitializationUtil.getDriver;

@Log4j2
@FindBy(id = "site-content")
public class ResultPage extends HtmlElement {
    private final WebElement propertiesGroup = getDriver().findElement(By.id("site-content"));

    @FindBy(xpath = "//li[@class='l7n4lsf atm_9s_1o8liyq_keqd55 dir dir-ltr' and contains(., 'guests')]")
    private TextBlock propertyGuestsNumber;

    @FindBy(xpath = "//li[@class='l7n4lsf atm_9s_1o8liyq_keqd55 dir dir-ltr' and contains(., 'bedrooms')]")
    private TextBlock propertyBedroomsNumber;

    @FindBy(xpath = "//div[@class='b9672i7 atm_h3_8tjzot atm_h3_1ph3nq8__oggzyc dir dir-ltr']/button")
    private WebElement showAmenitiesButton;

    public List<String> getAllPropertiesFromPage() {
        List<WebElement> properties = this.findElements(By.cssSelector(PROPERTY_CARD_CONTAINER_SELECTOR.value));
        List<String> propertyList = new ArrayList<>();
        properties.forEach(prop -> propertyList.add(String.format(ARIA_LABEL_BY_SELECTOR.value, getPropertyID(prop))));
        return propertyList;
    }

    private String getPropertyID(WebElement element) {
        return element.getAttribute(ARIA_LABEL_BY_PROPERTY.value);
    }

    public String getGuestNumber() {
        return propertyGuestsNumber.getText();
    }

    public String getBedroomsNumber() {
        return propertyBedroomsNumber.getText();
    }

    public void openPropertyAmenities() {
        waitForElementToBeClickable(showAmenitiesButton);
        showAmenitiesButton.click();
    }

    public void closeTranslationIfDisplayed() {
        try {
            if (getDriver().findElement(By.cssSelector(TRANSLATION_MODAL_SELECTOR.value)).isDisplayed())
                getDriver().findElement(By.cssSelector(CLOSE_BUTTON_SELECTOR.value)).click();
        } catch (NoSuchElementException noSuchElementException) {
            log.info("Translation Modal not displayed");
        }
    }

    public boolean checkIfPropertyFromMapInfoIsSameAsResultPage(String propertyID) {
        return getTextBasedOnCss(String.format(RESULT_PAGE_PROPERTY_TITLE_SELECTOR.value, propertyID))
                .equals(getTextBasedOnCss(String.format(MAP_PROPERTY_TITLE_SELECTOR.value, propertyID)))
                && getJoinedTextFromElementsBasedOnCss(String.format(RESULT_PAGE_PROPERTY_SUBTITLE_SELECTOR.value, propertyID))
                .equals(getJoinedTextFromElementsBasedOnCss(String.format(MAP_PROPERTY_SUBTITLE_SELECTOR.value, propertyID)))
                && getTextBasedOnCss(String.format(RESULT_PAGE_PROPERTY_PRICE_SELECTOR.value, propertyID))
                .equals(getTextBasedOnCss(String.format(MAP_PROPERTY_PRICE_SELECTOR.value, propertyID)));
    }
}
