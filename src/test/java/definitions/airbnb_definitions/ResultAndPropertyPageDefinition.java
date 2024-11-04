package definitions.airbnb_definitions;

import io.cucumber.java.en.When;
import pages.airbnb_comp.ResultAndPropertyPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultAndPropertyPageDefinition {
    private final ResultAndPropertyPage resultAndPropertyPage = new ResultAndPropertyPage();

    @When("^Validate that properties have the required (guests|bedrooms)? number$")
    public void goThroughAllProperties(String attribute) {
        assertThat(resultAndPropertyPage.validateAttributeNumberFromAllDisplayedProperties(attribute)).isTrue();
    }

    @When("Open the first property")
    public void openFirstDisplayedProperty() {
        resultAndPropertyPage.openTheFirstProperty();
    }

    @When("Open amenities popup")
    public void openAmenitiesPopUp() {
        resultAndPropertyPage.openAmenities();
    }

    @When("Check if pool amenity is present")
    public void checkIfPoolAmenityIsPresent() {
        assertThat(resultAndPropertyPage.checkIfPoolAmenityIsPresent()).isTrue();
    }

    @When("Hover the first property from search results")
    public void hoverFirst() {
        resultAndPropertyPage.hoverOverTheFirstProperty();
    }

    @When("Check that hovered property changes on map")
    public void checkHoverOnMap() {
        assertThat(resultAndPropertyPage.checkThatStyleChangesAfterHover()).isTrue();
    }

    @When("Open hovered property from map")
    public void openHoveredPropertyFromMap() {
        resultAndPropertyPage.openHoveredPropertyOnMap();
    }

    @When("Check if information from map for the first property is same as in the page")
    public void validatePropertyInfoOnMapAndPage() {
        assertThat(resultAndPropertyPage.validateFirstPropertyInfoOnMapAndResultPage()).isTrue();
    }
}
