package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _03_MagicIndexFinderTest {

    private Function<List<Integer>, Optional<Integer>> finder;

    @BeforeEach
    void setUp() {
        this.finder = new _03_MagicIndexFinder();
    }

    @Test
    void applyEmpty() {
        assertEquals(Optional.empty(), this.finder.apply(List.of()));
    }

    @Test
    void apply0() {
        assertEquals(Optional.of(0), this.finder.apply(List.of(0)));
    }

    @Test
    void apply2() {
        assertEquals(Optional.of(2), this.finder.apply(List.of(-200, -20, 2, 20, 200)));
    }

    @Test
    void apply10() {
        assertEquals(Optional.of(10), this.finder.apply(List.of(-10, -8, 1, 2, 3, 4, 5, 6, 7, 8, 10, 20, 30)));
    }
}
