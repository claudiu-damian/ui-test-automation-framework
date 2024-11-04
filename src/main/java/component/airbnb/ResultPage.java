package component.airbnb;

import enums.Constants;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextBlock;

import java.util.ArrayList;
import java.util.List;

import static enums.Constants.*;
import static utils.DriverHelperUtil.waitForElementToBeClickable;
import static utils.InitializationUtil.getDriver;

@Log4j2
@FindBy(id = "site-content")
public class ResultPage extends HtmlElement {
    private Constants constants;
    private final WebElement propertiesGroup = getDriver().findElement(By.id("site-content"));

    @FindBy(xpath = "//li[@class='l7n4lsf atm_9s_1o8liyq_keqd55 dir dir-ltr' and contains(., 'guests')]")
    private TextBlock propertyGuestsNumber;

    @FindBy(xpath = "//li[@class='l7n4lsf atm_9s_1o8liyq_keqd55 dir dir-ltr' and contains(., 'bedrooms')]")
    private TextBlock propertyBedroomsNumber;

    @FindBy(xpath = "//div[@class='b9672i7 atm_h3_8tjzot atm_h3_1ph3nq8__oggzyc dir dir-ltr']/button")
    private WebElement showAmenitiesButton;

    public List<String> getAllPropertiesFromPage() {
        List<WebElement> properties = this.findElements(By.cssSelector("[data-testid='card-container']"));
        List<String> propertyList = new ArrayList<>();
        properties.forEach(prop -> propertyList.add(String.format(ARIA_LABEL_BY_SELECTOR.constant, getPropertyID(prop))));
        return propertyList;
    }

    private String getPropertyID(WebElement element) {
        return element.getAttribute(ARIA_LABEL_BY_PROPERTY.constant);
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
            if (getDriver().findElement(By.cssSelector("[data-testid='translation-announce-modal']")).isDisplayed())
                getDriver().findElement(By.cssSelector("[aria-label='Close']")).click();
        } catch (NoSuchElementException noSuchElementException) {
            log.info("Translation Modal not displayed");
        }
    }
    //getDriver().findElement(By.cssSelector("[style*='transform: scale(1.077); ']>div")).click()
//    getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720'][style*='--card-container_width']")).getText()
//getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720']>div[class='lxq01kf atm_9s_1txwivl atm_am_kyuy1d atm_ar_d67k9l l1tup9az atm_1p4glcj_1bp4okc dir dir-ltr']>div[class='g1qv1ctd atm_u80d3j_1li1fea atm_c8_o7aogt atm_g3_8jkm7i c1v0rf5q atm_9s_11p5wf0 atm_cx_4wguik atm_dz_7esijk atm_e0_1lo05zz dir dir-ltr']>div[data-testid=listing-card-title]")).getText()
//    getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720']>div>div[class='gltso3m atm_u80d3j_1li1fea atm_c8_o7aogt atm_g3_8jkm7i atm_l8_y1qneu c1v0rf5q atm_9s_11p5wf0 atm_cx_4wguik atm_dz_7esijk atm_e0_1lo05zz dir dir-ltr']>div[data-testid='listing-card-title']")).getText()
//getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720']>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='price-availability-row']>div>div>div>span[class='_1qgfaxb1']")).getText()

//    getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720']>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-title']"))
//getDriver().findElements(By.cssSelector("[aria-labelledby='title_1749720']>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-subtitle']")).get(1).getText()
//    getDriver().findElement(By.cssSelector("[aria-labelledby='title_1749720']>div>div[class*='atm_l8_y1qneu']>[class*='b1lki7m']")).getText()

    public String getTitleOfPropertyFromResultPage(String propertyID) {
        return getDriver().findElement(By.cssSelector(String.format(RESULT_PAGE_PROPERTY_TITLE_SELECTOR.constant, propertyID))).getText();
    }

    public String getPropertySubTitleFromResultPage(String propertyID) {
        List<WebElement> subtitlesElements = getDriver().findElements(By.cssSelector(String.format(RESULT_PAGE_PROPERTY_SUBTITLE_SELECTOR.constant, propertyID)));
        List<String> subtitles = new ArrayList<>();
        subtitlesElements.forEach(element -> subtitles.add(element.getText()));
        return String.join(", ", subtitles);
    }

    public String getPropertyPriceFromResultPage(String propertyID) {
        return getDriver().findElement(By.cssSelector(String.format(RESULT_PAGE_PROPERTY_PRICE_SELECTOR.constant, propertyID))).getText();
    }

    public String getTitleOfPropertyFromMap(String propertyID) {
        return getDriver().findElement(By.cssSelector(String.format(MAP_PROPERTY_TITLE_SELECTOR.constant, propertyID))).getText();
    }

    public String getPropertySubTitleFromMap(String propertyID) {
        List<WebElement> subtitlesElements = getDriver().findElements(By.cssSelector(String.format(MAP_PROPERTY_SUBTITLE_SELECTOR.constant, propertyID)));
        List<String> subtitles = new ArrayList<>();
        subtitlesElements.forEach(element -> subtitles.add(element.getText()));
        return String.join(", ", subtitles);
    }

    public String getPropertyPriceFromMap(String propertyID) {
        return getDriver().findElement(By.cssSelector(String.format(MAP_PROPERTY_PRICE_SELECTOR.constant, propertyID))).getText();
    }

    public boolean checkIfPropertyFromMapInfoIsSameAsResultPage(String propertyID) {
        return getTitleOfPropertyFromResultPage(propertyID).equals(getTitleOfPropertyFromMap(propertyID))
                && getPropertySubTitleFromResultPage(propertyID).equals(getPropertySubTitleFromMap(propertyID))
                && getPropertyPriceFromResultPage(propertyID).equals(getPropertyPriceFromMap(propertyID));
    }

}
