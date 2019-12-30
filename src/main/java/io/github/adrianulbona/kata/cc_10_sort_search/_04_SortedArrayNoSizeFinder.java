package io.github.adrianulbona.kata.cc_10_sort_search;

import lombok.Data;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_10_sort_search._04_SortedArrayNoSizeFinder.Listy;

public class _04_SortedArrayNoSizeFinder implements BiFunction<Listy, Integer, Integer> {

    @Override
    public Integer apply(Listy listy, Integer el) {
        return apply(listy, 0, Integer.MAX_VALUE, el);
    }

    private int apply(Listy listy, int start, int end, int el) {
        final int current = listy.elementAt(start);
        if (current == el) {
            return start;
        }

        final int middle = (start + end) / 2;

        if (listy.elementAt(middle) == -1 || listy.elementAt(middle) > el) {
            return apply(listy, start, middle, el);
        }

        return apply(listy, middle, end, el);
    }

    @Data
    static class Listy {
        private final int[] data;

        int elementAt(int index) {
            if (index >= data.length) {
                return -1;
            }
            return data[index];
        }
    }
}
