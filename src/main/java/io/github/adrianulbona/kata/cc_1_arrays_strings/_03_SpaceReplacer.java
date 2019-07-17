package io.github.adrianulbona.kata.cc_1_arrays_strings;

import java.util.function.Function;

import static java.util.stream.IntStream.range;

public class _03_SpaceReplacer implements Function<char[], char[]> {

    @Override
    public char[] apply(char[] chars) {
        range(0, chars.length).forEach(index -> {
            if (chars[index] == ' ') {
                shiftToTheRightTwice(chars, index + 1);
                insertEncodedSpace(chars, index);
            }
        });
        return chars;
    }

    private void insertEncodedSpace(char[] chars, int index) {
        chars[index] = '%';
        chars[index + 1] = '2';
        chars[index + 2] = '0';
    }

    private void shiftToTheRightTwice(char[] chars, int offset) {
        final int charsToShift = chars.length - offset - 2; // last two are dropped
        range(0, charsToShift).forEach(i -> {
            int source = chars.length - 1 - i - 2;
            int dest = chars.length - 1 - i;
            chars[dest] = chars[source];
        });
    }
}
