package io.github.adrianulbona.kata.cc_5_bits;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _07_PairWiseSwapperTest {

    @Test
    void apply() {
        final Function<Integer, Integer> swapper = new _07_PairWiseSwapper();

        assertEquals(0b10_0111_0110, swapper.apply(0b01_1011_1001));
    }
}