package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class _05_MultiplierTest {

    private BiFunction<Integer, Integer, Integer> multiplier;

    @BeforeEach
    void setUp() {
        this.multiplier = new _05_Multiplier();
    }

    @Test
    void applyZero() {
        assertEquals(0, this.multiplier.apply(100, 0));
    }

    @Test
    void applyOne() {
        assertEquals(100, this.multiplier.apply(100, 1));
    }

    @Test
    void apply123x20() {
        assertEquals(2460, this.multiplier.apply(123, 20));
    }
}
