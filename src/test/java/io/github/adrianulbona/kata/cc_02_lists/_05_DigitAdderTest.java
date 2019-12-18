package io.github.adrianulbona.kata.cc_02_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_02_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_02_lists.Node.node;
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

    @Test
    void apply716and592reversed() {
        final Node x = node(6, node(1, node(7)));
        final Node y = node(2, node(9, node(5)));
        final Node expected = node(9, node(1, node(2)));
        assertEquals(expected, this.adder.apply(x.reverse(), y.reverse()).reverse());
    }

    @Test
    void reverseNIL() {
        assertEquals(NIL, NIL.reverse());
    }

    @Test
    void reverse1() {
        assertEquals(node(1), node(1).reverse());
    }

    @Test
    void reverse21() {
        final Node input = node(2, node(1));
        final Node expected = node(1, node(2));
        assertEquals(expected, input.reverse());
    }
}
