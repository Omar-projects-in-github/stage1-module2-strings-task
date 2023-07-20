package com.epam.mjc;

import java.util.*;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        List<String> result = new ArrayList<>();
        result.add(source);

        for (String delimiter : delimiters) {
            List<String> tempResult = new ArrayList<>();
            for (String str : result) {
                String[] parts = str.split(delimiter);
                tempResult.addAll(Arrays.asList(parts));
            }
            result = tempResult;
        }
        result.removeIf(String::isEmpty);

        return result;
    }
}
