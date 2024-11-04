package component.airbnb;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import static enums.LocatorConstants.COLOR_SELECTED_PROPERTY_CSS;
import static enums.LocatorConstants.STYLE_CSS_ATTRIBUTE;

@FindBy(css = "[class*='atm_e2_11wdtgu']")
public class MapComponent extends HtmlElement {

    @FindBy(css = "[style*='transform: scale(1.077); ']>div")
    private WebElement hoveredProperty;

    public boolean checkThatPropertyIsHovered() {
        return hoveredProperty.isDisplayed() && hoveredProperty.getAttribute(STYLE_CSS_ATTRIBUTE.value)
                .contains(COLOR_SELECTED_PROPERTY_CSS.value);
    }

    public void clickOnHoveredProperty() {
        hoveredProperty.click();
    }
}
