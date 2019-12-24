package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _12_QueensSolverTest {

    @Test
    void apply() {
        final Function<List<Coord>, Stream<List<Coord>>> solver = new _12_QueensSolver();
        assertEquals(92, solver.apply(List.of()).count());
    }
}