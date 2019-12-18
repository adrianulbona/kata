package io.github.adrianulbona.kata.cc_02_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static io.github.adrianulbona.kata.cc_02_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_02_lists.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _06_PalindromeCheckerTest {

    private Predicate<Node> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _06_PalindromeChecker();
    }

    @Test
    void testNil() {
        assertTrue(this.checker.test(NIL));
    }

    @Test
    void testPalindrome() {
        assertTrue(this.checker.test(node(1, node(2, node(1)))));
    }

    @Test
    void testNotPalindrome() {
        assertFalse(this.checker.test(node(1, node(2, node(3)))));
    }
}
