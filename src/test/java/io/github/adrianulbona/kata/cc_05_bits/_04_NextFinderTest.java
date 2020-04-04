package io.github.adrianulbona.kata.cc_05_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _04_NextFinderTest {

    @Test
    void greater() {
        final _04_NextFinder finder = new _04_NextFinder();

        assertEquals(0b0001_0000_0111, finder.greater(0b0000_1111_0000));
        assertEquals(0b0000_0001_0111, finder.greater(0b0000_0000_1111));
    }

    @Test
    void smaller() {
        final _04_NextFinder finder = new _04_NextFinder();

        assertEquals(0b0000_1110_1000, finder.smaller(0b0000_1111_0000));
        assertEquals(0b0000_0001_1101, finder.smaller(0b0000_0001_1110));
    }
}
