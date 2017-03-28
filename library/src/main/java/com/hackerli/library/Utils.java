package com.hackerli.library;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoXier on 17-3-27.
 */

class Utils {

    static List<String> parse(String s) {
        String[] strings = s.split("\n");
        ArrayList<String> result = new ArrayList<>();
        for (String item : strings) {
            result.addAll(parseToList(item));
            result.add("\n");
        }
        return result;
    }

    private static List<String> parseToList(String s) {
        int start = 0;
        int end = 0;

        ArrayList<String> list = new ArrayList<>();
        list.add("  ");
        while (end < s.length()) {
            char c = s.charAt(end);
            while (c != ' ' && c != '.' && c != ',' && c != '!' && c != '?' && c != '"' && c != ':') {
                end++;
                if (end == s.length()) break;
                c = s.charAt(end);
            }
            if (end < s.length() && s.charAt(end) != ' ') {
                list.add(s.substring(start, end + 1 > s.length() ? s.length() : end + 1));
            } else if(end > start){
                list.add(s.substring(start, end));
            }
            end++;
            start = end;
        }
        return list;
    }

}
