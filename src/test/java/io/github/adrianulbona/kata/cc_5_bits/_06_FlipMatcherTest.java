package io.github.adrianulbona.kata.cc_5_bits;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class _06_FlipMatcherTest {

    @Test
    void apply() {

        final BiFunction<Integer, Integer, Integer> matcher = new _06_FlipMatcher();

        final int source = 0b11101;
        final int target = 0b01111;

        assertEquals(2, matcher.apply(source, target));
    }
}