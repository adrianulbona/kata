package io.github.adrianulbona.kata.cc_05_bits;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class _05_Pow2CheckerTest {

    @Test
    void test() {
        final Predicate<Integer> checker = new _05_Pow2Checker();

        assertTrue(checker.test(2));
        assertTrue(checker.test(4));
        assertTrue(checker.test(8));
        assertTrue(checker.test(16));
        assertTrue(checker.test(32));

        assertFalse(checker.test(3));
        assertFalse(checker.test(7));
        assertFalse(checker.test(12));
        assertFalse(checker.test(3143243));
    }
}