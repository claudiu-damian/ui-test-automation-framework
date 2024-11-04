package utils;

import enums.context_keys.Data;
import enums.context_keys.Keys;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Thread.currentThread;

public class ExecutionContext {
    private static final HashMap<Long, HashMap<Keys, Object>> map = new HashMap<>();

    private static HashMap<Keys, Object> getCurrentThreadMap() {
        return map.get(currentThread().getId());
    }

    public static Object get(Keys key) {
        return getCurrentThreadMap().get(key);
    }

    public static void put(Keys key, Object value) {
        if (map.containsKey(currentThread().getId())) {
        } else {
            map.put(currentThread().getId(), new HashMap<>());
        }
        getCurrentThreadMap().put(key, value);
    }

    public static Object remove(Keys key) {
        return getCurrentThreadMap().remove(key);
    }

    public static void clear() {
        getCurrentThreadMap().clear();
    }

    public static Set<Map.Entry<Keys, Object>> entrySet() {
        return getCurrentThreadMap().entrySet();
    }

    public static void removeFromGeneralMap(Long threadID) {
        map.remove(threadID);
    }

    public static void clearGeneralMap() {
        map.clear();
    }

    public static void addOrIncreaseNumberForKey(int number, Data key) {
        if (ExecutionContext.get(key) != null)
            ExecutionContext.put(key, Integer.parseInt(ExecutionContext.get(key).toString()) + number);
        else ExecutionContext.put(key, number);
    }
}
