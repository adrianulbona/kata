package io.github.adrianulbona.kata.cc_05_bits;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _03_BitFlipperTest {

    @Test
    void applySingleGaps() {
        final Function<Integer, Integer> flipper = new _03_BitFlipper();

        assertEquals(8, flipper.apply(0b1110_1110_1111));
    }

    @Test
    void applyDoubleGap() {
        final Function<Integer, Integer> flipper = new _03_BitFlipper();

        assertEquals(7, flipper.apply(0b1110_1110_0111));
    }
}
