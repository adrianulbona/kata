package io.github.adrianulbona.kata.cc_2_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_2_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_2_lists.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _05_DigitAdderTest {

    private BiFunction<Node, Node, Node> adder;

    @BeforeEach
    void setUp() {
        this.adder = new _05_DigitAdder();
    }

    @Test
    void applyNILandNIL() {
        assertEquals(NIL, this.adder.apply(NIL, NIL));
    }

    @Test
    void apply716andNIL() {
        final Node x = node(7, node(1, node(6)));
        assertEquals(x, this.adder.apply(x, NIL));
    }

    @Test
    void apply716and592() {
        final Node x = node(7, node(1, node(6)));
        final Node y = node(5, node(9, node(2)));
        final Node expected = node(2, node(1, node(9)));
        assertEquals(expected, this.adder.apply(x, y));
    }
}