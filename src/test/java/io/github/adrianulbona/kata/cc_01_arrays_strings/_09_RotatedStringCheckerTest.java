package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

class _09_RotatedStringCheckerTest {

    private BiPredicate<String, String> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _09_RotatedStringChecker();
    }

    @Test
    void testEmpty() {
        assertTrue(this.checker.test("", ""));
    }

    @Test
    void testRotated() {
        assertTrue(this.checker.test("bottlewatter", "terbottlewat"));
    }

    @Test
    void testNotRotated() {
        assertFalse(this.checker.test("bottlewatter", "terbottlewah"));
    }

    @Test
    void testDifferentLenghts() {
        assertFalse(this.checker.test("bottlewatteraaaa", "terbottlewat"));
    }
}