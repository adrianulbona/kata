package io.github.adrianulbona.kata.cc_01_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

class _02_StringPermutationCheckerTest {

    private BiPredicate<char[], char[]> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _02_StringPermutationChecker();
    }

    @Test
    void testEmptyPermutationOfEmpty() {
        assertTrue(checker.test("".toCharArray(), "".toCharArray()));
    }

    @Test
    void testDifferentLengths() {
        assertFalse(checker.test("".toCharArray(), "a".toCharArray()));
    }

    @Test
    void testSameLengthsPermutation() {
        assertTrue(checker.test("abc".toCharArray(), "bca".toCharArray()));
    }

    @Test
    void testSameLengthsNotPermutation() {
        assertFalse(checker.test("abc".toCharArray(), "bcd".toCharArray()));
    }
}
