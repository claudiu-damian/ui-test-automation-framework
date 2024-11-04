package component.airbnb;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

@FindBy(css = "[class*='atm_vy_16ji443__oggzyc drp3lcp']")
public class AmenitiesPopUp extends HtmlElement {

    @FindBy(css = "[id*='pdp_v3_parking_facilities_7'][id*='row-title']")
    private HtmlElement poolAmenity;

    public boolean checkIfPoolAmenityIsPresent() {
        return poolAmenity.isDisplayed();
    }
}
