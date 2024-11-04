package pages.airbnb_comp;

import component.BasePage;
import component.airbnb.FilterBar;
import component.airbnb.FiltersPopUp;
import utils.ExecutionContext;

import static utils.DriverHelperUtil.waitForPage;
import static enums.context_keys.Data.BEDROOMS_FILTER;

public class FilterComponent extends BasePage {
    private FiltersPopUp filtersPopUp;
    private FilterBar filterBar;

    public void addBedroomsBasedOnNumber(int numberOfBedrooms) {
        ExecutionContext.addOrIncreaseNumberForKey(numberOfBedrooms, BEDROOMS_FILTER);
        for (int i = 1; i <= numberOfBedrooms; i++)
            filtersPopUp.addBedroomsToFilter();
    }

    public void openFiltersPopUp() {
        filterBar.clickOnFiltersButton();
    }

    public void addPoolToFilter() {
        filtersPopUp.selectPoolOption();
    }

    public void applyTheFilter() {
        filtersPopUp.applyFilter();
        waitForPage();
    }
}
