package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class _03_SpaceReplacerTest {

    private Function<char[], char[]> replacer;

    @BeforeEach
    void setUp() {
        this.replacer = new _03_SpaceReplacer();
    }

    @Test
    void applyEmpty() {
        assertArrayEquals("".toCharArray(), this.replacer.apply("".toCharArray()));
    }

    @Test
    void applyNonSpace() {
        assertArrayEquals("abc".toCharArray(), this.replacer.apply("abc".toCharArray()));
    }

    @Test
    void applyMultipleSpaces() {
        assertArrayEquals("%20ab%20c%20".toCharArray(), this.replacer.apply(" ab c       ".toCharArray()));
    }
}