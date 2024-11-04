package enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DatePatterns {
    MM_DD_YYYY("MM/dd/yyyy"),
    MMM_D("MMM d");

    public final String pattern;
}
