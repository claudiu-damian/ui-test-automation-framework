package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LocatorConstants {
    ARIA_LABEL_BY_PROPERTY("aria-labelledby"),
    VALUE_CSS_ATTRIBUTE("value"),
    STYLE_CSS_ATTRIBUTE("style"),
    DATA_SELECTOR("[data-testid='%s'"),
    COLOR_SELECTED_PROPERTY_CSS("color: var(--linaria-theme_palette-white)"),
    ARIA_LABEL_BY_SELECTOR("[aria-labelledby=%s]"),
    RESULT_PAGE_PROPERTY_TITLE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='listing-card-title']"),
    RESULT_PAGE_PROPERTY_SUBTITLE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='listing-card-subtitle']"),
    RESULT_PAGE_PROPERTY_PRICE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='price-availability-row']>div>div>div>span[class='_1qgfaxb1']"),
    MAP_PROPERTY_TITLE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-title']"),
    MAP_PROPERTY_SUBTITLE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-subtitle']"),
    MAP_PROPERTY_PRICE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>[class*='b1lki7m']"),
    PROPERTY_CARD_CONTAINER_SELECTOR("[data-testid='card-container']"),
    TRANSLATION_MODAL_SELECTOR("[data-testid='translation-announce-modal']"),
    CLOSE_BUTTON_SELECTOR("[aria-label='Close']");

    public final String value;
}
