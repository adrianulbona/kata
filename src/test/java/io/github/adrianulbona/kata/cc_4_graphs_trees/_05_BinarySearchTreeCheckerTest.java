package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _05_BinarySearchTreeCheckerTest {

    @Test
    void test1Node() {
        final Predicate<Node> checker = new _05_BinarySearchTreeChecker();

        assertTrue(checker.test(node(1)));
    }

    @Test
    void testBST() {
        final Predicate<Node> checker = new _05_BinarySearchTreeChecker();

        final Node tree = node(4, node(2, node(1), node(3)), node(6, node(5), node(7)));
        assertTrue(checker.test(tree));
    }

    @Test
    void testNotBST1() {
        final Predicate<Node> checker = new _05_BinarySearchTreeChecker();

        final Node tree = node(4, node(2, node(10), node(3)), node(6, node(5), node(7)));
        assertFalse(checker.test(tree));
    }

    @Test
    void testNotBST2() {
        final Predicate<Node> checker = new _05_BinarySearchTreeChecker();

        final Node tree = node(4, node(2, node(1), node(10)), node(6, node(5), node(7)));
        assertFalse(checker.test(tree));
    }

}