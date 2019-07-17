package io.github.adrianulbona.kata.cc_1_arrays_strings;

import java.util.Arrays;
import java.util.function.Predicate;

import static java.util.stream.IntStream.range;

public class _01_UniqueCharsChecker implements Predicate<char[]> {

    @Override
    public boolean test(char[] chars) {
        Arrays.sort(chars); // mutates the original array
        return range(0, chars.length - 1)
                .noneMatch(index -> chars[index] == chars[index + 1]);
    }
}
