package com.epam.mjc;

import java.util.*;
import java.util.stream.Collectors;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
        StringJoiner joiner = new StringJoiner("|");

        for (String delimiter : delimiters) {
            joiner.add(delimiter);
        }

        String regex = joiner.toString();

        String[] substrings = source.split(regex);
        return Arrays.stream(substrings)
                .filter(s -> !s.isEmpty()) // Filter out empty substrings
                .collect(Collectors.toList());
    }
}
