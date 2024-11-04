package pages.airbnb_comp;

import component.BasePage;
import component.airbnb.*;
import lombok.extern.log4j.Log4j2;
import utils.DriverHelperUtil;
import utils.ExecutionContext;
import utils.TextUtils;

import java.util.Objects;

import static enums.context_keys.Data.*;

@Log4j2
public class SearchComponent extends BasePage {
    private SearchBar searchBar;
    private CalendarPanel calendarPanel;
    private GuestsPanel guestsPanel;
    private ResultPage resultPage;
    private LittleSearchBar littleSearchBar;
    private final TextUtils textUtils = new TextUtils();

    public void enterDestination(String destination) {
        searchBar.enterDestination(destination);
        ExecutionContext.put(DESTINATION, destination);
    }

    public void clickOnDestinationField() {
        searchBar.clickOnDestination();
    }

    public void clickOnSearch() {
        searchBar.clickOnSearch();
        DriverHelperUtil.waitForPage();
    }

    public void clickOnCheckInDate() {
        searchBar.clickOnCheckInField();
    }

    public void clickOnCheckOutDate() {
        searchBar.clickOnCheckOutField();
    }

    public void selectDate(String date) {
        calendarPanel.selectDate(date);
    }

    public void clickOnGuests() {
        searchBar.clickOnGuestsField();
    }

    public void addGuestsBasedOnRequiredNumberAndType(int numberOfGuests, String guestType) {
        ExecutionContext.addOrIncreaseNumberForKey(numberOfGuests, GUESTS);
        for (int i = 1; i <= numberOfGuests; i++) {
            if (Objects.equals(guestType, "Adults") || Objects.equals(guestType, "Adult")) {
                guestsPanel.addAdult();
            } else if (Objects.equals(guestType, "Children") || Objects.equals(guestType, "Child"))
                guestsPanel.addChild();
        }
    }

    public void selectDateAfterDays(String inOrOut, int days) {
        String date = textUtils.getFutureDateInFormat(days);
        calendarPanel.selectDate(date);
        if (inOrOut.equals("In"))
            ExecutionContext.put(CHECK_IN_DATE, date);
        else if (inOrOut.equals("Out"))
            ExecutionContext.put(CHECK_OUT_DATE, date);
    }

    public boolean validateSearchBar() {
        littleSearchBar.clickOnSearchDate();
        return (searchBar.validateDestination(ExecutionContext.get(DESTINATION).toString())
                && searchBar.validateCheckInDate(textUtils.getDateInMonthFormat(ExecutionContext.get(CHECK_IN_DATE).toString()))
                && searchBar.validateCheckOutDate(textUtils.getDateInMonthFormat(ExecutionContext.get(CHECK_OUT_DATE).toString()))
                && searchBar.validateGuestsNumber(ExecutionContext.get(GUESTS).toString() + " guests")
        );
    }
}
