package io.github.adrianulbona.kata.cc_01_arrays_strings;

import java.util.function.BiPredicate;

import static java.util.stream.IntStream.range;

public class _09_RotatedStringChecker implements BiPredicate<String, String> {

    @Override
    public boolean test(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        return s1.length() == 0 ||
                range(0, s2.length())
                        .anyMatch(offset -> s2.substring(offset).concat(s2.substring(0, offset)).equals(s1));
    }
}
