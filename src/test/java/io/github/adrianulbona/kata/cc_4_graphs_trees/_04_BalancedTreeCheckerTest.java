package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _04_BalancedTreeCheckerTest {

    @Test
    void test1Level() {
        final Predicate<Node> checker = new _04_BalancedTreeChecker();

        assertTrue(checker.test(node(1)));
    }

    @Test
    void testBalanced() {
        final Predicate<Node> checker = new _04_BalancedTreeChecker();

        final Node tree = node(4, node(2, node(1), node(3)), node(6, node(5), node(7)));
        assertTrue(checker.test(tree));
    }

    @Test
    void testUnbalanced() {
        final Predicate<Node> checker = new _04_BalancedTreeChecker();

        final Node tree = node(4, node(2, node(1), node(3)), NIL);
        assertFalse(checker.test(tree));
    }
}
