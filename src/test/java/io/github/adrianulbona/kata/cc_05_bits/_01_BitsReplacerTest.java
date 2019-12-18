package io.github.adrianulbona.kata.cc_05_bits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _01_BitsReplacerTest {

    @Test
    void apply() {
        final _01_BitsReplacer replacer = new _01_BitsReplacer();
        assertEquals(0b100_0100_1100, replacer.apply(0b1_0011, 0b100_0000_0000, 6, 2));
    }
}