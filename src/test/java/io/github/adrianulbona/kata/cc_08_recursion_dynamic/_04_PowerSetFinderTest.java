package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _04_PowerSetFinderTest {

    private Function<Set<Integer>, Set<Set<Integer>>> finder;

    @BeforeEach
    void setUp() {
        this.finder = new _04_PowerSetFinder();
    }

    @Test
    void applyEmpty() {
        assertEquals(Set.of(Set.of()), this.finder.apply(Set.of()));
    }

    @Test
    void applySingletonSet() {
        assertEquals(Set.of(Set.of(), Set.of(1)), this.finder.apply(Set.of(1)));
    }

    @Test
    void applySet3Elements() {
        final Set<Set<Integer>> expected = Set.of(
                Set.of(),
                Set.of(1), Set.of(2), Set.of(3),
                Set.of(1, 2), Set.of(2, 3), Set.of(1, 3),
                Set.of(1, 2, 3));
        assertEquals(expected, this.finder.apply(Set.of(1, 2, 3)));
    }
}