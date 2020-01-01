package io.github.adrianulbona.kata.cc_10_sort_search;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public class _05_SparseSearch implements BiFunction<String[], String, Integer> {

    @Override
    public Integer apply(String[] sparseArray, String el) {

        return apply(sparseArray, 0, sparseArray.length, el);
    }

    private Integer apply(String[] sparseArray, int start, int end, String el) {
        if (start > end) {
            throw new NoSuchElementException();
        }

        if (sparseArray[start].equals(el)) {
            return start;
        }

        final int nonEmptyMiddle = nonEmptyMiddle(sparseArray, start, end);
        if (sparseArray[nonEmptyMiddle].compareTo(el) > 0) {
            return apply(sparseArray, start, nonEmptyMiddle, el);
        }
        return apply(sparseArray, nonEmptyMiddle, end, el);
    }

    private int nonEmptyMiddle(String[] sparseArray, int start, int end) {
        int middle = start + end / 2;

        int offset = 0;
        while (sparseArray[middle + offset].isEmpty() && sparseArray[middle - offset].isEmpty() ) {
            offset++;
        }

        if (sparseArray[middle + offset].isEmpty()) {
            offset = -offset;
        }

        return middle + offset;
    }
}
