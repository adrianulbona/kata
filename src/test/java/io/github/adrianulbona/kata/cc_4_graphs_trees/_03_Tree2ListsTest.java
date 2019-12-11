package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _03_Tree2ListsTest {

    @Test
    void apply1Level() {
        final Function<Node, Map<Integer, List<Integer>>> transformer = new _03_Tree2Lists();

        final Map<Integer, List<Integer>> actual = transformer.apply(node(1));
        assertEquals(1, actual.size());
        assertEquals(List.of(1), actual.get(1));
    }

    @Test
    void apply3Levels() {
        final Function<Node, Map<Integer, List<Integer>>> transformer = new _03_Tree2Lists();

        final Node tree = node(4, node(2, node(1), node(3)), node(6, node(5), node(7)));
        final Map<Integer, List<Integer>> actual = transformer.apply(tree);
        assertEquals(3, actual.size());
        assertEquals(List.of(4), actual.get(1));
        assertEquals(List.of(2, 6), actual.get(2));
        assertEquals(List.of(1, 3, 5, 7), actual.get(3));
    }
}
