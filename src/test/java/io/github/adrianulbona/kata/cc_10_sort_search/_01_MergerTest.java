package io.github.adrianulbona.kata.cc_10_sort_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class _01_MergerTest {

    private BiConsumer<int[], int[]> merger;

    @BeforeEach
    void setUp() {
        this.merger = new _01_Merger();
    }

    @Test
    void accept() {
        final int[] a = new int[]{2, 4, 6, 8, 0, 0, 0, 0};
        final int[] b = new int[]{1, 3, 5, 7};

        this.merger.accept(a, b);

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, a);
    }


    @Test
    void acceptAEmpty() {
        final int[] a = new int[]{0, 0, 0, 0};
        final int[] b = new int[]{1, 3, 5, 7};

        this.merger.accept(a, b);

        assertArrayEquals(new int[]{1, 3, 5, 7}, a);
    }

    @Test
    void acceptBEmpty() {
        final int[] a = new int[]{2, 4, 6, 8};
        final int[] b = new int[]{};

        this.merger.accept(a, b);

        assertArrayEquals(new int[]{2, 4, 6, 8}, a);
    }
}