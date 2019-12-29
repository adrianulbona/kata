package io.github.adrianulbona.kata.cc_10_sort_search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _02_AnagramsSorterTest {

    private Function<List<String>, List<String>> sorter;

    @BeforeEach
    void setUp() {
        this.sorter = new _02_AnagramsSorter();
    }

    @Test
    void apply() {
        final List<String> anagrams = List.of("aab", "bba", "abc", "bca", "ddd", "aba");
        final List<String> expected = List.of("aab", "aba", "bba", "abc", "bca", "ddd");

        assertEquals(expected, this.sorter.apply(anagrams));
    }
}
