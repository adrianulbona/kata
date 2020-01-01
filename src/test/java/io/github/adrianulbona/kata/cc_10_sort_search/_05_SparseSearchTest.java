package io.github.adrianulbona.kata.cc_10_sort_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class _05_SparseSearchTest {

    private BiFunction<String[], String, Integer> search;

    @BeforeEach
    void setUp() {
        this.search = new _05_SparseSearch();
    }

    @Test
    void apply() {
        final String[] sparseArray = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};

        assertEquals(4, this.search.apply(sparseArray, "ball"));
    }
}