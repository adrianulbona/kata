package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _06_SuccessorFinderTest {

    @Test
    void apply1Node() {
        final Function<Node, Node> finder = new _06_SuccessorFinder();

        assertEquals(NIL, finder.apply(node(1)));
    }

    @Test
    void applyChildParent() {
        final Function<Node, Node> finder = new _06_SuccessorFinder();

        final Node node_1 = node(1);
        final Node node_2 = node(2, node_1, NIL);

        assertEquals(node_2, finder.apply(node_1));
    }


    @Test
    void applyChildGrandParent() {
        final Function<Node, Node> finder = new _06_SuccessorFinder();

        final Node node_1 = node(1);
        final Node node_3 = node(3);
        final Node node_2 = node(2, node_1, node_3);
        final Node node_5 = node(5, node_2, NIL);

        assertEquals(node_5, finder.apply(node_3));
    }

}