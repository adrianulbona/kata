package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _13_BoxStackerTest {

    private Function<List<Box>, Integer> stacker;

    @BeforeEach
    void setUp() {
        this.stacker = new _13_BoxStacker();
    }

    @Test
    void apply() {
        final List<Box> boxes = List.of(
                Box.of(2, 2, 2),
                Box.of(1, 1, 1),
                Box.of(4, 4, 4),
                Box.of(3, 1, 1));

        assertEquals(7, this.stacker.apply(boxes));
    }
}
