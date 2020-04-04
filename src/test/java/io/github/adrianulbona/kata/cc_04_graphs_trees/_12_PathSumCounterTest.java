package io.github.adrianulbona.kata.cc_04_graphs_trees;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.NIL;
import static io.github.adrianulbona.kata.cc_04_graphs_trees.Node.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _12_PathSumCounterTest {

    @Test
    void applyTreeWith3SubPathsWithSum8() {
        final BiFunction<Node, Integer, Integer> counter = new _12_PathSumCounter();

        final Node tree = node(10,
                node(5,
                        node(3, node(3), node(-2)),
                        node(1, NIL, node(2))),
                node(-3, NIL, node(11)));

        assertEquals(3, counter.apply(tree, 8));
    }

    @Test
    void applySequenceWithXSubPathsWithSum8() {
        final BiFunction<Node, Integer, Integer> counter = new _12_PathSumCounter();

        final Node sequence = node(10,
                node(5,
                        node(1,
                                node(2,
                                        node(-1,
                                                node(-1,
                                                        node(7,
                                                                node(1,
                                                                        node(2),
                                                                        NIL),
                                                                NIL),
                                                        NIL),
                                                NIL),
                                        NIL),
                                NIL),
                        NIL),
                NIL);

        assertEquals(5, counter.apply(sequence, 8));
    }
}
