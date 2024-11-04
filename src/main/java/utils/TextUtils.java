package utils;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class TextUtils {
    public static Integer getIntegerFromString(String text) {
        return Integer.valueOf(text.replaceAll("[^0-9]", ""));
    }

    public static Double getDoubleFromString(String text) {
        double d = 0.0;
        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(text);
        while (m.find())
        {
            d = Double.parseDouble(m.group(1));
        }
        return d;
    }

    public String createCSSSelectorWithDataTestID(String attributeValue) {
        return "[data-testid='"+ attributeValue +"']";
    }

    public String getFutureDateInFormat(int plusDays) {
        return LocalDate.now().plusDays(plusDays)
                .format(DateTimeFormatter
                        .ofPattern("MM/dd/yyyy"));
    }

    public String xpathWithClassNameAndTextCreator(String className, String text) {
        return "//div[@class='" + className + "' and contains(., '" + text + "')]";
    }

    public String getDateInMonthFormat(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("MM/dd/yyyy")).format(DateTimeFormatter.ofPattern("MMM d"));
    }
}
