package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class _01_UniqueCharsCheckerTest {

    private Predicate<char[]> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _01_UniqueCharsChecker();
    }

    @Test
    void testEmpty() {
        assertTrue(this.checker.test("".toCharArray()));
    }

    @Test
    void testUnique() {
        assertTrue(this.checker.test("abc".toCharArray()));
    }

    @Test
    void testNonUnique() {
        assertFalse(this.checker.test("abca".toCharArray()));
    }
}
