package definitions.airbnb_definitions;

import io.cucumber.java.en.When;
import pages.airbnb_comp.FilterComponent;

public class FilterDefinition {
    private final FilterComponent filterComponent = new FilterComponent();

    @When("Open Filter Pop Up")
    public void clickOnSearch() {
        filterComponent.openFiltersPopUp();
    }

    @When("^Increase the number of bedrooms by (.*?)")
    public void addGuestsForSearchByType(int bedroomNumber) {
        filterComponent.addBedroomsBasedOnNumber(bedroomNumber);
    }

    @When("Add pool to the filter")
    public void addPoolToFilter() {
        filterComponent.addPoolToFilter();
    }

    @When("Show filtered properties")
    public void showFilteredProperties() {
        filterComponent.applyTheFilter();
    }
}
