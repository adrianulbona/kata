package io.github.adrianulbona.kata.cc_1_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

class _05_OneAwayCheckerTest {

    private BiPredicate<String, String> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _05_OneAwayChecker();
    }

    @Test
    void testZeroEdits() {
        assertTrue(this.checker.test("pale", "pale"));
    }

    @Test
    void testValidReplace() {
        assertTrue(this.checker.test("pale", "pane"));
    }

    @Test
    void testInvalidReplace() {
        assertFalse(this.checker.test("pale", "bane"));
    }

    @Test
    void testValidInsert() {
        assertTrue(this.checker.test("pale", "paled"));
    }

    @Test
    void testValidDelete() {
        assertTrue(this.checker.test("pale", "pal"));
    }
}