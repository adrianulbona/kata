package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _08_FirstCommonAncestorTest {

    @Test
    void applySameNode() {
        final BiFunction<Node, Node, Node> ancestorFinder = new _08_FirstCommonAccestor();

        final Node node = node(1);

        assertEquals(node, ancestorFinder.apply(node, node));
    }

    @Test
    void applyChildParent() {
        final BiFunction<Node, Node, Node> ancestorFinder = new _08_FirstCommonAccestor();

        final Node child = node(1);
        final Node parent = node(2, child, NIL);

        assertEquals(parent, ancestorFinder.apply(child, parent));
    }

    @Test
    void applyNodesWithCommonRoot() {
        final BiFunction<Node, Node, Node> ancestorFinder = new _08_FirstCommonAccestor();

        final Node node_1 = node(1);
        final Node node_2 = node(2, node_1, NIL);
        final Node node_5 = node(5);
        final Node node_4 = node(4, NIL, node_5);
        final Node root = node(3, node_2, node_4);

        assertEquals(root, ancestorFinder.apply(node_1, node_5));
    }

    @Test
    void applyNodesWithCommonRootChild() {
        final BiFunction<Node, Node, Node> ancestorFinder = new _08_FirstCommonAccestor();

        final Node node_1 = node(1);
        final Node node_2 = node(2, node_1, NIL);
        final Node node_5 = node(5);
        final Node node_4 = node(4, NIL, node_5);
        final Node node_3 = node(3, node_2, node_4);
        node(7, node_3, NIL);

        assertEquals(node_3, ancestorFinder.apply(node_1, node_5));
    }
}