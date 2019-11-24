package com.diary.backend.utils;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {


    public static String nullToEmpty(String value) {
        return value == null ? "" : value;
    }

    public static boolean hasValue(String value) {
        return value != null && value.length() > 0;
    }

    public static String truncate(String value, int length) {
        if (hasValue(value)) {
            value = value.trim();
            return value.substring(0, Math.min(value.length(), length));
        } else {
            return "";
        }
    }

    public static List nullToEmptyListOfString(List<String> value) {
        return (List)(value == null ? new ArrayList() : value);
    }

    public static boolean hasValueListOfString(List<String> value) {
        return value != null && !value.isEmpty();
    }
}
