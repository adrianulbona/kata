package io.github.adrianulbona.kata.cc_10_sort_search;

import java.util.function.BiFunction;

public class _03_RotatedArrayFinder implements BiFunction<int[], Integer, Integer> {

    @Override
    public Integer apply(int[] ints, Integer el) {
        final int rotationPoint = rotationPoint(ints, 0, ints.length);
        if (ints[0] <= el) {
            return binarySearch(ints, 0, rotationPoint, el);
        }
        return binarySearch(ints, rotationPoint + 1, ints.length, el);
    }

    private int rotationPoint(int[] ints, int start, int end) {
        if (end == start + 1) {
            return start;
        }
        final int middle = (end + start) / 2;
        if (ints[start] > ints[middle]) {
            return rotationPoint(ints, start, middle);
        }
        return rotationPoint(ints, middle, end);
    }

    private int binarySearch(int[] ints, int start, int end, int el) {
        if (ints[start] == el) {
            return start;
        }

        final int middle = (end + start) / 2;
        if (el < ints[middle]) {
            return binarySearch(ints, start, middle, el);
        }
        return binarySearch(ints, middle, end, el);
    }
}
