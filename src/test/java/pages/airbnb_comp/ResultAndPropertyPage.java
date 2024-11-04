package pages.airbnb_comp;

import component.BasePage;
import component.airbnb.AmenitiesPopUp;
import component.airbnb.MapComponent;
import component.airbnb.ResultPage;
import enums.context_keys.Data;
import io.qameta.allure.Allure;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.ExecutionContext;
import utils.TextUtils;

import java.io.ByteArrayInputStream;
import java.util.List;

import static enums.context_keys.Data.*;
import static utils.ActionUtil.createCssSelectorAndHover;
import static utils.DriverHelperUtil.*;
import static utils.InitializationUtil.getDriver;
import static utils.JavascriptExecutorUtil.scroll;

@Log4j2
public class ResultAndPropertyPage extends BasePage {
    private final TextUtils textUtils = new TextUtils();
    private ResultPage resultPage;
    private AmenitiesPopUp amenitiesPopUp;
    private MapComponent mapComponent;

    private int chooseAttributeToValidateInProperty(Data attribute) {
        int attributeNumber = 0;
        switch (attribute) {
            case GUESTS:
                attributeNumber = TextUtils.getIntegerFromString(resultPage.getGuestNumber());
                break;
            case BEDROOMS_FILTER:
                attributeNumber = TextUtils.getIntegerFromString(resultPage.getBedroomsNumber());
                break;
        }
        return attributeNumber;
    }

    private boolean validateAttributeNumberForProperty(Data attributeKey) {
        int actualAttribute = chooseAttributeToValidateInProperty(attributeKey);
        int expectedAttribute = Integer.parseInt(ExecutionContext.get(attributeKey).toString());
        log.info(String.format("Property has %s %s, expected is %s %s", actualAttribute, attributeKey.name(), expectedAttribute, attributeKey.name()));
        return actualAttribute < expectedAttribute;
    }

    private List<String> getAllDisplayedProperties() {
        List<String> properties = resultPage.getAllPropertiesFromPage();
        log.info("Number of properties: " + properties.size());
        return properties;
    }

    private boolean validateSingleAttributeFromAllDisplayedProperties(Data attributeKey) {
        scroll();
        List<String> properties = getAllDisplayedProperties();
        for (String propertyElement : properties) {
            createCssSelectorAndClick(propertyElement);
            Object[] windowHandles = getDriver().getWindowHandles().toArray();
            switchTabAndWaitForPage((String) windowHandles[1]);
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(
                    ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)
            ));
            log.info("Screenshot took and added to the report for property: " + propertyElement);
            if (validateAttributeNumberForProperty(attributeKey))
                return false;
            closeCurrentTabAndSwitch((String) windowHandles[0]);
        }
        return true;
    }

    public boolean validateAttributeNumberFromAllDisplayedProperties(String attribute) {
        boolean areAllPropertiesAsExpected = true;
        switch (attribute) {
            case "guests":
                areAllPropertiesAsExpected = validateSingleAttributeFromAllDisplayedProperties(GUESTS);
                break;
            case "bedrooms":
                areAllPropertiesAsExpected = validateSingleAttributeFromAllDisplayedProperties(BEDROOMS_FILTER);
                break;
        }
        return areAllPropertiesAsExpected;
    }

    public void openTheFirstProperty() {
        List<String> properties = getAllDisplayedProperties();
        createCssSelectorAndClick(properties.get(0));
        Object[] windowHandles = getDriver().getWindowHandles().toArray();
        switchTabAndWaitForPage((String) windowHandles[1]);
    }

    public void openAmenities() {
        resultPage.closeTranslationIfDisplayed();
        resultPage.openPropertyAmenities();
    }

    public boolean checkIfPoolAmenityIsPresent() {
        return amenitiesPopUp.checkIfPoolAmenityIsPresent();
    }

    public void hoverOverTheFirstProperty() {
        List<String> properties = getAllDisplayedProperties();
        ExecutionContext.put(FIRST_PROPERTY, properties.get(0));
        createCssSelectorAndHover(properties.get(0));
        log.info("hover");
    }

    public boolean checkThatStyleChangesAfterHover() {
        return mapComponent.checkThatPropertyIsHovered();
    }

    public void openHoveredPropertyOnMap() {
        mapComponent.clickOnHoveredProperty();
    }

    public boolean validateFirstPropertyInfoOnMapAndResultPage() {
        return resultPage.checkIfPropertyFromMapInfoIsSameAsResultPage(ExecutionContext.get(FIRST_PROPERTY).toString());
    }
}
