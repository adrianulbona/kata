package io.github.adrianulbona.kata.cc_08_recursion_dynamic;

import io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Grid;
import io.github.adrianulbona.kata.cc_08_recursion_dynamic._02_RobotWalker.Coord;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _02_RobotWalkerTest {

    @Test
    void apply1x1Grid() {
        final Function<Grid, List<Coord>> walker = new _02_RobotWalker();
        final Grid emptyGrid = Grid.of(1, 1, Set.of());
        assertEquals(List.of(Coord.of(0,0)), walker.apply(emptyGrid));
    }

    @Test
    void apply2x2Grid() {
        final Function<Grid, List<Coord>> walker = new _02_RobotWalker();
        final Grid grid = new Grid(2, 2, Set.of());
        final List<Coord> path = List.of(Coord.of(0, 0), Coord.of(1, 0), Coord.of(1, 1));
        assertEquals(path, walker.apply(grid));
    }

    @Test
    void apply2x2GridWithOffLimitCell() {
        final Function<Grid, List<Coord>> walker = new _02_RobotWalker();
        final Grid grid = new Grid(2, 2, Set.of(Coord.of(1, 0)));
        final List<Coord> path = List.of(Coord.of(0, 0), Coord.of(0, 1), Coord.of(1, 1));
        assertEquals(path, walker.apply(grid));
    }
}