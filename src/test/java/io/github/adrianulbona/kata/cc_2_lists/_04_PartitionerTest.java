package io.github.adrianulbona.kata.cc_2_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_2_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_2_lists.Node.node;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _04_PartitionerTest {

    private BiFunction<Node, Integer, Node> partitioner;

    @BeforeEach
    void setUp() {
        this.partitioner = new _04_Partitioner();
    }

    @Test
    void partitionNil() {
        assertEquals(NIL, this.partitioner.apply(NIL, 0));
    }

    @Test
    void partitionAllSmaller() {
        final Node input = node(1, node(2, node(3, NIL)));
        assertEquals(input, this.partitioner.apply(input, 4));
    }

    @Test
    void partitionSomeSmallerSomeBigger() {
        final Node input = node(1, node(5, node(2, node(3, node(2, NIL)))));
        final Node expected = node(1, node(2, node(2, node(5, node(3, NIL)))));
        assertEquals(expected, this.partitioner.apply(input, 3));
    }
}