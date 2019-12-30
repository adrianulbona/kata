package io.github.adrianulbona.kata.cc_10_sort_search;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class _03_RotatedArrayFinder implements BiFunction<int[], Integer, Integer> {

    @Override
    public Integer apply(int[] ints, Integer el) {
        if (ints[0] < ints[ints.length - 1]) {
            return binarySearch(ints, 0, ints.length, el);
        }

        final int rotationPoint = rotationPoint(ints, 0, ints.length);
        if (ints[0] <= el) {
            return binarySearch(ints, 0, rotationPoint, el);
        }
        return binarySearch(ints, rotationPoint, ints.length, el);
    }

    private int rotationPoint(int[] ints, int start, int end) {
        if (start > end) {
            throw new NoSuchElementException();
        }

        if (end == start + 1) {
            return end;
        }
        final int middle = (end + start) / 2;
        if (ints[start] > ints[middle]) {
            return rotationPoint(ints, start, middle);
        }
        return rotationPoint(ints, middle, end);
    }

    private int binarySearch(int[] ints, int start, int end, int el) {
        if (start > end) {
            throw new NoSuchElementException();
        }

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
