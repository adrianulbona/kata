package io.github.adrianulbona.kata.cc_2_lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_2_lists.Node.NIL;
import static io.github.adrianulbona.kata.cc_2_lists.Node.node;
import static org.junit.jupiter.api.Assertions.*;

class _01_DuplicatesRemoverTest {

    private Function<Node, Node> remover;

    @BeforeEach
    void setUp() {
        this.remover = new _01_DuplicatesRemover();
    }

    @Test
    void applyNil() {
        assertEquals(NIL, this.remover.apply(NIL));
    }

    @Test
    void applyNonDuplicates() {
        final Node list = node(1, node(2, node(3, NIL)));
        assertEquals(list, this.remover.apply(list));
    }

    @Test
    void applyDuplicates() {
        final Node list = node(1, node(2, node(3, node(1, node(1, node(3, NIL))))));
        final Node cleaned = node(1, node(2, node(3, NIL)));
        assertEquals(cleaned, this.remover.apply(list));
    }
}