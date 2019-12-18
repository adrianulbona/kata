package io.github.adrianulbona.kata.cc_02_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static io.github.adrianulbona.kata.cc_02_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_02_lists.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _07_IntersectionCheckerTest {

    private BiPredicate<Node, Node> checker;

    @BeforeEach
    void setUp() {
        this.checker = new _07_IntersectionChecker();
    }

    @Test
    void testNILandNIL() {
        assertFalse(this.checker.test(NIL, NIL));
    }

    @Test
    void test123and456() {
        assertFalse(this.checker.test(node(1, node(2, node(3))), node(4, node(5, node(6)))));
    }

    @Test
    void test123and423() {
        final Node intersection = node(2, node(3));
        assertTrue(this.checker.test(node(1, intersection), node(4, intersection)));
    }
}
