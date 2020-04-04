package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _06_StringCompressorTest {

    private Function<String, String> compressor;

    @BeforeEach
    void setUp() {
        this.compressor = new _06_StringCompressor();
    }

    @Test
    void applyEmpty() {
        assertEquals("", compressor.apply(""));
    }

    @Test
    void applyCompressible() {
        assertEquals("a3b5c2", compressor.apply("aaabbbbbcc"));
    }

    @Test
    void applyNotCompressible() {
        assertEquals("abc", compressor.apply("abc"));
    }
}
