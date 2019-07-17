package io.github.adrianulbona.kata.cc_1_arrays_strings;

import java.util.Arrays;
import java.util.function.BiPredicate;

public class _02_StringPermutationChecker implements BiPredicate<char[], char[]> {

    @Override
    public boolean test(char[] s1, char[] s2) {
        Arrays.sort(s1); // mutates the original array
        Arrays.sort(s2); // mutates the original array
        return Arrays.equals(s1, s2);
    }
}
