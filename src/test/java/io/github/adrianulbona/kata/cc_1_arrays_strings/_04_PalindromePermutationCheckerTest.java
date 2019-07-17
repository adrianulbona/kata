package io.github.adrianulbona.kata.cc_1_arrays_strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class _04_PalindromePermutationCheckerTest {

    private Predicate<String> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _04_PalindromePermutationChecker();
    }

    @Test
    void testEmpty() {
        assertTrue(this.checker.test(""));
    }

    @Test
    void testNotPalindrome() {
        assertFalse(this.checker.test("abc"));
    }

    @Test
    void testPalindrome() {
        assertTrue(this.checker.test("ab  a"));
    }

    @Test
    void testPalindromeThreeSpaces() {
        assertTrue(this.checker.test("ab   a"));
    }
}