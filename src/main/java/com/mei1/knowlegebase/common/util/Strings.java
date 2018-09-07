package com.mei1.knowlegebase.common.util;

public class Strings {

    public static String humpToSnake(String text) {
        char[] charArray = text.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (Character.isUpperCase(c)) {
                sb.append("_");
            }
            sb.append(String.valueOf(c).toLowerCase());
        }
        return sb.toString();
    }

}
