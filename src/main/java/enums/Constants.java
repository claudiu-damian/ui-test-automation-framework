package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Constants {
    ARIA_LABEL_BY_PROPERTY("aria-labelledby"),
    ARIA_LABEL_BY_SELECTOR("[aria-labelledby=%s]"),
    RESULT_PAGE_PROPERTY_TITLE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='listing-card-title']"),
    RESULT_PAGE_PROPERTY_SUBTITLE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='listing-card-subtitle']"),
    RESULT_PAGE_PROPERTY_PRICE_SELECTOR("%s>div[class*='l1tup9az']>div[class*='jk atm_e0_1lo05zz']>div[data-testid='price-availability-row']>div>div>div>span[class='_1qgfaxb1']"),
    MAP_PROPERTY_TITLE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-title']"),
    MAP_PROPERTY_SUBTITLE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>div[data-testid='listing-card-subtitle']"),
    MAP_PROPERTY_PRICE_SELECTOR("%s>div>div[class*='atm_l8_y1qneu']>[class*='b1lki7m']");


    public final String constant;
}
