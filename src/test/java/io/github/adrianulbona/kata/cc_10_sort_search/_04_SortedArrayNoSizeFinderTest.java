package io.github.adrianulbona.kata.cc_10_sort_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_10_sort_search._04_SortedArrayNoSizeFinder.*;
import static org.junit.jupiter.api.Assertions.*;

class _04_SortedArrayNoSizeFinderTest {

    private BiFunction<Listy, Integer, Integer> finder;

    @BeforeEach
    void setUp() {
        this.finder = new _04_SortedArrayNoSizeFinder();
    }

    @Test
    void apply() {
        final Listy listy = new Listy(new int[]{1, 2, 3, 4, 5, 100, 10000, 2000000});

        assertEquals(6, this.finder.apply(listy, 10000));
    }
}
