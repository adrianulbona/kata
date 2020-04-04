package io.github.adrianulbona.kata.cc_10_sort_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _03_RotatedArrayFinderTest {

    private BiFunction<int[], Integer, Integer> finder;

    @BeforeEach
    void setUp() {
        this.finder = new _03_RotatedArrayFinder();
    }

    @Test
    void apply() {
        final int[] ints = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};

        assertEquals(8, this.finder.apply(ints, 5));
    }

    @Test
    void applySorted() {
        final int[] ints = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25};

        assertEquals(3, this.finder.apply(ints, 5));
    }
}
