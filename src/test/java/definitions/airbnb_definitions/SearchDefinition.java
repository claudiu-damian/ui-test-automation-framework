package definitions.airbnb_definitions;

import io.cucumber.java.en.When;
import pages.airbnb_comp.SearchComponent;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchDefinition {
    private final SearchComponent searchComponent = new SearchComponent();

    @When("^I enter the destination (.*?)$")
    public void searchForDestination(String destination) {
        searchComponent.clickOnDestinationField();
        searchComponent.enterDestination(destination);
    }

    @When("^Select Check (In|Out)? date (.*?)$")
    public void selectCheckInDate(String inOut, String date) {
        if (Objects.equals(inOut, "In")) {
            searchComponent.clickOnCheckInDate();
        } else if (Objects.equals(inOut, "Out")) {
            searchComponent.clickOnCheckOutDate();
        }
        searchComponent.selectDate(date);
    }

    @When("^Choose Check (In|Out)? date after (.*?) days from now$")
    public void selectCheckInDateAfterDays(String inOut, int days) {
        if (Objects.equals(inOut, "In")) {
            searchComponent.clickOnCheckInDate();
        } else if (Objects.equals(inOut, "Out")) {
            searchComponent.clickOnCheckOutDate();
        }
        searchComponent.selectDateAfterDays(inOut, days);
    }

    @When("Click on Search button")
    public void clickOnSearch() {
        searchComponent.clickOnSearch();
    }

    @When("Open guests panel")
    public void openGuestsPanel() {
        searchComponent.clickOnGuests();
    }

    @When("^Add (.*?) (Adult|Adults|Child|Children)? for search$")
    public void addGuestsForSearchByType(int guestsNumber, String guestType) {
        searchComponent.addGuestsBasedOnRequiredNumberAndType(guestsNumber, guestType);
    }

    @When("Validate results from search bar")
    public void validateResultsFromSearchBar() {
        assertThat(searchComponent.validateSearchBar()).isTrue();
    }
}
