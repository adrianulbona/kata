package io.github.adrianulbona.kata.cc_04_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _10_SubTreeCheckerTest {

    @Test
    void testSameTree() {
        final BiPredicate<Node, Node> checker = new _10_SubTreeChecker();

        final Node tree = node(2, node(1), node(3));

        assertTrue(checker.test(tree, tree));
    }

    @Test
    void testDifferentTrees() {
        final BiPredicate<Node, Node> checker = new _10_SubTreeChecker();

        final Node tree_1 = node(2, node(1), node(3));
        final Node tree_2 = node(2, node(1), node(4));

        assertFalse(checker.test(tree_1, tree_2));
    }


    @Test
    void testSubTree() {
        final BiPredicate<Node, Node> checker = new _10_SubTreeChecker();

        final Node child = node(10, node(9), node(11));
        final Node tree =
                node(5,
                        node(3,
                                node(2),
                                node(4)),
                        node(6,
                                NIL,
                                node(10,
                                        node(9),
                                        node(11))));

        assertTrue(checker.test(child, tree));
    }

}