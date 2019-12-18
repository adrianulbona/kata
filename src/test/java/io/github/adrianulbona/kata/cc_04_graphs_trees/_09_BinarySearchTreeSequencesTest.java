package io.github.adrianulbona.kata.cc_04_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _09_BinarySearchTreeSequencesTest {

    @Test
    void apply3Nodes() {
        final Function<Node, Set<List<Integer>>> sequencer = new _09_BinarySearchTreeSequences();

        final Node tree = node(2, node(1), node(3));

        assertEquals(Set.of(List.of(2, 1, 3), List.of(2, 3, 1)), sequencer.apply(tree));
    }
}
