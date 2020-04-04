package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Grid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static io.github.adrianulbona.kata.cc_08_recursion_dynamic.Coord.coord;
import static org.junit.jupiter.api.Assertions.assertEquals;

class _02_RobotWalkerTest {

    private Function<Grid, Set<List<Coord>>> walker;

    @BeforeEach
    void setUp() {
        this.walker = new _02_RobotWalker();
    }

    @Test
    void apply1x1Grid() {
        final Grid emptyGrid = Grid.of(1, 1, Set.of());

        assertEquals(Set.of(List.of(coord(0,0))), this.walker.apply(emptyGrid));
    }

    @Test
    void apply2x2Grid() {
        final Grid grid = new Grid(2, 2, Set.of());
        final List<Coord> firstPath = List.of(coord(0, 0), coord(1, 0), coord(1, 1));
        final List<Coord> secondPath = List.of(coord(0, 0), coord(0, 1), coord(1, 1));

        assertEquals(Set.of(firstPath, secondPath), this.walker.apply(grid));
    }

    @Test
    void apply2x2GridWithOffLimitCell() {
        final Grid grid = new Grid(2, 2, Set.of(coord(1, 0)));
        final List<Coord> path = List.of(coord(0, 0), coord(0, 1), coord(1, 1));

        assertEquals(Set.of(path), this.walker.apply(grid));
    }
}
