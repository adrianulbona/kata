package io.github.adrianulbona.kata.cc_1_arrays_strings;

import java.util.function.BiPredicate;
import java.util.stream.IntStream;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.IntStream.range;

public class _5_OneAwayChecker implements BiPredicate<String, String> {

    @Override
    public boolean test(String original, String edited) {
        switch (EditType.on(original, edited)) {
            case REPLACE:
                return validReplace(original, edited);
            case INSERT:
                return validInsert(original, edited);
            case DELETE:
                return validInsert(edited, original);
            case UNKNOWN:
            default:
                return false;
        }
    }

    private boolean validInsert(String original, String edited) {
        final int indexOfInsert = indexOfFirstDifferent(original, edited);
        final boolean sameBeforeInsert = range(0, indexOfInsert)
                .allMatch(index -> original.charAt(index) == edited.charAt(index));
        final boolean sameAfterInsert = range(indexOfInsert + 1, original.length())
                .allMatch(index -> original.charAt(index) == edited.charAt(index + 1));
        return sameBeforeInsert && sameAfterInsert;
    }

    private int indexOfFirstDifferent(String s1, String s2) {
        return range(0, min(s1.length(), s2.length()))
                .filter(index -> s1.charAt(index) != s2.charAt(index))
                .findFirst()
                .orElse(max(s1.length(), s2.length()) - 1);
    }

    private boolean validReplace(String original, String edited) {
        final long differentChars = range(0, original.length())
                .filter(index -> original.charAt(index) != edited.charAt(index))
                .count();
        return differentChars < 2;
    }

    private enum EditType {
        INSERT, DELETE, REPLACE, UNKNOWN;

        static EditType on(String original, String edited) {
            final int originalLength = original.length();
            final int editedLength = edited.length();
            if (originalLength == editedLength) {
                return REPLACE;
            }
            if (originalLength == editedLength + 1) {
                return INSERT;
            }
            if (originalLength == editedLength - 1) {
                return DELETE;
            }
            return UNKNOWN;
        }
    }
}
