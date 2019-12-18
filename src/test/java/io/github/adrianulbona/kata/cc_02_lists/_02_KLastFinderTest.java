package io.github.adrianulbona.kata.cc_02_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static io.github.adrianulbona.kata.cc_02_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_02_lists.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _02_KLastFinderTest {

    private BiFunction<Integer, Node, Node> finder;

    @BeforeEach
    void setUp() {
        this.finder = new _02_KLastFinder();
    }

    @Test
    void applyNil() {
        assertEquals(NIL, this.finder.apply(1, NIL));
    }

    @Test
    void apply2ndLastFrom3Nodes() {
        final Node list = node(1, node(2, node(3)));
        assertEquals(2, this.finder.apply(2, list).value());
    }
}