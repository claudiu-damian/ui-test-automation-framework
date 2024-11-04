package utils;

import com.google.common.collect.Comparators;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionsUtil {
    private static final String ASC = "ASC";
    private static final String DESC = "DESC";

    public static <K> HashMap<Integer, K> sortMapByKey(HashMap<Integer, K> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    public static <K> List<K> getListFromMap(Map<Integer, K> map) {
        return new ArrayList<>(map.values());
    }

    public static boolean isStringListOrdered(List<String> list, String order) {
        boolean isOrdered = false;
        if (order.equalsIgnoreCase(ASC))
            isOrdered = Comparators.isInOrder(list, Comparator.naturalOrder());
        else if (order.equalsIgnoreCase(DESC))
            isOrdered = Comparators.isInOrder(list, Comparator.reverseOrder());
        return isOrdered;
    }

    public static boolean isDoubleListOrdered(List<Double> list, String order) {
        boolean isOrdered = false;
        if (order.equalsIgnoreCase(ASC))
            isOrdered = Comparators.isInOrder(list, Comparator.naturalOrder());
        else if (order.equalsIgnoreCase(DESC))
            isOrdered = Comparators.isInOrder(list, Comparator.reverseOrder());
        return isOrdered;
    }
}
