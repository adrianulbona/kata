package io.github.adrianulbona.kata.cc_4_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_4_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _02_Array2TreeTest {

    @Test
    void testEmpty() {
        final Function<int[], Optional<Node>> transformer = new _02_Array2Tree();
        assertTrue(transformer.apply(new int[]{}).isEmpty());
    }

    @Test
    void test1234567() {
        final Function<int[], Optional<Node>> transformer = new _02_Array2Tree();

        final Node expected = node(4, node(2, node(1), node(3)), node(6, node(5), node(7)));
        assertEquals(expected, transformer.apply(new int[]{1, 2, 3, 4, 5, 6, 7}).orElseThrow());
    }
}
