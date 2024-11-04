package utils;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static enums.DatePatterns.MMM_D;
import static enums.DatePatterns.MM_DD_YYYY;
import static enums.LocatorConstants.DATA_SELECTOR;

@NoArgsConstructor
public class TextUtils {
    public static Integer getIntegerFromString(String text) {
        return Integer.valueOf(text.replaceAll("[^0-9]", ""));
    }

    public static Double getDoubleFromString(String text) {
        double d = 0.0;
        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(text);
        while (m.find()) {
            d = Double.parseDouble(m.group(1));
        }
        return d;
    }

    public String createCSSSelectorWithDataTestID(String attributeValue) {
        return String.format(DATA_SELECTOR.value, attributeValue);
    }

    public String getFutureDateInFormat(int plusDays) {
        return LocalDate.now().plusDays(plusDays)
                .format(DateTimeFormatter
                        .ofPattern(MM_DD_YYYY.pattern));
    }

    public String getDateInMonthFormat(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(MM_DD_YYYY.pattern))
                .format(DateTimeFormatter.ofPattern(MMM_D.pattern));
    }
}
